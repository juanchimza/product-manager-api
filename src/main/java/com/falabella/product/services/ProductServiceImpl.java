package com.falabella.product.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.falabella.product.domain.BrandEntity;
import com.falabella.product.domain.ImageEntity;
import com.falabella.product.domain.ProductEntity;
import com.falabella.product.dto.ProductRequestDTO;
import com.falabella.product.dto.ProductResponseDTO;
import com.falabella.product.factories.ProductFactory;
import com.falabella.product.repository.BrandRepository;
import com.falabella.product.repository.ImageRepository;
import com.falabella.product.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

   private final ProductFactory productFactory;

   private final ProductRepository productRepository;
   private final BrandRepository brandRepository;
   private final ImageRepository imageRepository;

   private final Logger logger;

   public ProductServiceImpl(@Autowired ProductFactory productFactory, @Autowired ProductRepository productRepository,
         @Autowired BrandRepository brandRepository, @Autowired ImageRepository imageRepository) {
      this.productFactory = productFactory;
      this.productRepository = productRepository;
      this.brandRepository = brandRepository;
      this.imageRepository = imageRepository;
      this.logger = LoggerFactory.getLogger(ProductServiceImpl.class);
   }

   @Override
   public Optional<ProductResponseDTO> getProductBySKU(String sku) {
      Optional<ProductEntity> productEntityOpt = productRepository.findBySku(sku);
      return productEntityOpt.map(productFactory::convertProductOnDTO);
   }

   @Override
   public Boolean createProduct(ProductResponseDTO productResponseDTO) {
      try {
         ProductEntity productEntity = productFactory.createProduct(productResponseDTO);
         if (Objects.nonNull(productEntity)) {
            productRepository.save(productEntity);
            logger.info("Product {} created.", productEntity.getId());
         } else {
            logger.error("Product {} NOT created.", productResponseDTO.getId());
         }
      } catch (Exception e) {
         logger.error(e.getMessage());
         return false;
      }
      return true;
   }

   @Override
   public Boolean updateProduct(String sku, ProductRequestDTO productRequestDTO) {
      try {
         Optional<ProductEntity> productEntityOpt = productRepository.findBySku(sku);
         if (productEntityOpt.isPresent()) {
            ProductEntity productEntity = productEntityOpt.get();
            Optional<BrandEntity> brandEntityOpt = brandRepository.findById(productRequestDTO.getBrandId());
            BrandEntity brandEntity = brandEntityOpt.orElse(null);
            Optional<ImageEntity> imageEntityOpt = imageRepository.findById(productRequestDTO.getImageMainId());
            ImageEntity imageEntity = imageEntityOpt.orElse(null);
            if (brandEntity != null && imageEntity != null) {
               productEntity.setName(productRequestDTO.getName());
               productEntity.setBrand(brandEntity);
               productEntity.setSize(productRequestDTO.getSize());
               productEntity.setPrice(productRequestDTO.getPrice());
               productEntity.setImageMain(imageEntity);

               productRepository.save(productEntity);
               logger.info("Product {} updated.", productEntity.getId());
            } else {
               logger.error("Product {} NOT updated.", productEntity.getId());
               return false;
            }
         }
      } catch (Exception e) {
         logger.error(e.getMessage());
         return false;
      }
      return true;
   }

   @Override
   public Boolean deleteProduct(String sku) {
      try {
      Optional<ProductEntity> productEntityOpt = productRepository.findBySku(sku);
         if (productEntityOpt.isPresent()) {
            ProductEntity productEntity = productEntityOpt.get();
            productRepository.delete(productEntity);
            logger.info("Product {} deleted.", sku);
         } else {
            logger.error("Product {} NOT deleted.", sku);
         }
      } catch (Exception e) {
         logger.error(e.getMessage());
         return false;
      }
      return true;
   }

   @Override
   public Optional<List<ProductResponseDTO>> getAllProducts() {
      List<ProductEntity> productEntities = productRepository.findAll();
      List<ProductResponseDTO> productResponseDTOS = new ArrayList<>();
      productEntities.stream().forEach(productEntity -> productResponseDTOS.add(getProductBySKU(productEntity.getSku()).get()));
      return Optional.of(productResponseDTOS);
   }
}

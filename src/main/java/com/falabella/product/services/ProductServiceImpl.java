package com.falabella.product.services;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.falabella.product.domain.ProductEntity;
import com.falabella.product.dto.ProductDTO;
import com.falabella.product.factories.ProductFactory;
import com.falabella.product.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

   private final ProductFactory productFactory;
   private final ProductRepository productRepository;
   private final Logger logger;

   @Override
   public Optional<ProductDTO> getProductBySKU(String sku) {
      Optional<ProductEntity> productEntity = productRepository.findBySku(sku);
      return productEntity.map(product -> Optional.ofNullable(productFactory.convertProductOnDTO(product))).orElse(null);
   }

   @Override
   public boolean createProduct(ProductDTO productDTO) {
      try {
         ProductEntity product = productFactory.createProduct(productDTO);
         productRepository.save(product);
      } catch (Exception e) {
         logger.error(e.getMessage());
         return false;
      }
      return true;
   }

   public ProductServiceImpl(@Autowired ProductFactory productFactory,@Autowired ProductRepository productRepository) {
      this.productFactory = productFactory;
      this.productRepository = productRepository;
      this.logger = LoggerFactory.getLogger(ProductServiceImpl.class);
   }
}

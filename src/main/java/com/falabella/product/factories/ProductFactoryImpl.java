package com.falabella.product.factories;

import java.util.Objects;

import org.springframework.stereotype.Component;

import com.falabella.product.domain.ProductEntity;
import com.falabella.product.dto.ProductResponseDTO;

@Component
public class ProductFactoryImpl implements ProductFactory {

   @Override
   public ProductEntity createProduct(ProductResponseDTO productResponseDTO) {
      return new ProductEntity();
   }

   @Override
   public ProductResponseDTO convertProductOnDTO(ProductEntity productEntity) {
      return Objects.nonNull(productEntity) ? new ProductResponseDTO(productEntity.getId(), productEntity.getSku(), productEntity.getName(), productEntity.getBrand().getName(),
            productEntity.getSize(), productEntity.getPrice(), productEntity.getImageMain().getUrl()) : null;
   }
}

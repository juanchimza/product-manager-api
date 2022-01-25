package com.falabella.product.factories;

import java.util.Objects;

import org.springframework.stereotype.Component;

import com.falabella.product.domain.ProductEntity;
import com.falabella.product.dto.ProductDTO;

@Component
public class ProductFactoryImpl implements ProductFactory {

   @Override
   public ProductEntity createProduct(ProductDTO productDTO) {
      return new ProductEntity();
   }

   @Override
   public ProductDTO convertProductOnDTO(ProductEntity productEntity) {
      return Objects.nonNull(productEntity) ? new ProductDTO(productEntity) : new ProductDTO();
   }
}

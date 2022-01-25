package com.falabella.product.factories;

import com.falabella.product.domain.ProductEntity;
import com.falabella.product.dto.ProductResponseDTO;

public interface ProductFactory {
   ProductEntity createProduct(ProductResponseDTO productResponseDTO);
   ProductResponseDTO convertProductOnDTO(ProductEntity productEntity);
}

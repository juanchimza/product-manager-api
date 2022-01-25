package com.falabella.product.factories;

import com.falabella.product.domain.ProductEntity;
import com.falabella.product.dto.ProductDTO;

public interface ProductFactory {
   ProductEntity createProduct(ProductDTO productDTO);
   ProductDTO convertProductOnDTO(ProductEntity productEntity);
}

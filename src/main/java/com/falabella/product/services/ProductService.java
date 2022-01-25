package com.falabella.product.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.falabella.product.dto.ProductDTO;

@Service
public interface ProductService {
   Optional<ProductDTO> getProductBySKU(String sku);
   boolean createProduct(ProductDTO productDTO);
}

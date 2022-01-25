package com.falabella.product.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.falabella.product.dto.ProductRequestDTO;
import com.falabella.product.dto.ProductResponseDTO;

@Service
public interface ProductService {
   Optional<ProductResponseDTO> getProductBySKU(String sku);
   Boolean createProduct(ProductResponseDTO productResponseDTO);
   Boolean updateProduct(String sku, ProductRequestDTO productRequestDTO);
   Boolean deleteProduct(String sku);
   Optional<List<ProductResponseDTO>> getAllProducts();
}

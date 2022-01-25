package com.falabella.product.api;

import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.falabella.product.dto.ProductRequestDTO;
import com.falabella.product.dto.ProductResponseDTO;
import com.falabella.product.exceptions.RequestException;
import com.falabella.product.services.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {

   private final ProductService productService;

   public ProductController(@Autowired ProductService productService) {
      this.productService = productService;
   }

   @GetMapping("/{sku}/sku")
   public ResponseEntity<ProductResponseDTO> getProduct(@PathVariable("sku") String sku) {
      try {
         if(Objects.isNull(sku)) throw new RequestException();
         Optional<ProductResponseDTO> productDTO = productService.getProductBySKU(sku);
         return productDTO.map(dto -> new ResponseEntity<>(dto, HttpStatus.OK)).orElseGet(() -> ResponseEntity.notFound().build());
      }catch (RequestException ex){
         return new ResponseEntity<>(new ProductResponseDTO(), HttpStatus.BAD_REQUEST);
      }
   }

   @PostMapping("/")
   public ResponseEntity<ProductResponseDTO> createProduct(@RequestBody ProductResponseDTO productResponseDTO) {
      try {
         if (Objects.isNull(productResponseDTO)) throw new RequestException();
         if (Boolean.TRUE.equals(productService.createProduct(productResponseDTO)))
            return new ResponseEntity<>(productResponseDTO, HttpStatus.CREATED);
         else
            return new ResponseEntity<>(productResponseDTO, HttpStatus.NOT_MODIFIED);
      } catch (RequestException ex) {
         return new ResponseEntity<>(productResponseDTO, HttpStatus.BAD_REQUEST);
      }
   }

   @PatchMapping("/{sku}/sku")
   public ResponseEntity<Boolean> updateProduct(@PathVariable("sku") String sku, @RequestBody ProductRequestDTO productRequestDTO){
      try {
         if(Objects.isNull(productRequestDTO)) throw new RequestException();
         if (Boolean.TRUE.equals(productService.updateProduct(sku, productRequestDTO)))
            return new ResponseEntity<>(Boolean.TRUE, HttpStatus.ACCEPTED);
         else
            return new ResponseEntity<>(Boolean.FALSE, HttpStatus.NOT_MODIFIED);
      }catch (RequestException ex){
         return new ResponseEntity<>(Boolean.FALSE, HttpStatus.BAD_REQUEST);
      }
   }

   // TODO DELETE product

   // TODO GET List with all products

}

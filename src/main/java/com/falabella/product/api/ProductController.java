package com.falabella.product.api;

import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.falabella.product.dto.ProductDTO;
import com.falabella.product.exceptions.RequestException;
import com.falabella.product.services.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {

   private final ProductService productService;

   @Autowired
   public ProductController(ProductService productService) {
      this.productService = productService;
   }

   @GetMapping("/{sku}/sku")
   public ResponseEntity<ProductDTO> getProduct(@PathVariable("sku") String productSku) {
      try {
         if(Objects.isNull(productSku)) throw new RequestException();
         Optional<ProductDTO> productDTO = productService.getProductBySKU(productSku);
         return productDTO.map(dto -> new ResponseEntity<>(dto, HttpStatus.OK)).orElseGet(() -> ResponseEntity.notFound().build());
      }catch (RequestException ex){
         return new ResponseEntity<>(new ProductDTO(), HttpStatus.BAD_REQUEST);
      }
   }

   @PostMapping("/")
   public ResponseEntity<ProductDTO> createProduct(@RequestBody ProductDTO productDTO){
      try {
         if(Objects.isNull(productDTO)) throw new RequestException();
         if (Boolean.TRUE.equals(productService.createProduct(productDTO)))
            return new ResponseEntity<>(productDTO, HttpStatus.CREATED);
         else
            return new ResponseEntity<>(productDTO, HttpStatus.NOT_MODIFIED);
      }catch (RequestException ex){
         return new ResponseEntity<>(productDTO, HttpStatus.BAD_REQUEST);
      }
   }

   // TODO PATCH product

   // TODO DELETE product

   // TODO GET List with all products

}

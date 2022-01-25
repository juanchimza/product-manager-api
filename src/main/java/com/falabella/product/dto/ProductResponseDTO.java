package com.falabella.product.dto;

import java.math.BigDecimal;

public class ProductResponseDTO {

   Long id;
   String sku;
   String name;
   String brandName;
   Integer size;
   BigDecimal price;
   String imageMainUrl;

   public ProductResponseDTO() {
   }

   public ProductResponseDTO(Long id, String sku, String name, String brandName, Integer size, BigDecimal price, String imageMainUrl) {
      this.id = id;
      this.sku = sku;
      this.name = name;
      this.brandName = brandName;
      this.size = size;
      this.price = price;
      this.imageMainUrl = imageMainUrl;
   }

   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public String getSku() {
      return sku;
   }

   public void setSku(String sku) {
      this.sku = sku;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public String getBrandName() {
      return brandName;
   }

   public void setBrandName(String brandName) {
      this.brandName = brandName;
   }

   public Integer getSize() {
      return size;
   }

   public void setSize(Integer size) {
      this.size = size;
   }

   public BigDecimal getPrice() {
      return price;
   }

   public void setPrice(BigDecimal price) {
      this.price = price;
   }

   public String getImageMainUrl() {
      return imageMainUrl;
   }

   public void setImageMainUrl(String imageMainUrl) {
      this.imageMainUrl = imageMainUrl;
   }
}

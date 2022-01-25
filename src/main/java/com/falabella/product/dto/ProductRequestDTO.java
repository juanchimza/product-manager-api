package com.falabella.product.dto;

import java.math.BigDecimal;

public class ProductRequestDTO {

   private Long id;
   private String sku;
   private String name;
   private Long brandId;
   private Integer size;
   private BigDecimal price;
   private Long imageMainId;

   public ProductRequestDTO() {
   }

   public ProductRequestDTO(Long id, String sku, String name, Long brandId, Integer size, BigDecimal price, Long imageMainId) {
      this.id = id;
      this.sku = sku;
      this.name = name;
      this.brandId = brandId;
      this.size = size;
      this.price = price;
      this.imageMainId = imageMainId;
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

   public Long getBrandId() {
      return brandId;
   }

   public void setBrandId(Long brandId) {
      this.brandId = brandId;
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

   public Long getImageMainId() {
      return imageMainId;
   }

   public void setImageMainId(Long imageMainId) {
      this.imageMainId = imageMainId;
   }
}

package com.falabella.product.dto;

import java.math.BigDecimal;

import com.falabella.product.domain.ProductEntity;

public class ProductDTO {

   String sku;
   String name;
   String brand;
   Integer size;
   BigDecimal price;
   String imageMain;

   public ProductDTO(String sku, String name, String brand, Integer size, BigDecimal price, String imageMain) {
      this.sku = sku;
      this.name = name;
      this.brand = brand;
      this.size = size;
      this.price = price;
      this.imageMain = imageMain;
   }

   public ProductDTO(ProductEntity productEntity) {
      this.sku = productEntity.getSku();
      this.name = productEntity.getName();
      this.brand = productEntity.getBrand().getName();
      this.size = productEntity.getSize();
      this.price = productEntity.getPrice();
      this.imageMain = productEntity.getImageMain().getUrl();
   }

   public ProductDTO() {

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

   public String getBrand() {
      return brand;
   }

   public void setBrand(String brand) {
      this.brand = brand;
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

   public String getImageMain() {
      return imageMain;
   }

   public void setImageMain(String imageMain) {
      this.imageMain = imageMain;
   }
}

package com.falabella.product.domain;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class ProductEntity {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   private String sku;
   private String name;
   @ManyToOne
   private BrandEntity brand;
   private Integer size;
   private BigDecimal price;
   @OneToOne
   private ImageEntity imageMain;
   @OneToMany
   private List<ImageEntity> imagesOfProduct;

   public ProductEntity() {
   }

   public ProductEntity(String sku, String name, BrandEntity brand, Integer size, BigDecimal price, ImageEntity imageMain,
         List<ImageEntity> imagesOfProduct) {
      this.sku = sku;
      this.name = name;
      this.brand = brand;
      this.size = size;
      this.price = price;
      this.imageMain = imageMain;
      this.imagesOfProduct = imagesOfProduct;
   }

   public Long getId() {
      return id;
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

   public BrandEntity getBrand() {
      return brand;
   }

   public void setBrand(BrandEntity brand) {
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

   public ImageEntity getImageMain() {
      return imageMain;
   }

   public void setImageMain(ImageEntity imageMain) {
      this.imageMain = imageMain;
   }

   public List<ImageEntity> getImagesOfProduct() {
      return imagesOfProduct;
   }

   public void setImagesOfProduct(List<ImageEntity> imagesOfProduct) {
      this.imagesOfProduct = imagesOfProduct;
   }
}

package com.falabella.product.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "images", schema = "product_manager")
public class ImageEntity {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   private String url;

   public ImageEntity() {
   }

   public ImageEntity(String url) {
      this.url = url;
   }

   public Long getId() {
      return id;
   }

   public String getUrl() {
      return url;
   }

   public void setUrl(String url) {
      this.url = url;
   }
}

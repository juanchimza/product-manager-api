package com.falabella.product.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "brands", schema = "product_manager")
public class BrandEntity {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   private String name;
   @OneToOne
   private ImageEntity logo;

   public BrandEntity() {
   }

   public BrandEntity(String name, ImageEntity logo) {
      this.name = name;
      this.logo = logo;
   }

   public Long getId() {
      return id;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public ImageEntity getLogo() {
      return logo;
   }

   public void setLogo(ImageEntity logo) {
      this.logo = logo;
   }
}

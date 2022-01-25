package com.falabella.product.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.falabella.product.domain.ImageEntity;

@Repository
public interface ImageRepository extends JpaRepository <ImageEntity, Long> {

   Optional<ImageEntity> findByName(String brand);
}


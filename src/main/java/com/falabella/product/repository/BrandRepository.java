package com.falabella.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.falabella.product.domain.BrandEntity;

@Repository
public interface BrandRepository extends JpaRepository<BrandEntity, Long> {

}

package com.sriram.ecommerce.product.repositoty;

import com.sriram.ecommerce.product.model.ProductImage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductImageRepository extends JpaRepository<ProductImage, Integer> {
  }
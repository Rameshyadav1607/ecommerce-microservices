package com.sriram.ecommerce.product.repositoty;

import com.sriram.ecommerce.product.model.ProductVariant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductVariantRepository extends JpaRepository<ProductVariant, Integer> {
}
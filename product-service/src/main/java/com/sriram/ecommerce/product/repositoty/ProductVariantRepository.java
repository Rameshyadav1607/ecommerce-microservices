package com.sriram.ecommerce.product.repositoty;

import com.sriram.ecommerce.product.model.ProductVariant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductVariantRepository extends JpaRepository<ProductVariant, Integer> {
    Optional<ProductVariant> findByVariantId(Integer variantId);
}
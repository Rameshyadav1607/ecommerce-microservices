package com.sriram.ecommerce.product.repositoty;

import com.sriram.ecommerce.product.model.SubCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubCategoryRepository extends JpaRepository<SubCategory, Integer> {
}
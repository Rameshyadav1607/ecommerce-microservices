package com.sriram.ecommerce.product.repositoty;

import com.sriram.ecommerce.product.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
  Category findByCategoryName(String categoryName);
  @Query("Select c.categoryName from Category c")
  List<String> findAllCategoryName();

}
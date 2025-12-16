package com.sriram.ecommerce.product.repositoty;

import com.sriram.ecommerce.product.model.SubCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SubCategoryRepository extends JpaRepository<SubCategory, Integer> {
    SubCategory findByCategoryName(String catogoryName);

    @Query("select subc.categoryName from SubCategory subc")
    List<String> getAllSubcatogryName();

      SubCategory findBySubCategoryId(Integer subCategoryId);
}
package com.sriram.ecommerce.product.repositoty;

import com.sriram.ecommerce.product.model.ParentCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ParentCategoryRepository extends JpaRepository<ParentCategory, Integer> {

    ParentCategory findByCategoryName(String categoryName);

    @Query("SELECT pt.categoryName from ParentCategory pt")
    List<String> getParentCategorys();


    ParentCategory findByParentCategoryId(Integer parentCategoryId);
}
package com.sriram.ecommerce.product.repositoty;

import com.sriram.ecommerce.product.model.Color;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ColourRepository extends JpaRepository<Color, Integer> {
    Color findByColorName(String colorName);
    @Query("select c.colorName from Color c")
    List<String> findByColorNames();
}
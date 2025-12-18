package com.sriram.ecommerce.product.resource;

import com.sriram.ecommerce.product.service.SubCategoryService;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/subcategory")
@Validated
public class SubCategoryResource {
    @Autowired
    SubCategoryService subCategoryService;
    @PostMapping("/{parent_category_id}/{catogoryName}")
    public ResponseEntity<String> createSubCategory(@PathVariable @NotNull(message = "parent categoryid required") Integer parent_category_id, @PathVariable @NotBlank(message = "catogory name is required") String catogoryName){
        return  subCategoryService.createSubCategory(parent_category_id,catogoryName);
    }
    @GetMapping
    public List<String> getAllSubCategory(){
     return  subCategoryService.getAllSubCategory();
    }

}
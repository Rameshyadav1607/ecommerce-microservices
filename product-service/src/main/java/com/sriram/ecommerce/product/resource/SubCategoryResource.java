package com.sriram.ecommerce.product.resource;

import com.sriram.ecommerce.product.service.SubCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/subcategory")
public class SubCategoryResource {
    @Autowired
    SubCategoryService subCategoryService;
    @PostMapping("/{parent_category_id}/{catogoryName}")
    public ResponseEntity<String> createSubCategory(@PathVariable Integer parent_category_id,@PathVariable String catogoryName){
        return  subCategoryService.createSubCategory(parent_category_id,catogoryName);
    }
    @GetMapping
    public List<String> getAllSubCategory(){
     return  subCategoryService.getAllSubCategory();
    }

}
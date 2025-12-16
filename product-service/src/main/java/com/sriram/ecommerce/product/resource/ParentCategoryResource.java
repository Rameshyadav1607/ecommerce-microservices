package com.sriram.ecommerce.product.resource;

import com.sriram.ecommerce.product.service.ParentCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/parentcategory")
public class ParentCategoryResource {

    @Autowired
    ParentCategoryService parentCategoryService;
    @PostMapping("/{categoryName}")
    public String  createOrUpdatedParentCategory(@PathVariable String categoryName){
        return  parentCategoryService.createOrUpdatedParentCategory(categoryName);
    }

    @GetMapping
    public List<String> getParentCategoryNames(){
        return parentCategoryService.getParentCategoryName();
    }
    @DeleteMapping("/{catageryId}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Integer catageryId){
        return  parentCategoryService.deleteCategory(catageryId);

    }

}

package com.sriram.ecommerce.product.resource;

import com.sriram.ecommerce.product.service.ParentCategoryService;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/parentcategory")
@Validated
public class ParentCategoryResource {

    @Autowired
    private ParentCategoryService parentCategoryService;
    @PostMapping("/{categoryName}")
    public String  createOrUpdatedParentCategory(@PathVariable @NotBlank(message = "catogory name is required") String categoryName){
        return  parentCategoryService.createOrUpdatedParentCategory(categoryName);
    }

    @GetMapping
    public List<String> getParentCategoryNames(){
        return parentCategoryService.getParentCategoryName();
    }
    @DeleteMapping("/{catageryId}")
    @ResponseStatus(HttpStatus.CONFLICT)
    public ResponseEntity<Void> deleteCategory(@PathVariable @NotNull(message = "categoryid is required") Integer catageryId){
        return  parentCategoryService.deleteCategory(catageryId);

    }

}

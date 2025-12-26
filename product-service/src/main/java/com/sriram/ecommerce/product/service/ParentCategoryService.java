package com.sriram.ecommerce.product.service;

import com.sriram.ecommerce.product.domain.ParentCategoryResponse;
import com.sriram.ecommerce.product.domain.ParentSubCategoryDomain;
import com.sriram.ecommerce.product.domain.SubCategoryResponse;
import com.sriram.ecommerce.product.model.ParentCategory;
import com.sriram.ecommerce.product.repositoty.ParentCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.AbstractPersistable_;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ParentCategoryService {
    @Autowired
    private ParentCategoryRepository parentCategoryRepository;

    public String createOrUpdatedParentCategory(String categoryName) {
            ParentCategory  parentcategory=parentCategoryRepository.findByCategoryName(categoryName);
            if(parentcategory == null){
                parentcategory=new ParentCategory();
                parentcategory.setCreatedDate(LocalDate.now());

            }else{
                parentcategory.setUpdatedDate(LocalDate.now());
            }

            parentcategory.setCategoryName(categoryName);

            parentCategoryRepository.save(parentcategory);
            return "parent category saved";
    }

    public List<String> getParentCategoryName(){
        return parentCategoryRepository.getParentCategorys();
    }

    public ResponseEntity<Void> deleteCategory(Integer catageryId) {
       Boolean exists=parentCategoryRepository.existsById(catageryId);
       if(! exists){
           return ResponseEntity.notFound().build();
       }
        parentCategoryRepository.deleteById(catageryId);

       return  ResponseEntity.status(HttpStatus.OK).build();

    }

    public List<ParentCategoryResponse> getParentAndSubCategory() {

           List<ParentSubCategoryDomain>    parentSubCategoryDomain=parentCategoryRepository.fetchParentWithSubCatorys();
        Map<Integer, ParentCategoryResponse> map = new HashMap<>();
        for (ParentSubCategoryDomain row :parentSubCategoryDomain){
            ParentCategoryResponse parentCategoryResponse = map.computeIfAbsent(row.getParentCateoryId(), id ->
                    new ParentCategoryResponse(
                            row.getParentCateoryId(),
                            row.getParentCategoryName(),
                            new ArrayList<>()
                    )
            );
            parentCategoryResponse.getSubCategoryResponseList().add(new SubCategoryResponse(row.getSubCategoryId(), row.getSubCategoryName()));
        }

        return new ArrayList<>(map.values());
    }
}

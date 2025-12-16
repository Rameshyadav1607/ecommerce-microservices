package com.sriram.ecommerce.product.service;

import com.sriram.ecommerce.product.model.ParentCategory;
import com.sriram.ecommerce.product.model.SubCategory;
import com.sriram.ecommerce.product.repositoty.ParentCategoryRepository;
import com.sriram.ecommerce.product.repositoty.SubCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class SubCategoryService {
    @Autowired
    private SubCategoryRepository subCategoryRepository;
    @Autowired
    private ParentCategoryRepository parentCategoryRepository;

    public ResponseEntity<String> createSubCategory(Integer parentCategoryId, String catogoryName) {

        ParentCategory parentCategory = parentCategoryRepository.findByParentCategoryId(parentCategoryId);

        SubCategory subcategory = subCategoryRepository.findByCategoryName(catogoryName);
        if(subcategory == null){
            subcategory=new SubCategory();
            subcategory.setCreateDate(LocalDate.now());
        }else{
            subcategory.setUpdatedDate(LocalDate.now());
        }
        subcategory.setCategoryName(catogoryName);
        subcategory.setParentCategory(parentCategory);
        subCategoryRepository.save(subcategory);

        return  ResponseEntity.ok("sub catogory inserted or updated");
    }


    public List<String> getAllSubCategory() {
      List<String>  subcatogryName=subCategoryRepository.getAllSubcatogryName();
        return subcatogryName;
    }
}

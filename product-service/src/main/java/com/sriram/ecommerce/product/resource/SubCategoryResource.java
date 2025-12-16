package com.sriram.ecommerce.product.resource;

import com.sriram.ecommerce.product.service.SubCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/subcategory")
public class SubCategoryResource {
    @Autowired
    SubCategoryService subCategoryService;


}

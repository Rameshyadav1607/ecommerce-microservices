package com.sriram.ecommerce.product.domain;

import com.sriram.ecommerce.product.valid.CategoryValid;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@CategoryValid
public class CategoryDomain {
    private String categoryName;
    private String description;
    private Boolean isMainCategory;
    private String parentCategoryName;

}

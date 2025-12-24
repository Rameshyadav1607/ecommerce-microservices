package com.sriram.ecommerce.product.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@RequiredArgsConstructor
@AllArgsConstructor
public class ParentSubCategoryDomain {

    private Integer parentCateoryId;
    private String parentCategoryName;
    private Integer subCategoryId;
    private String subCategoryName;
}

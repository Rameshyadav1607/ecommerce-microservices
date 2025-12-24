package com.sriram.ecommerce.product.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@RequiredArgsConstructor
public class ParentCategoryResponse {
    private Integer parentCateoryId;
    private String parentCategoryName;
    private List<SubCategoryResponse> subCategoryResponseList;
}

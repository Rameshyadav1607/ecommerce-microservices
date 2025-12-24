package com.sriram.ecommerce.product.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@RequiredArgsConstructor
@AllArgsConstructor
public class ProductsDetails {
    private Integer productId;
    private String productName;
    private String brandName;
    private List<ProductVariantResponse> productVariantResponseList;
}

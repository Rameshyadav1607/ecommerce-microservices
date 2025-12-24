package com.sriram.ecommerce.product.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@RequiredArgsConstructor
public class ProductImageResponse {
    private Integer imageId;
    private String imageUrl;


}

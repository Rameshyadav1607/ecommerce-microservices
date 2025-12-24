package com.sriram.ecommerce.product.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
public class ProductVariantResponse {

    private Integer vaiantId;
    private String colorName;
    private BigDecimal price;
    private Integer stock;
    private List<ProductImageResponse> productImage;
}

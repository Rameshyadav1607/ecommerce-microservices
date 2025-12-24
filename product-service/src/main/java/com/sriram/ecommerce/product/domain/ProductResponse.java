package com.sriram.ecommerce.product.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
@RequiredArgsConstructor
public class ProductResponse {
    private Integer productId;
    private String productName;
    private Integer brandId;
    private String brandName;
    private Integer variantId;
    private String colorName;
    private BigDecimal price;
    private Integer stock;
    private Integer imageId;
    private String imageUrl;

    public ProductResponse(Integer productId, String productName,Integer brandId,String brandName, String colorName, Integer variantId, BigDecimal price, Integer stock, String imageUrl) {
        this.productId = productId;
        this.productName = productName;
        this.brandId=brandId;
        this.brandName = brandName;
        this.colorName = colorName;
        this.variantId = variantId;
        this.price = price;
        this.stock = stock;
        this.imageUrl = imageUrl;
    }


}

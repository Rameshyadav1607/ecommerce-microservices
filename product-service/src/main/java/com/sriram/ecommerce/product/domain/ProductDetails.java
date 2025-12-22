package com.sriram.ecommerce.product.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Setter
@Getter
@RequiredArgsConstructor
public class ProductDetails {
    private Integer productId;
    private Integer brandId;
    private String productName;
    private String brandName;
    private String colorName;
    private Integer variantId;
    private BigDecimal price;
    private Integer stock;
    private String imageUrl;

    public ProductDetails(Integer productId, String productName, String brandName, String colorName, Integer variantId, BigDecimal price, Integer stock, String imageUrl) {
        this.productId = productId;
        this.productName = productName;
        this.brandName = brandName;
        this.colorName = colorName;
        this.variantId = variantId;
        this.price = price;
        this.stock = stock;
        this.imageUrl = imageUrl;
    }


}

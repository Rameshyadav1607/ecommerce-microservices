package com.sriram.ecommerce.product.domain;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
public class ProductDetails {

    private Integer productId;
    private Integer brandId;
    private String productName;
    private String description;
    private Double unitPrice;
    private Integer quantity;
    private LocalDateTime createdDate;
    private LocalDateTime updateDate;
    private String colour;
    private String status;
}

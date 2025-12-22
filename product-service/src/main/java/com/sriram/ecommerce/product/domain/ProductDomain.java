package com.sriram.ecommerce.product.domain;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Setter
@Getter
public class ProductDomain {

    private Integer productId;
    private Integer brandId;
    private String productName;
    private String description;


}

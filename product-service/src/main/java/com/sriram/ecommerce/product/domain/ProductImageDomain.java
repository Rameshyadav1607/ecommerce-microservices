package com.sriram.ecommerce.product.domain;

import com.sriram.ecommerce.product.model.Product;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ProductImageDomain {

    private Product product;
    private String imageUrl;
    private Boolean isMain;
}

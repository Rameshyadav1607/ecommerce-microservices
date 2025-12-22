package com.sriram.ecommerce.product.domain;

import com.sriram.ecommerce.product.valid.ProductVariantValid;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
@ProductVariantValid
public class ProductVariantDomain {

    private Integer productId;
    private Integer colourId;
    private BigDecimal price;
    private Integer stock;
}

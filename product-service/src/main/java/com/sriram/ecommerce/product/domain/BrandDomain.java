package com.sriram.ecommerce.product.domain;

import com.sriram.ecommerce.product.validators.BrandValid;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@BrandValid
public class BrandDomain {

    private int brandId;
    private String brandName;
    private String description;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;

}

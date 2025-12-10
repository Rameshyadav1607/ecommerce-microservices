package com.sriram.ecommerce.product.resource;

import com.sriram.ecommerce.product.service.DiscountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DiscountResource {
    @Autowired
    private DiscountService discountService;
}

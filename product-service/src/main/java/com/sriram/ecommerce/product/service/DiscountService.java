package com.sriram.ecommerce.product.service;

import com.sriram.ecommerce.product.repositoty.DiscountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DiscountService  {
    @Autowired
    private DiscountRepository discountRepository;
}

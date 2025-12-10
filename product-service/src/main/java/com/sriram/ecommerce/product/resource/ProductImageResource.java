package com.sriram.ecommerce.product.resource;

import com.sriram.ecommerce.product.domain.ProductImageDomain;
import com.sriram.ecommerce.product.service.ProductImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/productimage")
public class ProductImageResource {
    @Autowired
    private ProductImageService productImageService;
    @PostMapping("/save")
    public String saveOrUpdate(@RequestBody ProductImageDomain productImageDomain){
        return productImageService.saveOrUpdate(productImageDomain);
    }
}

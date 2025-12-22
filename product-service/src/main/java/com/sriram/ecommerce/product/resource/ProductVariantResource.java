package com.sriram.ecommerce.product.resource;

import com.sriram.ecommerce.product.domain.ProductVariantDomain;
import com.sriram.ecommerce.product.service.ProductVariantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/productvariant")
public class ProductVariantResource {
    @Autowired
    private ProductVariantService productVariantService;
    @PostMapping
    public void createProductVariant(@Validated @RequestBody ProductVariantDomain productVariantDomain){
         productVariantService.createProductVariant(productVariantDomain);
    }
    @PutMapping("/{variantId}")
    public ResponseEntity<String> productVariantUpdate(@PathVariable Integer variantId,@Validated @RequestBody ProductVariantDomain productVariantDomain){
        return productVariantService.productVariantUpdate(variantId,productVariantDomain);

    }

}

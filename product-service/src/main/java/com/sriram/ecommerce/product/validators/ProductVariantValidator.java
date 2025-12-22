package com.sriram.ecommerce.product.validators;

import com.sriram.ecommerce.product.domain.ProductVariantDomain;
import com.sriram.ecommerce.product.repositoty.ColorRepository;
import com.sriram.ecommerce.product.repositoty.ProductRepository;
import com.sriram.ecommerce.product.repositoty.ProductVariantRepository;
import com.sriram.ecommerce.product.valid.ProductVariantValid;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

public class ProductVariantValidator  implements ConstraintValidator<ProductVariantValid, ProductVariantDomain> {

    @Autowired
    private ProductVariantRepository productVariantRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ColorRepository colorRepository;


    @Override
    public boolean isValid(ProductVariantDomain productVariantDomain, ConstraintValidatorContext constraintValidatorContext) {

       Boolean isProductVariantValid=true;

        if(productVariantDomain.getProductId() == null
                || productVariantDomain.getProductId()==0
                || !productRepository.existsById(productVariantDomain.getProductId()))
        {
            constraintValidatorContext.buildConstraintViolationWithTemplate("error.brand.productId.required")
                    .addPropertyNode("productId")
                    .addConstraintViolation();
            isProductVariantValid=false;

        }
        if(productVariantDomain.getColourId() ==null
                || productVariantDomain.getColourId()==0
                || !colorRepository.existsById(productVariantDomain.getColourId()))
        {
            constraintValidatorContext.buildConstraintViolationWithTemplate("error.brand.colourId.required")
                    .addPropertyNode("colourId")
                    .addConstraintViolation();
            isProductVariantValid=false;
        }

        if(productVariantDomain.getPrice() == null || productVariantDomain.getPrice().compareTo(BigDecimal.ZERO)<=0){
            constraintValidatorContext.buildConstraintViolationWithTemplate("error.product.price.required")
                    .addPropertyNode("price")
                    .addConstraintViolation();
            isProductVariantValid=false;
        }

        if(productVariantDomain.getStock() == null || productVariantDomain.getStock()<=0){
            constraintValidatorContext.buildConstraintViolationWithTemplate("error.product.stock.required")
                    .addPropertyNode("stock")
                    .addConstraintViolation();
            isProductVariantValid=false;
        }

        return isProductVariantValid;
    }

}

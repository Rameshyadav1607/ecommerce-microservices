package com.sriram.ecommerce.product.validators;

import com.sriram.ecommerce.product.domain.CategoryDomain;
import com.sriram.ecommerce.product.valid.CategoryValid;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CategoryValidator  implements ConstraintValidator<CategoryValid, CategoryDomain> {
    @Override
    public void initialize(CategoryValid constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(CategoryDomain categoryDomain, ConstraintValidatorContext context) {

        boolean isCategory=true;

        if(categoryDomain.getCategoryName()==null || categoryDomain.getCategoryName().isEmpty()){
            context.buildConstraintViolationWithTemplate("error.category.categoryname.required")
                    .addPropertyNode("categoryname")
                    .addConstraintViolation();
            isCategory=false;
        }

        if(categoryDomain.getIsMainCategory() == null || categoryDomain.getIsMainCategory().describeConstable().isEmpty()){
            context.buildConstraintViolationWithTemplate("error.category.isMainCategory.required")
                    .addPropertyNode("isMainCategory")
                    .addConstraintViolation();
            isCategory=false;
        }

        if(categoryDomain.getDescription()==null || categoryDomain.getDescription().isEmpty()){
            context.buildConstraintViolationWithTemplate("error.category.description.required")
                    .addPropertyNode("description")
                    .addConstraintViolation();
            isCategory=false;

        }
        return isCategory;
    }
}

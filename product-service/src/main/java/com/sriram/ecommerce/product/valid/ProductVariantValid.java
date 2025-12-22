package com.sriram.ecommerce.product.valid;

import com.sriram.ecommerce.product.validators.ProductVariantValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
@Target({METHOD, FIELD, TYPE, ANNOTATION_TYPE})
@Retention(RUNTIME)
@Constraint(validatedBy = {ProductVariantValidator.class})
public @interface ProductVariantValid {

    String message() default "{com.sairam.ecommerce-microservices.validators." +
            "ProductVariantValid.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}

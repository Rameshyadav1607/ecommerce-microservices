package com.sriram.ecommerce.product.exception;

public class ResourceNotFoundException  extends RuntimeException{

    public ResourceNotFoundException(String message) {
       super(message);
    }
}

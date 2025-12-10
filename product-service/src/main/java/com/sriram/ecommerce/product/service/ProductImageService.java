package com.sriram.ecommerce.product.service;

import com.sriram.ecommerce.product.domain.ProductImageDomain;
import com.sriram.ecommerce.product.model.Product;
import com.sriram.ecommerce.product.model.ProductImage;
import com.sriram.ecommerce.product.repositoty.ProductImageRepository;
import com.sriram.ecommerce.product.repositoty.ProductRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.OffsetDateTime;

@Service
public class ProductImageService {
    @Autowired
    private ProductImageRepository productImageRepository;
    @Autowired
    private ProductRepository productRepository;

    public String saveOrUpdate(ProductImageDomain productImageDomain) {

       ProductImage productImage = productImageRepository.findByProductProductName(productImageDomain.getProduct());

        Product product = productRepository.findByProductName(productImage.getProduct().getProductName());
        if(productImage!= null){
            productImage.setProduct(product);
            productImage.setImageUrl(productImageDomain.getImageUrl());
            productImage.setUploadedDate(LocalDate.now());
         }
         else{
             productImage=new ProductImage();
             productImage.setProduct(product);
             productImage.setImageUrl(productImageDomain.getImageUrl());
             productImage.setUploadedDate(LocalDate.now());
         }

        productImageRepository.save(productImage);
        return "Product image saved/updated successfully";
    }
}

package com.sriram.ecommerce.product.service;

import com.sriram.ecommerce.product.domain.ProductVariantDomain;
import com.sriram.ecommerce.product.model.Color;
import com.sriram.ecommerce.product.model.Product;
import com.sriram.ecommerce.product.model.ProductVariant;
import com.sriram.ecommerce.product.repositoty.ColorRepository;
import com.sriram.ecommerce.product.repositoty.ProductRepository;
import com.sriram.ecommerce.product.repositoty.ProductVariantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class ProductVariantService {
    @Autowired
    private ProductVariantRepository productVariantRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ColorRepository colorRepository;

    public void createProductVariant(ProductVariantDomain productVariantDomain) {
        Product product = productRepository.findByProductId(productVariantDomain.getProductId());
        Color color = colorRepository.findByColorId(productVariantDomain.getColourId());
        ProductVariant productVariant = new ProductVariant();
        productVariant.setProduct(product);
        productVariant.setColor(color);
        productVariant.setPrice(productVariantDomain.getPrice());
        productVariant.setStock(productVariantDomain.getStock());
        productVariantRepository.save(productVariant);

    }

    public ResponseEntity<String> productVariantUpdate(Integer variantId, ProductVariantDomain productVariantDomain) {

        ProductVariant     productVariant=productVariantRepository.findByVariantId(variantId)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"productVariantId Not found"));

        Product product = productRepository.findByProductId(productVariantDomain.getProductId());
        Color color = colorRepository.findByColorId(productVariantDomain.getColourId());
        productVariant.setProduct(product);
        productVariant.setColor(color);
        productVariant.setPrice(productVariantDomain.getPrice());
        productVariant.setStock(productVariant.getStock() +productVariantDomain.getStock());
        productVariantRepository.save(productVariant);

        return ResponseEntity.status(HttpStatus.OK).body("productVariant Updated");
    }
}

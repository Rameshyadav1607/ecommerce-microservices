package com.sriram.ecommerce.product.resource;

import com.sriram.ecommerce.product.domain.ProductDetails;
import com.sriram.ecommerce.product.domain.ProductDomain;
import com.sriram.ecommerce.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductResource  {
    @Autowired
    private ProductService productService;
    @PostMapping("/save")
    public String saveProduct(@RequestBody ProductDomain productDomain){
       return productService.saveProduct(productDomain);
    }
    @PutMapping
    public void updateProduct(@RequestBody ProductDomain productDomain){
         productService.updateProduct(productDomain);
    }

    @GetMapping("/product/{productId}")
    public ProductDetails getProductByProductId(@PathVariable Integer productId){
       return productService.getProductByProductId(productId);
    }

    @GetMapping("/all/product")
    public List<ProductDetails> getAllProduct(){
        return  productService.getAllProduct();
    }
    @GetMapping("/{productName}")
    public List<ProductDetails> getProductByName(@PathVariable String productName){
        return  productService.getProductByName(productName);
    }
}

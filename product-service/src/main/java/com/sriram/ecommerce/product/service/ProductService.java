package com.sriram.ecommerce.product.service;

import com.sriram.ecommerce.product.domain.ProductDetails;
import com.sriram.ecommerce.product.domain.ProductDomain;
import com.sriram.ecommerce.product.model.Brand;
import com.sriram.ecommerce.product.model.Product;
import com.sriram.ecommerce.product.repositoty.BrandRepository;
import com.sriram.ecommerce.product.repositoty.ProductRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private BrandRepository brandRepository;

    public String saveProduct(ProductDomain productDomain) {
        Product existingProduct = productRepository.findByProductName(productDomain.getProductName());

        Brand brand=brandRepository.findByBrandId(productDomain.getBrandId());

        if(existingProduct !=null){
          return "Product Already exits";
        }
        Product product=new Product();
        product.setcreatedDate(LocalDateTime.now());
        product.setBrand(brand);
        product.setProductName(productDomain.getProductName());
        product.setDescription(productDomain.getDescription());
        product.setUnitPrice(productDomain.getUnitPrice());
        product.setQuantity(productDomain.getQuantity());

        productRepository.save(product);

        return "product is inserted or updated";

    }

    public ProductDetails getProductByProductId(Integer productId) {
            Product product = productRepository.findByProductId(productId);
            ProductDetails productDetails=new ProductDetails();
            BeanUtils.copyProperties(product,productDetails);
            productDetails.setBrandId(product.getBrand().getBrandId());
            return  productDetails;
    }

    public List<ProductDetails> getAllProduct() {
        List<Product> all = productRepository.findAll();

        List<ProductDetails> productDetails = all.stream().map(product -> {
                    ProductDetails domain = new ProductDetails();
                    BeanUtils.copyProperties(product, domain);
                    domain.setBrandId(product.getBrand().getBrandId());
            return domain;
                }

        ).collect(Collectors.toList());
        return productDetails;
    }

    public List<ProductDetails> getProductByName(String productName) {
       List<Product> allProducts= productRepository.findAllByProductName(productName.trim());

        List<ProductDetails> productDetailsList = allProducts.stream().map(
                product -> {
                    ProductDetails productDetails = new ProductDetails();
                    BeanUtils.copyProperties(product, productDetails);
                    productDetails.setBrandId(product.getBrand().getBrandId());
                    return productDetails;
                }
        ).collect(Collectors.toList());
        return productDetailsList;
    }

    public void updateProduct(ProductDomain productDomain) {
         Product    existProductt=productRepository.findByProductId(productDomain.getProductId());
         Brand exitsBrand = brandRepository.findByBrandId(productDomain.getBrandId());

        existProductt.setUpdateDate(LocalDateTime.now());
        existProductt.setProductName(productDomain.getProductName());
        existProductt.setDescription(productDomain.getDescription());
        existProductt.setUnitPrice(productDomain.getUnitPrice());
        existProductt.setQuantity(existProductt.getQuantity()+ productDomain.getQuantity());
        existProductt.setBrand(exitsBrand);

        productRepository.save(existProductt);


    }
}

package com.sriram.ecommerce.product.service;

import com.sriram.ecommerce.product.domain.ProductDetails;
import com.sriram.ecommerce.product.domain.ProductDomain;
import com.sriram.ecommerce.product.model.Brand;
import com.sriram.ecommerce.product.model.Product;
import com.sriram.ecommerce.product.repositoty.BrandRepository;
import com.sriram.ecommerce.product.repositoty.ProductRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private BrandRepository brandRepository;

    public String saveProduct(ProductDomain productDomain) {
        Product existingProduct = productRepository.findByProductName(productDomain.getProductName());

        Brand brand=brandRepository.findByBrandId(productDomain.getBrandId())
                .orElseThrow( ()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Brand id not found :" +productDomain.getBrandId()));

        if(existingProduct !=null){
          return "Product Already exits";
        }
        Product product=new Product();
        product.setcreatedDate(LocalDateTime.now());
        product.setBrand(brand);
        product.setProductName(productDomain.getProductName());
        product.setDescription(productDomain.getDescription());

        productRepository.save(product);

        return "product is inserted or updated";

    }

    public List<ProductDetails> getProductByProductId(Integer productId) {
        List<ProductDetails> productDetails = productRepository.fetchAllProductDetails(productId);
            return  productDetails;
    }

    public List<ProductDomain> getAllProduct() {
        List<Product> all = productRepository.findAll();

        List<ProductDomain> productDetails = all.stream().map(product -> {
                    ProductDomain domain = new ProductDomain();
                    BeanUtils.copyProperties(product, domain);
                    domain.setBrandId(product.getBrand().getBrandId());
            return domain;
                }

        ).collect(Collectors.toList());
        return productDetails;
    }

    public List<ProductDomain> getProductByName(String productName) {
       List<Product> allProducts= productRepository.findAllByProductName(productName.trim());

        List<ProductDomain> productDetailsList = allProducts.stream().map(
                product -> {
                    ProductDomain productDomain = new ProductDomain();
                    BeanUtils.copyProperties(product, productDomain);
                    productDomain.setBrandId(product.getBrand().getBrandId());
                    return productDomain;
                }
        ).collect(Collectors.toList());
        return productDetailsList;
    }

    public void updateProduct(ProductDomain productDomain) {
         Product    existProductt=productRepository.findByProductId(productDomain.getProductId());
         Brand exitsBrand = brandRepository.findByBrandId(productDomain.getBrandId())
                 .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"brandId not found :" +productDomain.getBrandId()));

        existProductt.setUpdateDate(LocalDateTime.now());
        existProductt.setProductName(productDomain.getProductName());
        existProductt.setDescription(productDomain.getDescription());
        existProductt.setBrand(exitsBrand);

        productRepository.save(existProductt);


    }
}

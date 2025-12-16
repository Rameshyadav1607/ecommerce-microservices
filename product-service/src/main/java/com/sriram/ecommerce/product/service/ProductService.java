package com.sriram.ecommerce.product.service;

import com.sriram.ecommerce.product.domain.ProductDomain;
import com.sriram.ecommerce.product.model.Brand;
import com.sriram.ecommerce.product.model.Product;
import com.sriram.ecommerce.product.repositoty.BrandRepository;
import com.sriram.ecommerce.product.repositoty.ProductRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        product.setPrice(productDomain.getUnitPrice());
        product.setQuantiy(productDomain.getQuantity());

        productRepository.save(product);

        return "product is inserted or updated";

    }

    public ProductDomain getProductByProductId(Integer productId) {

        Optional<Product> byId = productRepository.findById(productId);
        if(byId.isPresent()){
            Product    product=byId.get();
            ProductDomain domain=new ProductDomain();
            BeanUtils.copyProperties(product,domain);
            return domain;
        }
       return  null;

    }

    public List<ProductDomain> getAllProduct() {
        List<Product> all = productRepository.findAll();

        List<ProductDomain> productDomain = all.stream().map(product -> {
                    ProductDomain domain = new ProductDomain();
                    BeanUtils.copyProperties(product, domain);
            return domain;
                }

        ).collect(Collectors.toList());
        return productDomain;
    }

    public List<ProductDomain> getProductByName(String productName) {
       List<Product> allProducts= productRepository.findAllByProductName(productName.trim());

        List<ProductDomain> productDomains = allProducts.stream().map(
                product -> {
                    ProductDomain domain = new ProductDomain();
                    BeanUtils.copyProperties(product, domain);
                    return domain;
                }
        ).collect(Collectors.toList());
        return productDomains;
    }
}

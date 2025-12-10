package com.sriram.ecommerce.product.service;

import com.sriram.ecommerce.product.domain.ProductDomain;
import com.sriram.ecommerce.product.model.Brand;
import com.sriram.ecommerce.product.model.Category;
import com.sriram.ecommerce.product.model.Product;
import com.sriram.ecommerce.product.repositoty.BrandRepository;
import com.sriram.ecommerce.product.repositoty.CategoryRepository;
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
    private CategoryRepository categoryRepository;
    @Autowired
    private BrandRepository brandRepository;

    public String saveProductOrUpdate(ProductDomain productDomain) {
        Product product = productRepository.findByProductName(productDomain.getProductName());

        Category category = categoryRepository.findByCategoryName(productDomain.getCategoryName());
        Brand brand=brandRepository.findByBrandName(productDomain.getBrandName());

        if(product ==null){
            product=new Product();
            product.setcreatedDate(LocalDateTime.now());
        }else{
            product.setUpdateDate(LocalDateTime.now());
        }
        product.setCategory(category);
        product.setBrand(brand);
        product.setProductName(productDomain.getProductName());
        product.setDescription(productDomain.getDescription());
        product.setPrice(productDomain.getPrice());
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

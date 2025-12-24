package com.sriram.ecommerce.product.service;

import com.sriram.ecommerce.product.domain.ProductImageResponse;
import com.sriram.ecommerce.product.domain.ProductResponse;
import com.sriram.ecommerce.product.domain.ProductDomain;
import com.sriram.ecommerce.product.domain.ProductVariantResponse;
import com.sriram.ecommerce.product.domain.ProductsDetails;
import com.sriram.ecommerce.product.exception.ResourceNotFoundException;
import com.sriram.ecommerce.product.model.Brand;
import com.sriram.ecommerce.product.model.Product;
import com.sriram.ecommerce.product.repositoty.BrandRepository;
import com.sriram.ecommerce.product.repositoty.ProductRepository;
import com.sriram.ecommerce.product.repositoty.projection.ProductBrandProjection;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private BrandRepository brandRepository;

    public String saveProduct(ProductDomain productDomain) {
        Product existingProduct = productRepository.findByProductName(productDomain.getProductName());

        Brand brand = brandRepository.findByBrandId(productDomain.getBrandId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Brand id not found :" + productDomain.getBrandId()));

        if (existingProduct != null) {
            return "Product Already exits";
        }
        Product product = new Product();
        product.setcreatedDate(LocalDateTime.now());
        product.setBrand(brand);
        product.setProductName(productDomain.getProductName());
        product.setDescription(productDomain.getDescription());

        productRepository.save(product);

        return "product is inserted or updated";

    }

    public List<ProductsDetails> getProductByProductId(Integer productId) {
        List<ProductResponse> allProducts = productRepository.fetchAllProductDetails(productId);
        Map<Integer, ProductsDetails> productMap = new LinkedHashMap<>();

        for(ProductResponse row : allProducts){

            ProductsDetails product = productMap.get(row.getProductId());

            if(product == null){
                product=new ProductsDetails();
                product.setProductId(row.getProductId());
                product.setProductName(row.getProductName());
                product.setBrandName(row.getBrandName());
                product.setProductVariantResponseList(new ArrayList<>());
                productMap.put(row.getProductId(), product);
            }

            ProductVariantResponse variant=null;
            for (ProductVariantResponse v : product.getProductVariantResponseList()) {
                if(v.getVaiantId() == row.getVariantId()){
                    variant=v;
                    break;
                }
            }

            if(variant==null){
                variant=new ProductVariantResponse();
                variant.setVaiantId(row.getVariantId());
                variant.setColorName(row.getColorName());
                variant.setPrice(row.getPrice());
                variant.setStock(row.getStock());
                variant.setProductImage(new ArrayList<>());
                product.getProductVariantResponseList().add(variant);

            }
            if(row.getImageId() !=null){
                ProductImageResponse imageResponse=new ProductImageResponse();
                imageResponse.setImageId(row.getImageId());
                imageResponse.setImageUrl(row.getImageUrl());
                variant.getProductImage().add(imageResponse);
            }
        }


        return new ArrayList<>(productMap.values());
    }

    public List<ProductsDetails> getAllProduct() {

        List<ProductBrandProjection> allProducts = productRepository.getAllProducts();

     Map<Integer, ProductsDetails> productMap = new LinkedHashMap<>();

        for(ProductBrandProjection row : allProducts){

            ProductsDetails product = productMap.get(row.getProductId());

            if(product == null){
                product=new ProductsDetails();
                product.setProductId(row.getProductId());
                product.setProductName(row.getProductName());
                product.setBrandName(row.getBrandName());
                product.setProductVariantResponseList(new ArrayList<>());
                productMap.put(row.getProductId(), product);
            }

            ProductVariantResponse variant=null;
            for (ProductVariantResponse v : product.getProductVariantResponseList()) {
                if(v.getVaiantId() == row.getVariantId()){
                    variant=v;
                    break;
                }
            }

            if(variant==null){
                variant=new ProductVariantResponse();
                variant.setVaiantId(row.getVariantId());
                variant.setColorName(row.getColorName());
                variant.setPrice(BigDecimal.valueOf(row.getPrice()));
                variant.setStock(row.getStock());
                variant.setProductImage(new ArrayList<>());
                product.getProductVariantResponseList().add(variant);

            }
            if(row.getImageId() !=null){
            ProductImageResponse imageResponse=new ProductImageResponse();
            imageResponse.setImageId(row.getImageId());
            imageResponse.setImageUrl(row.getImageUrl());
            variant.getProductImage().add(imageResponse);
              }
        }


        return new ArrayList<>(productMap.values());
    }

    public List<ProductDomain> getProductByName(String productName) {
        List<Product> allProducts = productRepository.findAllByProductName(productName.trim());
        if (allProducts.isEmpty()) {
            throw new ResourceNotFoundException("no product found with :" + productName);
        }

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
        Product existProductt = productRepository.findByProductId(productDomain.getProductId());
        Brand exitsBrand = brandRepository.findByBrandId(productDomain.getBrandId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "brandId not found :" + productDomain.getBrandId()));

        existProductt.setUpdateDate(LocalDateTime.now());
        existProductt.setProductName(productDomain.getProductName());
        existProductt.setDescription(productDomain.getDescription());
        existProductt.setBrand(exitsBrand);

        productRepository.save(existProductt);


    }
}

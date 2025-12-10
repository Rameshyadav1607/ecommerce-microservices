package com.sriram.ecommerce.product.repositoty;

import com.sriram.ecommerce.product.model.Product;
import com.sriram.ecommerce.product.model.ProductImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductImageRepository extends JpaRepository<ProductImage,Integer> {

    ProductImage findByProductProductName(Product product);
}

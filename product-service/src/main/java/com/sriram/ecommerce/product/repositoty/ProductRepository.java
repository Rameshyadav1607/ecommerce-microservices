package com.sriram.ecommerce.product.repositoty;

import com.sriram.ecommerce.product.domain.ProductDetails;
import com.sriram.ecommerce.product.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository  extends JpaRepository<Product,Integer> {

    @Query("select p from Product p where p.productName = ?1")
    Product findByProductName(String categoryName);

    @Query("select p from Product p where p.productName = ?1")
    List<Product> findAllByProductName(String productName);

    Product findByProductId(Integer productId);

    @Query("""
    SELECT new com.sriram.ecommerce.product.domain.ProductDetails(
        p.productId,
        p.productName,
        b.brandName,
        c.colorName,
        pv.variantId,
        pv.price,
        pv.stock,
        pi.imageUrl
    )
    FROM Product p
    JOIN p.brand b
    JOIN ProductVariant pv ON pv.product.productId = p.productId
    JOIN Color c ON c.colorId = pv.color.colorId
    LEFT JOIN ProductImage pi ON pi.productVariant.variantId = pv.variantId
    WHERE p.productId = :productId
""")
    List<ProductDetails> fetchAllProductDetails(@Param("productId") Integer productId);

}

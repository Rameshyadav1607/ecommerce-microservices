package com.sriram.ecommerce.product.repositoty;

import com.sriram.ecommerce.product.domain.ProductResponse;
import com.sriram.ecommerce.product.model.Product;
import com.sriram.ecommerce.product.repositoty.projection.ProductBrandProjection;
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
    SELECT new com.sriram.ecommerce.product.domain.ProductResponse(
        p.productId,
        p.productName,
        b.brandId,
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
    List<ProductResponse> fetchAllProductDetails(@Param("productId") Integer productId);





    @Query(value = """
            SELECT
            p.product_id AS productId,
            p.product_name as productName,
            b.brand_name as brandName,
            pv.variant_id as variantId,
            c.color_name as colorName,
            pv.price as price,
           	pv.stock as stock,
           	pi.image_id as imageId,
            pi.image_url as imageUrl
            from product p  
            join brand b on b.brand_id=p.brand_id
            join product_variant pv on pv.product_id=p.product_id
            join color c on c.color_id=pv.color_id
            left join product_image pi on pi.variant_id=pv.variant_id
            """, nativeQuery = true)
    List<ProductBrandProjection> getAllProducts();
}

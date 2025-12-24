package com.sriram.ecommerce.product.repositoty.projection;

public interface ProductBrandProjection {

    Integer getProductId();
    String getProductName();
    String getBrandName();
    Integer getVariantId();
    String getColorName();
    Double getPrice();
    Integer getStock();
    String getImageUrl();
    Integer getImageId();


}

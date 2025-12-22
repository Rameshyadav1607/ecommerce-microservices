package com.sriram.ecommerce.product.service;

import com.sriram.ecommerce.product.model.ProductImage;
import com.sriram.ecommerce.product.model.ProductVariant;
import com.sriram.ecommerce.product.repositoty.ProductImageRepository;
import com.sriram.ecommerce.product.repositoty.ProductVariantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class ProductImageService {
    @Autowired
    private ProductImageRepository productImageRepository;
    @Autowired
    private ProductVariantRepository productVariantRepository;

    @Value("${file.upload-dir}")
    private String uploadDir;


    private final String UPLOAD_DIR = "uploads/products/";

    public String uploadImage(MultipartFile file,
                              Integer variantId,
                              Boolean isPrimary) throws IOException {

        ProductVariant variant = productVariantRepository.findById(variantId)
                .orElseThrow(() ->
                        new ResponseStatusException(
                                HttpStatus.NOT_FOUND,
                                "Variant not found"
                        ));

        Files.createDirectories(Paths.get(uploadDir));

        String fileName = System.currentTimeMillis()
                + "_" + file.getOriginalFilename();

        Path filePath = Paths.get(uploadDir, fileName);
        Files.write(filePath, file.getBytes());

        ProductImage image = new ProductImage();
        image.setProductVariant(variant);
        image.setImageUrl("/uploads/products/" + fileName);
        image.setIsPrimary(isPrimary != null ? isPrimary : false);

        productImageRepository.save(image);

        return "Image uploaded successfully";
    }
}

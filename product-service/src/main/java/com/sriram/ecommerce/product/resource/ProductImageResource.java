package com.sriram.ecommerce.product.resource;

import com.sriram.ecommerce.product.service.ProductImageService;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api/product-image")
@Validated
public class ProductImageResource {
    @Autowired
    private ProductImageService productImageService;

    @PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<String> uploadImage(
            @RequestParam("file") MultipartFile file,
            @RequestParam("variantId") @NotNull(message = "VariantId is required") Integer variantId,
            @RequestParam(value = "isPrimary", required = false) Boolean isPrimary
    ) throws IOException {

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(productImageService.uploadImage(file, variantId, isPrimary));
    }


}

package com.sriram.ecommerce.product.service;

import com.sriram.ecommerce.product.model.Color;
import com.sriram.ecommerce.product.model.Product;
import com.sriram.ecommerce.product.repositoty.ColourRepository;
import com.sriram.ecommerce.product.repositoty.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ColorService {
    @Autowired
    private ColourRepository colourRepository;
    @Autowired
    private ProductRepository productRepository;

    public String saveOrUpdateColor(String colorName,Integer productId) {

        Color color =colourRepository.findByColorName(colorName);
        Product product = productRepository.findByProductId(productId);

        if(color == null){
            color =new Color();
        }
        color.setColorName(colorName);
        color.setProduct(product);
        colourRepository.save(color);
        return "colour is saved or updated";
    }

    public List<String> getColorNames() {
          List<String>  colors=colourRepository.findByColorNames();
        return colors;
    }
}

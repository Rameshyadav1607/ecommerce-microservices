package com.sriram.ecommerce.product.service;

import com.sriram.ecommerce.product.model.Colour;
import com.sriram.ecommerce.product.model.Product;
import com.sriram.ecommerce.product.repositoty.ColourRepository;
import com.sriram.ecommerce.product.repositoty.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ColourService {
    @Autowired
    private ColourRepository colourRepository;
    @Autowired
    private ProductRepository productRepository;

    public String saveOrUpdateColour(String colourName,Integer productId) {

        Colour colour=colourRepository.findByColourName(colourName);
        Product product = productRepository.findByProductId(productId);

        if(colour == null){
            colour=new Colour();
        }
        colour.setColourName(colourName);
        colour.setProduct(product);
        colourRepository.save(colour);
        return "colour is saved or updated";
    }

    public List<String> getColourNames() {
          List<String>  colours=colourRepository.findByColourNames();
        return colours;
    }
}

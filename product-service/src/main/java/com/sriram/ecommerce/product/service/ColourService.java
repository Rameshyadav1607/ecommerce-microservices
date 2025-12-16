package com.sriram.ecommerce.product.service;

import com.sriram.ecommerce.product.model.Colour;
import com.sriram.ecommerce.product.repositoty.ColourRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ColourService {
    @Autowired
    private ColourRepository colourRepository;

    public String saveOrUpdateColour(String colourName) {

        Colour colour=colourRepository.findByColourName(colourName);

        if(colour == null){
            colour=new Colour();
        }
        colour.setColourName(colourName);
        colourRepository.save(colour);
        return "colour is saved or updated";
    }

    public List<String> getColourNames() {
          List<String>  colours=colourRepository.findByColourNames();
        return colours;
    }
}

package com.sriram.ecommerce.product.resource;

import com.sriram.ecommerce.product.service.ColourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/colour")
public class ColourResource {
    @Autowired
    private ColourService colourService;

    @PostMapping("/saveOrUpdate/{colourName}")
    public String saveOrUpdateColour(@PathVariable String colourName){
        return colourService.saveOrUpdateColour(colourName);

    }
    @GetMapping("/all")
    public List<String> getColourNames(){
       return colourService.getColourNames();
    }

}

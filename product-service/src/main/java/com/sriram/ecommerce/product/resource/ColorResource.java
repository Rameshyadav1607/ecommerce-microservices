package com.sriram.ecommerce.product.resource;

import com.sriram.ecommerce.product.service.ColorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/colour")
public class ColorResource {
    @Autowired
    private ColorService colorService;

    @PostMapping("/saveOrUpdate/{colorName}/{productId}")
    public String saveOrUpdateColour(@PathVariable String colorName,@PathVariable Integer productId){
        return colorService.saveOrUpdateColor(colorName,productId);

    }
    @GetMapping("/all")
    public List<String> getColourNames(){
       return colorService.getColorNames();
    }

}

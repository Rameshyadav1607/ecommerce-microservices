package com.sriram.ecommerce.product.resource;
import com.sriram.ecommerce.product.domain.BrandDomain;
import com.sriram.ecommerce.product.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/brand")
public class BrandResource {

    @Autowired
    private BrandService brandService;

    @PostMapping("/{brandName}/{description}/{subCategoryId}")
    public void saveOrUpdateBrand(@Validated @PathVariable String brandName,
    @PathVariable String description,@PathVariable Integer subCategoryId){
         brandService.saveOrUpdateBrand(brandName,description,subCategoryId);
    }

    @DeleteMapping("/delete/{brandID}")
    public String deleteBrand(@PathVariable Integer brandID){
        return  brandService.deleteBrand(brandID);
    }

    @GetMapping("/all/brands")
    public List<BrandDomain> getAllBrands(){
      return   brandService.getAllBrands();

    }
    @GetMapping("/brand/names")
    public List<String> getAllBrandNames(){
        return brandService.getAllBrandNames();
    }


}

package com.sriram.ecommerce.product.resource;
import com.sriram.ecommerce.product.domain.BrandDomain;
import com.sriram.ecommerce.product.service.BrandService;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/api/brand")
public class BrandResource {

    @Autowired
    private BrandService brandService;

    @PostMapping("/{brandName}/{description}/{subCategoryId}")
    public void saveOrUpdateBrand(
            @PathVariable @NotBlank(message = "brandname required") String brandName,
    @PathVariable @NotBlank(message = "decription required") String description,
            @PathVariable @NotNull(message = "subCategoryId required") Integer subCategoryId){
         brandService.saveOrUpdateBrand(brandName,description,subCategoryId);
    }

    @DeleteMapping("/{brandID}")
    public String deleteBrand(
            @PathVariable @NotNull(message = "brandId is Required") Integer brandID){
        return  brandService.deleteBrand(brandID);
    }

    @GetMapping("/all")
    public List<BrandDomain> getAllBrands(){
      return   brandService.getAllBrands();

    }
    @GetMapping("/names")
    public List<String> getAllBrandNames(){
        return brandService.getAllBrandNames();
    }


}

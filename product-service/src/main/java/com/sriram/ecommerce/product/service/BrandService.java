package com.sriram.ecommerce.product.service;

import com.sriram.ecommerce.product.domain.BrandDomain;
import com.sriram.ecommerce.product.model.Brand;
import com.sriram.ecommerce.product.model.SubCategory;
import com.sriram.ecommerce.product.repositoty.BrandRepository;
import com.sriram.ecommerce.product.repositoty.SubCategoryRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class BrandService {
    @Autowired
    private BrandRepository brandRepository;
    @Autowired
    private SubCategoryRepository subCategoryRepository;

    public void saveOrUpdateBrand(String brandName,String brandDescription,Integer subCategoryId) {

        Brand brand= brandRepository.findByBrandName(brandName);
        SubCategory subCategory = subCategoryRepository.findBySubCategoryId(subCategoryId);

        if (brand != null) {
            brand.setupdatedDate(LocalDateTime.now());
        } else {
            brand = new Brand();
            brand.setcreatedDate(LocalDateTime.now());
        }
        brand.setBrandName(brandName);
        brand.setDescription(brandDescription);
        brand.setSubCategory(subCategory);
        brandRepository.save(brand);

        System.out.println("brand insert or updated");

    }



    public String deleteBrand(Integer brandID) {

        boolean isPrasent = brandRepository.existsById(brandID);
        if(isPrasent){
            brandRepository.deleteById(brandID);
            return "brand deleted";
        }
        return  "brand id not found";

    }

    public List<BrandDomain> getAllBrands() {
        List<Brand> all = brandRepository.findAll();

        return all.stream().map(brand -> {
            BrandDomain dto = new BrandDomain();
            BeanUtils.copyProperties(brand, dto);
            return dto;
        }).collect(Collectors.toList());
    }

    public List<String> getAllBrandNames() {

            return   brandRepository.findAllBrandNames();
    }
}

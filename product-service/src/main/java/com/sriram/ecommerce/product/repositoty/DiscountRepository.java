package com.sriram.ecommerce.product.repositoty;

import com.sriram.ecommerce.product.model.Discount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiscountRepository extends JpaRepository<Discount,Integer> {
}

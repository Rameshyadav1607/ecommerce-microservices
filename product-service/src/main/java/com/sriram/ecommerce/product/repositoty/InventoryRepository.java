package com.sriram.ecommerce.product.repositoty;

import com.sriram.ecommerce.product.model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepository extends JpaRepository<Inventory, Integer> {
}
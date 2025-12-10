package com.sriram.ecommerce.product.service;

import com.sriram.ecommerce.product.repositoty.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InventoryService {
    @Autowired
    private InventoryRepository inventoryRepository;
}

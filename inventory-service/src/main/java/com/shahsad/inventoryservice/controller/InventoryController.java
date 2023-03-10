package com.shahsad.inventoryservice.controller;

import com.shahsad.inventoryservice.dto.InventoryResponse;
import com.shahsad.inventoryservice.model.Inventory;
import com.shahsad.inventoryservice.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inventory")
@RequiredArgsConstructor
public class InventoryController {
    //boolean
    //@PathVariable("sku-code") String
    private final InventoryService inventoryService;
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<InventoryResponse> isInStock(@RequestParam List<String> skuCode) {
       return inventoryService.isInStock(skuCode);

    }
}

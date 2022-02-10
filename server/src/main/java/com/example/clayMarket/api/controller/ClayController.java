package com.example.clayMarket.api.controller;

import com.example.clayMarket.api.mapper.ClayMapper;
import com.example.clayMarket.api.service.CategoryService;
import com.example.clayMarket.api.service.ClayService;
import com.example.clayMarket.api.service.SupplierService;
import com.example.clayMarket.api.view.ClayView;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/clay")
@RequiredArgsConstructor
@Transactional
public class ClayController {

    private final ClayService clayService;
    private final CategoryService categoryService;
    private final SupplierService supplierService;

    @GetMapping("/category/{categoryId}")
    public List<ClayView> readByCategory(
            @PathVariable Long categoryId
    ) {
        var category = categoryService.getItem(categoryId);
        return clayService.read(category).stream().map(ClayMapper.INSTANCE::toClayView).toList();
    }

    @GetMapping("/supplier/{supplierId}")
    public List<ClayView> readBySupplier(
            @PathVariable Long supplierId
    ) {
        var supplier = supplierService.getItem(supplierId);
        return clayService.read(supplier).stream().map(ClayMapper.INSTANCE::toClayView).toList();
    }
}

package com.example.clayMarket.api.controller;

import com.example.clayMarket.api.mapper.ClayMapper;
import com.example.clayMarket.api.service.CategoryService;
import com.example.clayMarket.api.service.ClayService;
import com.example.clayMarket.api.service.SupplierService;
import com.example.clayMarket.api.view.ClayView;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/clay")
@RequiredArgsConstructor
@Transactional
public class ClayController {

    private final ClayService clayService;
    private final CategoryService categoryService;
    private final SupplierService supplierService;

    @GetMapping
    public Page<ClayView> read(
            @RequestParam("page") int pageIndex,
            @RequestParam("size") int pageSize
    ) {
        return clayService.read(PageRequest.of(pageIndex, pageSize)).map(ClayMapper.INSTANCE::toClayView);
    }

    @GetMapping("/category/{categoryId}")
    public Page<ClayView> readByCategory(
            @PathVariable Long categoryId,
            @RequestParam("page") int pageIndex,
            @RequestParam("size") int pageSize
    ) {
        var category = categoryService.getItem(categoryId);
        return clayService.read(category, PageRequest.of(pageIndex, pageSize)).map(ClayMapper.INSTANCE::toClayView);
    }

    @GetMapping("/supplier/{supplierId}")
    public Page<ClayView> readBySupplier(
            @PathVariable Long supplierId,
            @RequestParam("page") int pageIndex,
            @RequestParam("size") int pageSize
    ) {
        var supplier = supplierService.getItem(supplierId);
        return clayService.read(supplier, PageRequest.of(pageIndex, pageSize)).map(ClayMapper.INSTANCE::toClayView);
    }
}

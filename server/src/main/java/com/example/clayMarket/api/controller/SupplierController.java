package com.example.clayMarket.api.controller;

import com.example.clayMarket.api.mapper.SupplierMapper;
import com.example.clayMarket.api.service.SupplierService;
import com.example.clayMarket.api.view.SupplierView;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequiredArgsConstructor
@RequestMapping("/api/supplier")
public class SupplierController {

    private final SupplierService publisherService;

    @GetMapping
    public List<SupplierView> read() {
        return publisherService.read().stream().map(SupplierMapper.INSTANCE::toSupplierView).toList();
    }
}

package com.example.clayMarket.api.controller;

import com.example.clayMarket.api.mapper.CategoryMapper;
import com.example.clayMarket.api.service.CategoryService;
import com.example.clayMarket.api.view.CategoryView;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/category")
@CrossOrigin
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping
    public List<CategoryView> read() {
        return categoryService.read().stream().map(CategoryMapper.INSTANCE::toCategoryView).toList();
    }
}

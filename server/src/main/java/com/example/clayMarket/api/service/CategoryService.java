package com.example.clayMarket.api.service;

import com.example.clayMarket.api.entity.Category;
import com.example.clayMarket.api.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public List<Category> read() {
        return categoryRepository.findAll();
    }

    public Category getItem(Long id) {
        return categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Not found: " + Category.class));
    }
}

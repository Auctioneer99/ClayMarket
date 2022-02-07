package com.example.clayMarket.api.service;

import com.example.clayMarket.api.entity.Category;
import com.example.clayMarket.api.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public Category getItem(Long id) {
        return categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Not found: " + Category.class));
    }
}

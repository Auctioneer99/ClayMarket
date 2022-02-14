package com.example.clayMarket.api.service;

import com.example.clayMarket.api.entity.Category;
import com.example.clayMarket.api.entity.Clay;
import com.example.clayMarket.api.entity.QClay;
import com.example.clayMarket.api.entity.Supplier;
import com.example.clayMarket.api.repository.ClayRepository;
import com.querydsl.core.types.dsl.BooleanExpression;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClayService {

    private final ClayRepository clayRepository;

    public Page<Clay> read(Category category, Pageable pageable) {
        var pred = QClay.clay.category.eq(category);
        return clayRepository.findAll(pred, pageable);
    }

    public Page<Clay> read(Supplier supplier, Pageable pageable) {
        var pred = QClay.clay.suppliers.any().eq(supplier);
        return clayRepository.findAll(pred, pageable);
    }

    public Page<Clay> read(Pageable pageable) {
        return clayRepository.findAll(pageable);
    }

    public Page<Clay> read(BooleanExpression pred, Pageable pageable) {
        return clayRepository.findAll(pred, pageable);
    }

    public Clay getItem(Long id) {
        return clayRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Not found: " + Clay.class));
    }
}

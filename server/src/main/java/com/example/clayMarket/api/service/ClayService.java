package com.example.clayMarket.api.service;

import com.example.clayMarket.api.entity.Category;
import com.example.clayMarket.api.entity.Clay;
import com.example.clayMarket.api.entity.QClay;
import com.example.clayMarket.api.entity.Supplier;
import com.example.clayMarket.api.repository.ClayRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class ClayService {

    private final ClayRepository clayRepository;

    public List<Clay> read(Category category) {
        var pred = QClay.clay.category.eq(category);
        return StreamSupport.stream(clayRepository.findAll(pred).spliterator(), false)
                .collect(Collectors.toList());
    }

    public List<Clay> read(Supplier supplier) {
        var pred = QClay.clay.suppliers.any().eq(supplier);
        return StreamSupport.stream(clayRepository.findAll(pred).spliterator(), false)
                .collect(Collectors.toList());
    }

    public Clay getItem(Long id) {
        return clayRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Not found: " + Clay.class));
    }
}

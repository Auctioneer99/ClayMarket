package com.example.clayMarket.api.service;

import com.example.clayMarket.api.entity.Supplier;
import com.example.clayMarket.api.repository.SupplierRepository;
import com.querydsl.core.types.dsl.BooleanExpression;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class SupplierService {

    private final SupplierRepository supplierRepository;

    public List<Supplier> readAll() {
        return supplierRepository.findAll();
    }

    public List<Supplier> read(BooleanExpression predicate, Pageable pageable) {
        return StreamSupport.stream(supplierRepository.findAll(predicate, pageable).spliterator(), false)
                .collect(Collectors.toList());
    }

    public Supplier getItem(Long id) {
        return supplierRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Not found: " + Supplier.class));
    }
}

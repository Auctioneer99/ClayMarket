package com.example.clayMarket.api.service;

import com.example.clayMarket.api.entity.Supplier;
import com.example.clayMarket.api.repository.SupplierRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SupplierService {

    private final SupplierRepository supplierRepository;

    public List<Supplier> read() {
        return supplierRepository.findAll();
    }

    public Supplier getItem(Long id) {
        return supplierRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Not found: " + Supplier.class));
    }
}

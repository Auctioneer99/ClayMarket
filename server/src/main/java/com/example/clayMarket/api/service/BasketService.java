package com.example.clayMarket.api.service;

import com.example.clayMarket.api.entity.Basket;
import com.example.clayMarket.api.repository.BasketRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BasketService {

    private final BasketRepository basketRepository;

    public Basket getItem(Long id) {
        return basketRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Not found: " + Basket.class));
    }
}
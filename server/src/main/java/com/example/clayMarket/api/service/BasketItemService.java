package com.example.clayMarket.api.service;

import com.example.clayMarket.api.entity.BasketItem;
import com.example.clayMarket.api.repository.BasketItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BasketItemService {

    private final BasketItemRepository basketItemRepository;

    public void save(BasketItem item) {
        basketItemRepository.save(item);
    }

    public void remove(BasketItem item) {
        basketItemRepository.delete(item);
    }

    public BasketItem getItem(Long id) {
        return basketItemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Not found: " + BasketItem.class));
    }
}

package com.example.clayMarket.api.service;

import com.example.clayMarket.api.entity.Clay;
import com.example.clayMarket.api.repository.ClayRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClayService {

    private final ClayRepository clayRepository;

    public Clay getItem(Long id) {
        return clayRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Not found: " + Clay.class));
    }
}

package com.example.clayMarket.api.controller;

import com.example.clayMarket.api.mapper.BasketMapper;
import com.example.clayMarket.api.service.BasketService;
import com.example.clayMarket.api.view.BasketView;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/basket")
@RequiredArgsConstructor
@Transactional
public class BasketController {

    private final BasketService basketService;

    @GetMapping
    public BasketView getBasket() {
        return BasketMapper.INSTANCE.toBasketView(basketService.getBasketForUser());
    }

    @GetMapping("/order")
    public List<BasketView> getOrders() {
        return basketService.getOrders().stream().map(BasketMapper.INSTANCE::toBasketView).toList();
    }

    @PostMapping("/order")
    public Boolean order() {
        return basketService.order();
    }

    @PostMapping("/{id}")
    public Boolean addItem(
            @PathVariable Long id
    ) {
        return basketService.addItem(id);
    }

    @DeleteMapping("/{id}")
    public Boolean removeItem(
            @PathVariable Long id
    ) {
        return basketService.removeItem(id);
    }
}

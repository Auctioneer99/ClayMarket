package com.example.clayMarket.api.controller;

import com.example.clayMarket.api.mapper.BasketMapper;
import com.example.clayMarket.api.service.BasketService;
import com.example.clayMarket.api.view.BasketView;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/basket")
@RequiredArgsConstructor
public class BasketController {

    private final BasketService basketService;

    @PostMapping("/{id}")
    public Boolean addItem(
            @PathVariable Long id
    ) {
        return basketService.addItem(id);
    }

    @DeleteMapping("/id")
    public Boolean removeItem(
            @PathVariable Long id
    ) {
        return basketService.removeItem(id);
    }

    @GetMapping
    public BasketView getBasket() {
        return BasketMapper.INSTANCE.toBasketView(basketService.getBasketForUser());
    }
}

package com.example.clayMarket.api.service;

import com.example.clayMarket.api.entity.Basket;
import com.example.clayMarket.api.entity.BasketItem;
import com.example.clayMarket.api.entity.QBasket;
import com.example.clayMarket.api.repository.BasketRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class BasketService {

    private final AuthService authService;
    private final ClayService clayService;
    private final BasketItemService basketItemService;

    private final BasketRepository basketRepository;

    public Boolean addItem(
            Long id
    ) {
        var clay = clayService.getItem(id);
        var basket = getBasketForUser();

        for (var item: basket.getBasketItems()) {
            if (item.getClay().getId().equals(id)) {
                item.setCount(item.getCount() + 1);
                return true;
            }
        }
        var basketItem = new BasketItem();
        basketItem.setBasket(basket);
        basketItem.setClay(clay);
        basketItem.setCount(1L);

        return true;
    }

    public Boolean removeItem(
            Long id
    ) {
        var basket = getBasketForUser();

        for (var item: basket.getBasketItems()) {
            if (item.getClay().getId().equals(id)) {
                item.setCount(item.getCount() - 1);
                if (item.getCount().equals((0L))) {
                    basketItemService.remove(item);
                }
                return true;
            }
        }

        return false;
    }

    public Basket getBasketForUser() {
        var userId = authService.getCurrentUserId();
        var predicate = QBasket.basket.userId.eq(userId).and(QBasket.basket.ordered.eq(false));
        var basketOptional = basketRepository.findOne(predicate);
        var basket = persistBasket(basketOptional);
        return basket;
    }

    private Basket persistBasket(
            Optional<Basket> basketOptional
    ) {
        var userId = authService.getCurrentUserId();
        Basket basket;
        if (basketOptional.isEmpty()) {
            basket = new Basket();
            basket.setUserId(userId);
        }
        else {
            basket = basketOptional.get();
        }
        return basket;
    }

    public Basket getItem(Long id) {
        return basketRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Not found: " + Basket.class));
    }
}
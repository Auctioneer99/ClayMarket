package com.example.clayMarket.api.service;

import com.example.clayMarket.api.entity.Basket;
import com.example.clayMarket.api.entity.BasketItem;
import com.example.clayMarket.api.entity.QBasket;
import com.example.clayMarket.api.repository.BasketRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
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

        if (basket.getBasketItems() != null) {
            for (var item : basket.getBasketItems()) {
                if (item.getClay().getId().equals(id)) {
                    item.setCount(item.getCount() + 1);
                    return true;
                }
            }
        }
        var basketItem = new BasketItem();
        basketItem.setBasket(basket);
        basketItem.setClay(clay);
        basketItem.setCount(1L);
        basketItemService.save(basketItem);

        return true;
    }

    public Boolean removeItem(
            Long id
    ) {
        var basket = getBasketForUser();

        for (var item : basket.getBasketItems()) {
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

    public Boolean order() {
        var basket = getBasketForUser();
        if (basket.getBasketItems().stream().count() == 0) {
            return false;
        }
        basket.setOrdered(true);
        basket.setDateOrdered(Calendar.getInstance().getTime());
        return true;
    }

    public Basket getBasketForUser() {
        var userId = authService.getCurrentUserId();
        var predicate = QBasket.basket.userId.eq(userId).and(QBasket.basket.ordered.eq(false));
        var basketOptional = basketRepository.findOne(predicate);
        var basket = persistBasket(basketOptional);
        return basket;
    }

    public List<Basket> getOrders() {
        var userId = authService.getCurrentUserId();
        var pred = QBasket.basket.userId.eq(userId).and(QBasket.basket.ordered.eq(true));
        return StreamSupport.stream(basketRepository.findAll(pred).spliterator(), false)
                .collect(Collectors.toList());
    }

    private Basket persistBasket(
            Optional<Basket> basketOptional
    ) {
        var userId = authService.getCurrentUserId();
        Basket basket;
        if (basketOptional.isEmpty()) {
            basket = new Basket();
            basket.setUserId(userId);
            basketRepository.save(basket);
        } else {
            basket = basketOptional.get();
        }
        return basket;
    }

    public Basket getItem(Long id) {
        return basketRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Not found: " + Basket.class));
    }
}
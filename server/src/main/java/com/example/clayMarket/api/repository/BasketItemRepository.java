package com.example.clayMarket.api.repository;

import com.example.clayMarket.api.entity.BasketItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface BasketItemRepository extends JpaRepository<BasketItem, Long>, QuerydslPredicateExecutor<BasketItem> {
}

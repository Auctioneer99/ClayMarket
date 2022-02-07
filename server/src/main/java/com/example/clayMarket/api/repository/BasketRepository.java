package com.example.clayMarket.api.repository;

import com.example.clayMarket.api.entity.Basket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface BasketRepository extends JpaRepository<Basket, Long>, QuerydslPredicateExecutor<Basket> {
}

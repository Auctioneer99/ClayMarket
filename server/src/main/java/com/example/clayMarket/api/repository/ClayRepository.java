package com.example.clayMarket.api.repository;

import com.example.clayMarket.api.entity.Clay;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface ClayRepository extends JpaRepository<Clay, Long>, QuerydslPredicateExecutor<Clay> {
}
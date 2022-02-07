package com.example.clayMarket.api.repository;

import com.example.clayMarket.api.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface CategoryRepository extends JpaRepository<Category, Long>, QuerydslPredicateExecutor<Category> {
}

package com.example.clayMarket.api.mapper;

import com.example.clayMarket.api.entity.Category;
import com.example.clayMarket.api.view.CategoryView;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CategoryMapper {

    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);

    CategoryView toCategoryView(Category category);
}
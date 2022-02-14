package com.example.clayMarket.api.mapper;

import com.example.clayMarket.api.entity.Clay;
import com.example.clayMarket.api.view.ClayFetchOrderCountView;
import com.example.clayMarket.api.view.ClayView;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ClayMapper {

    ClayMapper INSTANCE = Mappers.getMapper(ClayMapper.class);

    ClayView toClayView(Clay clay);

    @Mapping(target = "count", expression = "java(clay.getBasketItems().stream().count())")
    ClayFetchOrderCountView toClayFetchOrderCountView(Clay clay);
}

package com.example.clayMarket.api.mapper;

import com.example.clayMarket.api.entity.Basket;
import com.example.clayMarket.api.view.BasketView;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BasketMapper {

    BasketMapper INSTANCE = Mappers.getMapper(BasketMapper.class);

    BasketView toBasketView(Basket basket);
}

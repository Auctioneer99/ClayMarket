package com.example.clayMarket.api.mapper;

import com.example.clayMarket.api.entity.Supplier;
import com.example.clayMarket.api.view.SupplierFetchCountView;
import com.example.clayMarket.api.view.SupplierView;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SupplierMapper {

    SupplierMapper INSTANCE = Mappers.getMapper(SupplierMapper.class);

    SupplierView toSupplierView(Supplier supplier);

    @Mapping(target="count", expression="java(supplier.getClayList().stream().count())")
    SupplierFetchCountView toSupplierFetchCountView(Supplier supplier);
}
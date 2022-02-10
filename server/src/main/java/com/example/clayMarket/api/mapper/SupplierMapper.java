package com.example.clayMarket.api.mapper;

import com.example.clayMarket.api.entity.Supplier;
import com.example.clayMarket.api.view.SupplierView;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SupplierMapper {

    SupplierMapper INSTANCE = Mappers.getMapper(SupplierMapper.class);

    SupplierView toSupplierView(Supplier supplier);
}
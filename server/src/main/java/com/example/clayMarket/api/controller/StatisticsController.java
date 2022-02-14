package com.example.clayMarket.api.controller;

import com.example.clayMarket.api.entity.QClay;
import com.example.clayMarket.api.entity.QSupplier;
import com.example.clayMarket.api.mapper.ClayMapper;
import com.example.clayMarket.api.mapper.SupplierMapper;
import com.example.clayMarket.api.service.ClayService;
import com.example.clayMarket.api.service.SupplierService;
import com.example.clayMarket.api.view.ClayFetchOrderCountView;
import com.example.clayMarket.api.view.ClayView;
import com.example.clayMarket.api.view.SupplierFetchCountView;
import com.querydsl.jpa.impl.JPAQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/statistics")
@CrossOrigin
@RequiredArgsConstructor
public class StatisticsController {

    private final SupplierService supplierService;
    private final ClayService clayService;

    @GetMapping("/supplier")
    public List<SupplierFetchCountView> getToSuppliersByClay() {
        JPAQuery<Long> query = new JPAQuery<Long>()
                .select(QSupplier.supplier.id)
                .from(QSupplier.supplier)
                .orderBy(QSupplier.supplier.clayList.size().asc());
        var pred = QSupplier.supplier.id.in(query);
        return supplierService.read(pred, PageRequest.of(0, 5)).stream()
                .map(SupplierMapper.INSTANCE::toSupplierFetchCountView).toList();
    }

    @GetMapping("/clayPrice")
    public List<ClayView> getClayByPrice() {
        JPAQuery<Long> query = new JPAQuery<Long>()
                .select(QClay.clay.id)
                .from(QClay.clay)
                .orderBy(QClay.clay.price.asc());
        var pred = QClay.clay.id.in(query);
        return clayService.read(pred, PageRequest.of(0, 5)).stream()
                .map(ClayMapper.INSTANCE::toClayView).toList();
    }

    @GetMapping("/clayOrder")
    public List<ClayFetchOrderCountView> getClayByOrder() {
        JPAQuery<Long> query = new JPAQuery<Long>()
                .select(QClay.clay.id)
                .from(QClay.clay)
                .where(QClay.clay.basketItems.any().basket.ordered.eq(true))
                .orderBy(QClay.clay.basketItems.size().asc());
        var pred = QClay.clay.id.in(query);
        return clayService.read(pred, PageRequest.of(0, 5)).stream()
                .map(ClayMapper.INSTANCE::toClayFetchOrderCountView).toList();
    }
}

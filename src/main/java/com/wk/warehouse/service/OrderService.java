package com.wk.warehouse.service;

import com.wk.warehouse.entity.Order;

import java.util.List;

public interface OrderService {
    List<Order> findByorderId(int orderId);

    List<Order> findBywagonId(String wagonId);

    List<Order> findBypage(int page);

    int insert(Order order);

    int update(Order order);

    int delete(int orderId);
    int isExist(int orderId);

    int total_order();
}

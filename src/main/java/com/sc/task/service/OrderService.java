package com.sc.task.service;

import com.sc.task.dto.OrderDto;

import java.util.List;

public interface OrderService {
    List<OrderDto> findAll();

    void save(OrderDto dto);

    boolean controlOrder(OrderDto dto);

}

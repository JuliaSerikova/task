package com.sc.task.controller;

import com.sc.task.dto.OrderDto;
import com.sc.task.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping
    public List<OrderDto> getOrders() {
        return orderService.findAll();
    }

    @PostMapping("/add")
    public void addOrder(@RequestBody OrderDto dto) {
        orderService.save(dto);
    }

    @PostMapping("/controlAdd")
    public void addControlOrder(@RequestBody OrderDto dto) {
        if (orderService.controlOrder(dto)) orderService.save(dto);
    }


}

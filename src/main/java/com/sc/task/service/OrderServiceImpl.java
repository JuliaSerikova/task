package com.sc.task.service;

import com.sc.task.domain.Order;
import com.sc.task.dto.OrderDto;
import com.sc.task.repository.CurrencyRepository;
import com.sc.task.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CurrencyRepository currencyRepository;

    @Override
    public List<OrderDto> findAll() {

        System.out.println(SecurityContextHolder.getContext().getAuthentication());

        return orderRepository.findAll().stream()
                .map(order -> {
                    OrderDto dto = new OrderDto();
                    dto.setAmount(order.getAmount());
                    dto.setFee(order.getFee());
                    dto.setId(order.getId());
                    dto.setSourceCurrency(order.getSourceCurrency().getCode());
                    dto.setTargetCurrency(order.getTargetCurrency().getCode());
                    return dto;
                }).collect(Collectors.toList());
    }

    @Override
    public void save(OrderDto dto) {
        Order order = new Order();

        order.setAmount(dto.getAmount());
        order.setFee(dto.getFee());

        currencyRepository.findByCode(dto.getSourceCurrency()).ifPresent(
                order::setSourceCurrency
        );

        currencyRepository.findByCode(dto.getTargetCurrency()).ifPresent(
                order::setTargetCurrency
        );
        order.setBeneficiar(dto.getBeneficiar());
        order.setPayer(dto.getPayer());
        order.setGround(dto.getGround());
        orderRepository.save(order);
    }

    @Override
    public boolean controlOrder(OrderDto dto) {
        /// проверки
//        сумма > 0
//        плательщик <> бенефициар
//        валюта1 <> валюта2
//        назначение 255
        // потом save

        return false;
    }


}

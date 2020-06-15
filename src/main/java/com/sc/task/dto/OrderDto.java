package com.sc.task.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import java.math.BigDecimal;

@Setter
@Getter
@ToString
public class OrderDto {

    private int id;

    private String sourceCurrency;

    private String targetCurrency;

    private BigDecimal amount;

    private BigDecimal fee;

    private String payer;

    private String beneficiar;

    private String ground;
}

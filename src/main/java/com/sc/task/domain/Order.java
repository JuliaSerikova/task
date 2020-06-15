package com.sc.task.domain;

import com.sc.task.domain.enums.OrderState;
import com.sc.task.domain.enums.OrderType;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "SC_ORDER")
@Setter
@Getter
@Slf4j
@EntityListeners(AuditingEntityListener.class)
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    private Currency sourceCurrency;

    @ManyToOne
    private Currency targetCurrency;

    @Enumerated(EnumType.STRING)
    private OrderType orderType;

    @Column(updatable = false)
    private BigDecimal amount;

    @Column(updatable = false)
    private BigDecimal fee;

    @Enumerated(EnumType.STRING)
    @Column(insertable = false)
    private OrderState orderState;

    @Column
    private String payer;

    @Column
    private String beneficiar;

    @Column
    private String ground;

}

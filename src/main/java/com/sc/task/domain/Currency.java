package com.sc.task.domain;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Immutable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Immutable
@Entity
@Getter
@Setter
public class Currency {

    @Id
    private int id;

    private String code;

    private String description;
}

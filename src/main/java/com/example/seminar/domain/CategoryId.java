package com.example.seminar.domain;

import jakarta.persistence.Embeddable;
import lombok.Getter;

import java.io.Serializable;

@Embeddable
@Getter
public class CategoryId implements Serializable {

    private String id;
}

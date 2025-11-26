package com.example.demo.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Calculator {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double value1;
    private double value2;
    private String operator;
    private double output;


}

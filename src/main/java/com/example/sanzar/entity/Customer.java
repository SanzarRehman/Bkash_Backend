package com.example.sanzar.entity;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long customerID;
    @NotBlank(message = "Give Name")
    private String customerName;
    private String customerAddresss;
    private String customerCode;
    private int balance;
    private int pin;
    private int NID;
    private int Phone;
    private String email;



}

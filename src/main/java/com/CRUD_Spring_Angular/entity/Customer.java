package com.CRUD_Spring_Angular.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private  String name;
    private  String email;
    private  String phone;
}

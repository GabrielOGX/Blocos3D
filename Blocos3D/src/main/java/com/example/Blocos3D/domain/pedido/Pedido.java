package com.example.Blocos3D.domain.pedido;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int andares;
    private String cor1;
    private String cor2;
    private String cor3;
    private String desenho1;
    private String desenho2;
    private String desenho3;

    // Getters e Setters
}

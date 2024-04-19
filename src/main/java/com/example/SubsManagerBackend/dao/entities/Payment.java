package com.example.SubsManagerBackend.dao.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class Payment {
@Id  @GeneratedValue(strategy = GenerationType.IDENTITY)

    private  Integer id;
    private Date date;
    private double amount;

    @ManyToOne
    private Subscription subscription;



}

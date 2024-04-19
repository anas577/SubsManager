package com.example.SubsManagerBackend.dao.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Subscription {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String plan ;
    private int coupon;
    private int renewalFrequency;
    private Date paymentDate;
    private double paymentCost;
}

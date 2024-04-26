package com.example.SubsManagerBackend.dao.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Subscription {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String plan ;
    private SubscriptionStatus status;
    private int coupon;
    private int renewalFrequency;
    private Date paymentDate;
    private double paymentCost;
    @ManyToOne
    private User user;

    @ManyToOne
    private Provider provider;

    @OneToMany(mappedBy = "subscription")
    private List<Payment> payments;

    @OneToMany(mappedBy = "subscription")
    private List<Notification> notifications;

}

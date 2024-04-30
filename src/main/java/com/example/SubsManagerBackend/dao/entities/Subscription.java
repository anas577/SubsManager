package com.example.SubsManagerBackend.dao.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
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
    private int renewalFrequency;
    private Date paymentDate;
    private double paymentCost;
    @ManyToOne
    private User user;

    @ManyToOne
    private Provider provider;

    @OneToMany(mappedBy = "subscription")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<Payment> payments;

    @OneToMany(mappedBy = "subscription")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<Notification> notifications;

    @OneToOne(mappedBy = "subscription")
    public Suggestion suggestion;
}

package com.example.SubsManagerBackend.dao.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class Notification {
    @Id     @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private int rate;
    private String message;

    @ManyToOne
    private Subscription subscription;
}

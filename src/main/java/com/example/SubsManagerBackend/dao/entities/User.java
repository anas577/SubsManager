package com.example.SubsManagerBackend.dao.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;
    private String username;
    private String emailAdress;
    @OneToMany(mappedBy = "user")
    private List<Suggestion> suggestions;

    @OneToMany(mappedBy = "user")
    private List<Subscription> subscriptions;

}

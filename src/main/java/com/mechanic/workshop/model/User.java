package com.mechanic.workshop.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "users")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String phone;

    @Column(name = "cpf_cnpj")
    private String cpfCnpj;

//    @OneToMany(mappedBy = "userId", cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<Order> order;

    @CreationTimestamp
    private LocalDateTime createdAt;

    private LocalDateTime deletedAt;

}

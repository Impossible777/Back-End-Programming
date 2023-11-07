package com.example.demo.entities;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.Date;
import java.util.Set;

@Entity
@Getter
@Setter
@CrossOrigin("http://localhost:4200")
@Table(name = "cart_items")
public class CartItem {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_item_id")
    private Long id;

    @Column(name = "create_date")
    @CreationTimestamp
    private Date create_date;

    @Column(name = "last_update")
    @UpdateTimestamp
    private Date last_update;

    @ManyToOne
    @JoinColumn(name="cart_id", nullable = false)
    private Cart cart;

    @ManyToOne
    @JoinColumn(name="vacation_id", nullable = false)
    private Vacation vacation;

    @ManyToMany
    @JoinTable(name = "excursion_cartitem",
    joinColumns = @JoinColumn(name = "cart_item_id"),
    inverseJoinColumns = @JoinColumn(name = "excursion_id"))
    private Set<Excursion> excursions;



}

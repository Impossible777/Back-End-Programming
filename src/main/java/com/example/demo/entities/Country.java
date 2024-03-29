package com.example.demo.entities;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "countries")
@Getter
@Setter
@CrossOrigin("http://localhost:4200")


public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "country_id")
    private Long id;

    @Column(name = "country")
    private String country_name;

    @Column(name = "create_date")
    private Date create_date;

    @Column(name = "last_update")
    private Date last_update;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "country")
    private Set<Division> divisions;



}

package com.EmplopyeemanagmentByyash.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
public class Emplopyee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String empcode;
    private String name;

    private LocalDate dob;
    private String gender;
    private Double salary;
    private String emailID;

    @ManyToOne
    @JoinColumn(name = "designation_id")
    private Desgination desgination;

    @ManyToOne
    @JoinColumn(name = "manager_id")
    private Emplopyee manager;
}


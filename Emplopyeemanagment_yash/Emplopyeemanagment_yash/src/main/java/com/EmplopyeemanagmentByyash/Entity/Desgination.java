package com.EmplopyeemanagmentByyash.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Desgination {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String desg_name;
}

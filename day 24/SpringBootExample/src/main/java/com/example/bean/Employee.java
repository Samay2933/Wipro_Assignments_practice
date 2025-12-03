package com.example.bean;

import jakarta.persistence.Entity;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
//this is JPA dependency entity class is mappied to the employee table in MySQL using
//below annotations @Entity, id,
public class Employee {

    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)

    int id;
    String name;

}

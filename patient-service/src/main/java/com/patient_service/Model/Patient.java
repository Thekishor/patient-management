package com.patient_service.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "Patients")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @NotNull
    @Column(name = "name")
    private String name;

    @Email
    @NotNull
    @Column(unique = true)
    private String email;

    @NotNull
    @Column(name = "address")
    private String address;

    @Column(nullable = false, name = "data_of_birth")
    private LocalDate dateOfBirth;

    @Column(nullable = false, name = "register_date")
    private LocalDate registerDate;
}

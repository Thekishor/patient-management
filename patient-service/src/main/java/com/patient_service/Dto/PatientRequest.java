package com.patient_service.Dto;

import com.patient_service.Dto.validators.CreatePatientValidationGroup;
import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Data
@Getter
@Setter
public class PatientRequest {

    @NotBlank(message = "Name cannot be blank")
    @Size(min = 2, max = 20, message = "Name must be between 2 and 20 characters")
    private String name;

    @Email(message = "Enter a valid email address")
    @NotBlank(message = "Email cannot be blank")
    private String email;

    @NotBlank(message = "Address cannot be blank")
    @Size(min = 4, max = 50, message = "Address must be between 6 and 20 characters")
    private String address;

    @Past(message = "Date of birth must be in the past")
    @NotNull(message = "Date of birth cannot be null")
    private LocalDate dateOfBirth;

    @PastOrPresent(message = "Register date cannot be in the future")
    @NotNull(groups = CreatePatientValidationGroup.class, message = "Registered date cannot be null")
    private LocalDate registerDate;
}

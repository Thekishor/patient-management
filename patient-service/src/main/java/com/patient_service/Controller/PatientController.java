package com.patient_service.Controller;

import com.patient_service.Dto.PatientRequest;
import com.patient_service.Dto.PatientResponse;
import com.patient_service.Dto.validators.CreatePatientValidationGroup;
import com.patient_service.Service.PatientService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.groups.Default;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/patients")
@Tag(name = "Patient", description = "API for managing Patients")
@RequiredArgsConstructor
public class PatientController {

    private final PatientService patientService;

    @GetMapping
    @Operation(summary = "Get Patients")
    public ResponseEntity<List<PatientResponse>> getAllPatients(){
        List<PatientResponse> patientResponses = patientService.getAllPatients();
        return new ResponseEntity<>(patientResponses, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get Patients By Id")
    public ResponseEntity<PatientResponse> getPatientById(@PathVariable("id") UUID id){
        PatientResponse patientResponse = patientService.getPatientById(id);
        return new ResponseEntity<>(patientResponse, HttpStatus.OK);
    }

    @PostMapping
    @Operation(summary = "Create Patient")
    public ResponseEntity<PatientResponse> createPatient(@Validated({Default.class, CreatePatientValidationGroup.class}) @RequestBody PatientRequest patientRequest){
        PatientResponse patientResponse = patientService.createPatient(patientRequest);
        return new ResponseEntity<>(patientResponse, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update Patient")
    public ResponseEntity<PatientResponse> updatePatient(@PathVariable("id") UUID id, @Validated({Default.class}) @RequestBody PatientRequest patientRequest){
        PatientResponse patientResponse = patientService.updatePatient(id, patientRequest);
        return new ResponseEntity<>(patientResponse, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a Patient")
    public ResponseEntity<?> deletePatient(@PathVariable("id") UUID id){
        patientService.deletePatient(id);
        return new ResponseEntity<>("Patient record deleted successfully", HttpStatus.OK);
    }
}

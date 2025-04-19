package com.patient_service.Mapper;

import com.patient_service.Dto.PatientRequest;
import com.patient_service.Dto.PatientResponse;
import com.patient_service.Model.Patient;

import java.time.format.DateTimeFormatter;

public class PatientMapper {
    public static PatientResponse patientResponse(Patient patient){
        PatientResponse patientResponse = new PatientResponse();
        patientResponse.setId(patient.getId().toString());
        patientResponse.setName(patient.getName());
        patientResponse.setAddress(patient.getAddress());
        patientResponse.setEmail(patient.getEmail());
        patientResponse.setDateOfBirth(patient.getDateOfBirth().toString());
        return patientResponse;
    }

    public static Patient patientRequestToPatient(PatientRequest patientRequest){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        Patient patient = new Patient();
        patient.setName(patientRequest.getName());
        patient.setEmail(patientRequest.getEmail());
        patient.setAddress(patientRequest.getAddress());
        patient.setDateOfBirth(patientRequest.getDateOfBirth());
        patient.setRegisterDate(patientRequest.getRegisterDate());
        return patient;
    }
}
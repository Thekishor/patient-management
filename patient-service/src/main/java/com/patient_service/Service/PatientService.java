package com.patient_service.Service;

import com.patient_service.Dto.PatientRequest;
import com.patient_service.Dto.PatientResponse;

import java.util.List;
import java.util.UUID;

public interface PatientService {

    List<PatientResponse> getAllPatients();

    PatientResponse createPatient(PatientRequest patientRequest);

    PatientResponse updatePatient(UUID id, PatientRequest patientRequest);

    void deletePatient(UUID id);

    PatientResponse getPatientById(UUID id);
}

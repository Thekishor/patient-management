package com.patient_service.ServiceImpl;

import com.patient_service.Dto.PatientRequest;
import com.patient_service.Dto.PatientResponse;
import com.patient_service.Exception.EmailAlreadyExistsException;
import com.patient_service.Exception.ResourceNotFoundException;
import com.patient_service.Mapper.PatientMapper;
import com.patient_service.Model.Patient;
import com.patient_service.Repository.PatientRepository;
import com.patient_service.Service.PatientService;
import com.patient_service.grpc.BillingServiceGrpcClient;
import com.patient_service.kafka.KafkaProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PatientServiceImpl implements PatientService {

    private final PatientRepository patientRepository;

    private final BillingServiceGrpcClient billingServiceGrpcClient;

    private final KafkaProducer kafkaProducer;

    @Override
    public List<PatientResponse> getAllPatients() {
        List<Patient> patients = patientRepository.findAll();
        return patients.stream().map(PatientMapper::patientResponse).toList();
    }

    @Override
    public PatientResponse createPatient(PatientRequest patientRequest) {
        if (patientRepository.existsByEmail(patientRequest.getEmail())){
            throw new EmailAlreadyExistsException("Email address already exists");
        }
        else {
            Patient patient = patientRepository.save(PatientMapper.patientRequestToPatient(patientRequest));
            billingServiceGrpcClient.createBillingAccount(patient.getId().toString(),
                    patient.getName(), patient.getEmail());
            kafkaProducer.sendEvent(patient);
            return PatientMapper.patientResponse(patient);
        }
    }

    @Override
    public PatientResponse updatePatient(UUID id, PatientRequest patientRequest) {
        Patient patient = patientRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Patient","ID", id));
        if (patientRepository.existsByEmailAndIdNot(patientRequest.getEmail(), id)){
            throw new EmailAlreadyExistsException("Email address already exists");
        }
        patient.setName(patientRequest.getName());
        patient.setEmail(patientRequest.getEmail());
        patient.setAddress(patientRequest.getAddress());
        patient.setDateOfBirth(patientRequest.getDateOfBirth());
        patientRepository.save(patient);
        return PatientMapper.patientResponse(patient);
    }

    @Override
    public void deletePatient(UUID id) {
        Patient patient = patientRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Patient","ID", id));
        patientRepository.delete(patient);
    }

    @Override
    public PatientResponse getPatientById(UUID id) {
        Patient patient = patientRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Patient","ID", id));
        return PatientMapper.patientResponse(patient);
    }
}

package ru.shipov.personservice.core.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table (name = "medical_histories")
public class MedicalHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn (name = "patient_id")
    private PatientEntity patient;

    @Column(name = "doc_number", unique = true)
    private String docNumber;

    @Column(name = "create_dttm")
    private LocalDateTime createDttm;

    @Column(name = "modify_dttm")
    private LocalDateTime modifyDttm;

    @Column(name = "doctor")
    private String doctor;

    @Column(name = "diagnosis")
    private String diagnosis;

    @OneToMany
    @JoinColumn(name = "medical_history")
    private List<MedicalHistory> medicalHistory;
}
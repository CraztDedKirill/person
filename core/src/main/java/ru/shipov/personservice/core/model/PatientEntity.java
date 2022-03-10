package ru.shipov.personservice.core.model;

import lombok.*;
import javax.persistence.*;
import java.time.LocalDate;


@Data
@Entity
@Table(name = "patients")
@AllArgsConstructor
@NoArgsConstructor
public class PatientEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Integer id;

    private String name;

    @Enumerated(EnumType.STRING)
    @Column
    private Gender gender;

    @Column (name = "age")
    private Integer age;

    @Column (name = "city")
    private String city;

    @Column (name = "adress")
    private String address;

    @Column (name = "birthday_dt")
    private LocalDate birthdayDt;

    @Column (name = "birthday_place")
    private String birthPlace;

    @Column (name = "registration")
    private String registration;

    @Column (name = "passport_series")
    private String passportSeries;

    @Column (name = "passport_number")
    private String passportNumber;

    @Column (name = "phone_number")
    private String phoneNumber;

    @Column (name = "another_document")
    private String anotherDocument;
}


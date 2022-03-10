package ru.shipov.personservice.core.repository;

import org.springframework.data.repository.CrudRepository;
import ru.shipov.personservice.core.model.PatientEntity;

public interface PatientEntityRepository extends CrudRepository<PatientEntity, Integer> {

    //PatientEntity findByPassport(String passportSeries, String passportNumber);
}

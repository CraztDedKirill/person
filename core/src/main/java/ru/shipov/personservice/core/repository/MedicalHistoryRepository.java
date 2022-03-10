package ru.shipov.personservice.core.repository;

import org.springframework.data.repository.CrudRepository;
import ru.shipov.personservice.core.model.MedicalHistory;

public interface MedicalHistoryRepository extends CrudRepository<MedicalHistory, Integer> {

}

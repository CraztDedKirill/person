package ru.shipov.personservice.core.service;

import org.springframework.stereotype.Service;
import ru.shipov.personservice.core.exeptions.UserAlreadyExist;
import ru.shipov.personservice.core.exeptions.UserNotFoundException;
import ru.shipov.personservice.core.model.PatientEntity;
import ru.shipov.personservice.core.repository.PatientEntityRepository;

import java.util.List;


@Service
public class PatientEntityService {

    private PatientEntityRepository repository;

    public PatientEntityService(PatientEntityRepository repository) {
        this.repository = repository;
    }

    public PatientEntity add(PatientEntity patient) throws UserAlreadyExist {

        if(/*repository.findByPassport(patient.getPassportSeries(), patient.getPassportNumber()) != null*/ false){
            throw new UserAlreadyExist("Пациент с такими пасспортными данными уже сущесвтует!");
        }

        return repository.save(patient);
    }

    public List<PatientEntity> getAll(){

        return (List<PatientEntity>) repository.findAll();
    }

    public PatientEntity getOne(Integer id) throws UserNotFoundException {

        if (repository.findById(id).get() == null) {
            throw new UserNotFoundException("Такого id не существует!");

        }

        return repository.findById(id).get();
    }

    public void delete(Integer id) throws UserNotFoundException {
        if (repository.findById(id) == null) {
            throw new UserNotFoundException("Такого id не существует!");

        } else repository.deleteById(id);

    }

    public void update(Integer id, PatientEntity patientEntity) throws UserNotFoundException {

        if (repository.findById(id) == null) {
            throw new UserNotFoundException("Такого id не сущесвтует!");
        }
        else{
            repository.deleteById(id);
            repository.save(patientEntity);
        }
    }

}

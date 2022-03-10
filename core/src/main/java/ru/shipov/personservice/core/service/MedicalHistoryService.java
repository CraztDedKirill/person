package ru.shipov.personservice.core.service;


import org.springframework.stereotype.Service;
import ru.shipov.personservice.core.exeptions.UserAlreadyExist;
import ru.shipov.personservice.core.exeptions.UserNotFoundException;
import ru.shipov.personservice.core.model.MedicalHistory;
import ru.shipov.personservice.core.repository.MedicalHistoryRepository;

import java.util.List;


@Service
public class MedicalHistoryService {

    private MedicalHistoryRepository repository;

    public MedicalHistoryService(MedicalHistoryRepository repository) {
        this.repository = repository;
    }

    public MedicalHistory add(MedicalHistory medicalHistory) throws UserAlreadyExist {

        return repository.save(medicalHistory);
    }

    public List<MedicalHistory> getAll(){

        return (List<MedicalHistory>) repository.findAll();
    }

    public MedicalHistory getOne(Integer id) throws UserNotFoundException {

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

    public void update(Integer id, MedicalHistory medicalHistory) throws UserNotFoundException {

        if (repository.findById(id) == null) {
            throw new UserNotFoundException("Такого id не сущесвтует!");
        }
        else{
            repository.deleteById(id);
            repository.save(medicalHistory);
        }
    }
}

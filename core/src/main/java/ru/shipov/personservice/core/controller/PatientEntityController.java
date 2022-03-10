package ru.shipov.personservice.core.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.shipov.personservice.core.exeptions.UserAlreadyExist;
import ru.shipov.personservice.core.exeptions.UserNotFoundException;
import ru.shipov.personservice.core.model.PatientEntity;
import ru.shipov.personservice.core.service.PatientEntityService;

@RestController
@RequestMapping("medical/patient")
public class PatientEntityController {

    private PatientEntityService service;

    public PatientEntityController(PatientEntityService service) {
        this.service = service;
    }

    @GetMapping("/")
    public ResponseEntity getAll() {

        try {
            service.getAll();
            return new ResponseEntity(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.CREATED);
        }

    }

    @GetMapping("/{id}")
    public ResponseEntity getOne(@RequestParam Integer id) {

        try {
            service.getOne(id);
            return new ResponseEntity(HttpStatus.OK);
        } catch (UserNotFoundException e) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.BAD_GATEWAY);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(Integer id) {
        try {
            service.delete(id);
            return new ResponseEntity(HttpStatus.OK);
        } catch (UserNotFoundException e) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.BAD_GATEWAY);
        }

    }

    @PostMapping("/")
    public ResponseEntity add(@RequestBody PatientEntity patient){

        try {
            service.add(patient);
            return new ResponseEntity(HttpStatus.CREATED);
        }
        catch (UserAlreadyExist e){
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        catch (Exception e){
            return new ResponseEntity(HttpStatus.BAD_GATEWAY);
        }

    }

    @PatchMapping("/{id}")
    public ResponseEntity update(@PathVariable Integer id, @RequestBody PatientEntity patientEntity) {
        try{
            service.update( id, patientEntity);
            return new ResponseEntity(HttpStatus.CREATED);
        }
        catch (UserNotFoundException e){
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        catch (Exception e){
            return new ResponseEntity(HttpStatus.BAD_GATEWAY);
        }
    }

}

package ru.shipov.personservice.core.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.shipov.personservice.core.exeptions.UserNotFoundException;
import ru.shipov.personservice.core.model.MedicalHistory;
import ru.shipov.personservice.core.service.MedicalHistoryService;


@RestController
@RequestMapping("medical/history")
public class MedicalHistoryController {

    private MedicalHistoryService service;

    public MedicalHistoryController(MedicalHistoryService service) {
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
    public ResponseEntity add(@RequestBody MedicalHistory medicalHistory) {
        try {
            service.add(medicalHistory);
            return new ResponseEntity(HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity update(@PathVariable Integer id, @RequestBody MedicalHistory medicalHistory) {
        try{
            service.update( id,medicalHistory);
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


package ru.shipov.personservice.core.exeptions;

public class UserAlreadyExist extends Exception{

    public UserAlreadyExist(String message) {
        super(message);
    }

}

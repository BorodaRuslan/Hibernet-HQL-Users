package org.example.app.service;

import org.example.app.entities.Users;
import org.example.app.exceptions.CreateException;
import org.example.app.repositories.UsersCreateRepositories;
import org.example.app.utils.Contstans;
import org.example.app.utils.EmailValidator;

import java.util.HashMap;
import java.util.Map;

public class UsersCreateService {
    UsersCreateRepositories repositories;

    public UsersCreateService(UsersCreateRepositories repositories) {
        this.repositories = repositories;
    }


    public String createUser(String [] data){
        Map<String,String> errors = validateData(data);

        if(!errors.isEmpty()){
            try {
                throw new CreateException("Check inputs", errors);
            } catch (CreateException e){
                return e.getErrors(errors);
            }
        }
        return repositories.createUser(converData(data));

    }


    private Map<String, String>  validateData(String [] data){
        Map<String, String> errors = new HashMap<>();

        if (data[0].isEmpty())
            errors.put("User name", Contstans.INPUT_REQ_MSG);
        if (data[1].isEmpty())
            errors.put("First name", Contstans.INPUT_REQ_MSG);
        if (data[2].isEmpty())
            errors.put("last mane", Contstans.INPUT_REQ_MSG);

        if (EmailValidator.isEmailValid(data[3]))
            errors.put("email", Contstans.WRONG_EMAIL_MSG);

        return errors;
    }

    private Users converData(String [] data){
        Users user = new Users();
        user.setUserName(data[0]);
        user.setFirstName(data[1]);
        user.setLastName(data[2]);
        user.setEmail(data[3]);
        return user;
    }

}

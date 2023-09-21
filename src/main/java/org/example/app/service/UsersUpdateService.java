package org.example.app.service;

import org.example.app.entities.Users;
import org.example.app.exceptions.UpdateException;
import org.example.app.repositories.UsersUpdateRepository;
import org.example.app.utils.Contstans;
import org.example.app.utils.EmailValidator;
import org.example.app.utils.IdValidator;

import java.util.HashMap;
import java.util.Map;

public class UsersUpdateService {
    UsersUpdateRepository repository;

    public UsersUpdateService(UsersUpdateRepository repository) {
        this.repository = repository;
    }

    public String updateUser(String[] data) {
        Map<String, String> errors = validateData(data);

        if (!errors.isEmpty()) {
            try {
                throw new UpdateException("Check inputs", errors);
            } catch (UpdateException e) {
                return e.getErrors(errors);
            }
        }
        return repository.updateUsers(convertData(data));

    }

    private Map<String, String> validateData(String [] data){
        Map<String, String> errors = new HashMap<>();
        if (IdValidator.isIdValid(data[0]))
            errors.put("id", Contstans.WRONG_ID_MSG);

        if (EmailValidator.isEmailValid(data[1]))
            errors.put("email", Contstans.WRONG_EMAIL_MSG);
        return errors;
    }

    private Users convertData(String[] data){
        Users user = new Users();
        user.setId(Integer.parseInt(data[0]));
        user.setEmail(data[1]);
        return user;
    }
}

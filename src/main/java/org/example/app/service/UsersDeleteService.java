package org.example.app.service;

import org.example.app.entities.Users;
import org.example.app.exceptions.UpdateException;
import org.example.app.repositories.UsersDeleteRepositories;
import org.example.app.utils.Contstans;
import org.example.app.utils.IdValidator;

import java.util.HashMap;
import java.util.Map;

public class UsersDeleteService {

    UsersDeleteRepositories repositories;


    public String deleteContact(String[] data) {

        Map<String, String> errors = validateData(data);

        if (!errors.isEmpty()) {
            try {
                throw new UpdateException("Check inputs", errors);
            } catch (UpdateException ue) {
                return ue.getErrors(errors);
            }
        }

        return repositories.deleteUserById(convertData(data));
    }

    private Map<String, String> validateData(String[] data) {
        Map<String, String> errors = new HashMap<>();

        if (IdValidator.isIdValid(data[0]))
            errors.put("id", Contstans.WRONG_ID_MSG);

        return errors;
    }

    private Users convertData(String[] data) {
        Users user = new Users();
        user.setId(Integer.parseInt(data[0]));
        return user;
    }
}

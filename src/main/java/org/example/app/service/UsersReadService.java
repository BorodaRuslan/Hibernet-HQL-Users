package org.example.app.service;

import org.example.app.entities.Users;
import org.example.app.repositories.UsersReadRepositories;
import org.example.app.utils.Contstans;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class UsersReadService {

    UsersReadRepositories repositories;

    public UsersReadService(UsersReadRepositories repositories) {
        this.repositories = repositories;
    }

    public String readUsers(){
        List<Users> list = repositories.readUsers();

        if (list != null) {
            if (!list.isEmpty()) {
                AtomicInteger count = new AtomicInteger(0);
                StringBuilder stringBuilder = new StringBuilder();

                list.forEach((users) -> stringBuilder.append(count.incrementAndGet())
                        .append(") ID: ")
                        .append(users.getId())
                        .append(", ")
                        .append(users.getUserName())
                        .append(", ")
                        .append(users.getFirstName())
                        .append(", ")
                        .append(users.getLastName())
                        .append(", ")
                        .append(users.getEmail())
                        .append("\n"));
                return "\n______ USERS ___________\n" + stringBuilder;
            } else {
                return Contstans.DATA_ABSENT_MSG;
            }
        } else {
            return Contstans.DATA_ABSENT_MSG;
        }
    }
}

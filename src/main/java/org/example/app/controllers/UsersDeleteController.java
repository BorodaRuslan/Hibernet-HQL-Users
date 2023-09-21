package org.example.app.controllers;

import org.example.app.service.UsersDeleteService;
import org.example.app.utils.AppStarter;
import org.example.app.views.UsersDeleteView;

public class UsersDeleteController {
    UsersDeleteService service;
    UsersDeleteView view;

    public UsersDeleteController(UsersDeleteService service, UsersDeleteView view) {
        this.service = service;
        this.view = view;
    }

    public void deleteContact() {
        view.getOutput(service.deleteContact(view.getData()));
        AppStarter.startApp();
    }
}

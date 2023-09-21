package org.example.app.controllers;

import org.example.app.service.UsersReadService;
import org.example.app.utils.AppStarter;
import org.example.app.views.UsersReadView;

public class UsersReadController {
    UsersReadService service;
    UsersReadView view;

    public UsersReadController(UsersReadService service, UsersReadView view) {
        this.service = service;
        this.view = view;
    }

    public void readContacts() {
        view.getOutput(service.readUsers());
        AppStarter.startApp();
    }
}


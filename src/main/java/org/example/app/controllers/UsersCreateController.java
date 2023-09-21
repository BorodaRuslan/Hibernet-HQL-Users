package org.example.app.controllers;

import org.example.app.service.UsersCreateService;
import org.example.app.utils.AppStarter;
import org.example.app.views.UsersCreateView;

public class UsersCreateController {

    UsersCreateView view;
    UsersCreateService service;

    public UsersCreateController(UsersCreateView view, UsersCreateService service) {
        this.view = view;
        this.service = service;
    }
    public void creatUser(){
        view.getOutput(service.createUser(view.getData()));
        AppStarter.startApp();
    }
}

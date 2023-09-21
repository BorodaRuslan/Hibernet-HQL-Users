package org.example.app.service;

import org.example.app.exceptions.OptionException;
import org.example.app.repositories.UsersCreateRepositories;
import org.example.app.repositories.UsersDeleteRepositories;
import org.example.app.repositories.UsersReadRepositories;
import org.example.app.repositories.UsersUpdateRepository;
import org.example.app.utils.AppStarter;
import org.example.app.utils.Contstans;
import org.example.app.views.UsersCreateView;
import org.example.app.views.UsersDeleteView;
import org.example.app.views.UsersReadView;
import org.example.app.views.UsersUpdateView;

public class AppService {

    public void  createUser(){
        UsersCreateRepositories repositori = new UsersCreateRepositories();
        UsersCreateService service = new UsersCreateService(repositori);
        UsersCreateView view = new UsersCreateView();

        // Тут должен быть контролер!
    }

    public void readUser(){
        UsersReadRepositories repositories = new UsersReadRepositories();
        UsersReadService service = new UsersReadService(repositories);
        UsersReadView view = new UsersReadView();

        // Тут должен быть контролер!
    }

    public void  updateUser(){
        UsersUpdateRepository repository = new UsersUpdateRepository();
        UsersUpdateService service = new UsersUpdateService(repository);
        UsersUpdateView view = new UsersUpdateView();

        // Тут должен быть контролер!
    }

    public void  deleteUser(){
        UsersDeleteRepositories repositories = new UsersDeleteRepositories();
        UsersDeleteService service = new UsersDeleteService();
        UsersDeleteView view = new UsersDeleteView();

        // Тут должен быть контролер!
    }

    public void getNoSuchOption(int choice) {
        int[] menuChoices = {0, 1, 2, 3, 4};
        if (!contains(menuChoices, choice)) {
            try {
                throw new OptionException(Contstans.INCORRECT_VALUE_MSG);
            } catch (OptionException e) {
                System.out.println(e.getMessage());
                AppStarter.startApp();
            }
        }
    }

    public static boolean contains(final int[] options, final int value) {
        boolean result = false;
        for (int i : options) {
            if (i == value) {
                result = true;
                break;
            }
        }
        return result;
    }
}

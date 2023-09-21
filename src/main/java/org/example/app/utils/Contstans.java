package org.example.app.utils;

public class Contstans {


    public final static String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
    public final static String BD_URL = "jdbc:mysql://localhost:3306/users?";

    public final static String DIALECT = "org.hibernate.dialect.MySQL8Dialect";
    public final static String DB_USER = "root";


    // Валидация с помощью регулярных выражений
    public final static String PHONE_RGX = "[0-9]{3}[\\ ][0-9]{3}-[0-9]{4}";
    public final static String WRONG_PHONE_MSG = "Wrong phone input.";
    public final static String EMAIL_RGX = "^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
    public final static String WRONG_EMAIL_MSG = "Wrong email input.";
    public final static String ID_RGX = "^[1-9]$";
    public final static String WRONG_ID_MSG = "Wrong id input.";


    public final static String DATA_ABSENT_MSG = "\n>> No data!";
    public final static String DATA_INSERT_MSG = "\n>> Created.";
    public final static String DATA_UPDATE_MSG = "\n>> Updated.";
    public final static String DATA_DELETE_MSG = "\n>> Deleted.";

    public final static String APP_CLOSE_MSG = "\n>> App closed.";
    public final static String INPUT_REQ_MSG = "Input required.";

    public final static String INCORRECT_VALUE_MSG = ">> Incorrect value! Try again.";
    public final static String ID_NO_EXISTS_MSG = "\n>> There is no such ID.";





}

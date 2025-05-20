package com.example.Test.TestingPatterns.ChainOfResponsibility;

import java.util.HashMap;
import java.util.Map;

public class Authentication {
    public static void main(String[] args){
        Database db = new Database();
        Handler handler = new UserExistHandler(db);
        Handler handler2 = new ValidPasswordHandler(db);
        Handler handler3 = new RoleCheckHandler();

        handler.setNextHandler(handler2);
        handler2.setNextHandler(handler3);

        AuthService auth = new AuthService(handler);
        auth.authenticate("admin_username", "admin_password");

        System.out.println();
        auth.authenticate("user_username", "user_password");
        System.out.println();

        auth.authenticate("user_username", "asds");
        System.out.println();

        auth.authenticate("Uasdr","asd");
        System.out.println();

    }
}

class AuthService{
    private Handler handler;
    public AuthService(Handler handler){
        this.handler = handler;
    }

    public boolean authenticate(String username, String password){
        if (handler.handle(username, password)) {
            System.out.println("Authorization was successful!");
            return true;
        }
        return false;
    }
}

class Database {

    private final Map<String, String> users;

    public Database() {
        users = new HashMap<>();
        users.put("admin_username", "admin_password");
        users.put("user_username", "user_password");
    }

    public boolean isValidUser(String username) {
        return users.containsKey(username);
    }

    public boolean isValidPassword(String username, String password) {
        return users.get(username).equals(password);
    }

}

abstract class Handler{
    protected Handler nextHandler;

    public Handler setNextHandler(Handler nextHandler) {
        this.nextHandler = nextHandler;
        return this.nextHandler;
    }

    public abstract boolean handle(String username, String password);

    public boolean handleNext(String username, String password){
        if(nextHandler == null){
            return true;
        }
        return this.nextHandler.handle(username,password);
    }

}

class UserExistHandler extends Handler{
    private Database db;

    public UserExistHandler(Database database){
        this.db = database;
    }
    @Override
    public boolean handle(String username, String password) {
        if(db.isValidUser(username)){
            return this.handleNext(username, password); // <-- FIXED
        }

        System.out.println("This username is not registered!");
        System.out.println("Sign Up to our app now!");
        return false;
    }

}

class ValidPasswordHandler extends Handler {
    private Database db;
    public ValidPasswordHandler(Database db){
        this.db = db;
    }

    @Override
    public boolean handle(String username, String password){
        if(db.isValidPassword(username, password)){
            return this.handleNext(username, password);
        }

        System.out.println("Wrong Password!");
        return false;
    }

}

class RoleCheckHandler extends Handler{
    @Override
    public boolean handle(String username, String password) {
        if ("admin_username".equals(username)) {
            System.out.println("Loading Admin Page...");
            return true;
        }
        System.out.println("Loading Default Page...");
        return handleNext(username, password);
    }
}

































package jm.task.core.jdbc;

import jm.task.core.jdbc.service.UserServiceImpl;

public class Main {
    public static void main(String[] args) {
        UserServiceImpl userService = new UserServiceImpl();
        userService.createUsersTable();
        userService.saveUser("Khusein", "Navruzov", (byte) 26);
        userService.saveUser("Karen", "Kazaryan", (byte) 28);
        userService.saveUser("Vladimir", "Krapivko", (byte) 24);
        userService.saveUser("Igor", "Entaev", (byte) 32);
        userService.getAllUsers();
        userService.cleanUsersTable();
        userService.dropUsersTable();
    }
}
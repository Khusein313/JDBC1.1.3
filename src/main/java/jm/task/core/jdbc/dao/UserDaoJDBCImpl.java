package jm.task.core.jdbc.dao;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {   //класс реализующий методы интерфейса
    Connection connection = Util.getConnection();

    public UserDaoJDBCImpl()  {

    }

    public void createUsersTable() {                                    //создаю таблицу 'user' с параметрами для БД.
        String sqlCreatingTable = "CREATE TABLE IF NOT EXISTS users " +
                "(id INT PRIMARY KEY AUTO_INCREMENT, " +
                "name VARCHAR(45), " +
                "lastName VARCHAR(45), " +
                "age TINYINT ) ";
        try(Statement statement = connection.createStatement()) {
            statement.executeUpdate(sqlCreatingTable);
            System.out.println("Этап создания таблицы...");
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void dropUsersTable() {                                                  //Удалю саму таблицу из БД
        String sqlDeleteTable = "DROP TABLE IF EXISTS users";
        try (Statement statement = connection.createStatement()){
            statement.executeUpdate(sqlDeleteTable);
            System.out.println("Этап удаления таблицы...");
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void saveUser(String name, String lastName, byte age) {                                      //create newUser
        String sqlInputUser = "INSERT INTO users (name, lastName, age) VALUES (?, ?, ?)";
        try(PreparedStatement preparedStatement = connection.prepareStatement(sqlInputUser)) {
            preparedStatement.setString(1,name);
            preparedStatement.setString(2,lastName);
            preparedStatement.setByte(3,age);
            preparedStatement.executeUpdate();
            System.out.println("Этап добавления эл-та в таблицу...");
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removeUserById(long id) {
        String sqlDeleteThisUser = "DELETE FROM users WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlDeleteThisUser)){
            preparedStatement.setLong(1,id);
            preparedStatement.executeUpdate();
            System.out.println("Этап удаления определённого эл-нта");
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        String sqlGetAllUsers = "SELECT * FROM users";
        try(Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sqlGetAllUsers);
            while(resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getLong("id"));
                user.setName(resultSet.getString("name"));
                user.setLastName(resultSet.getString("lastName"));
                user.setAge(resultSet.getByte("age"));
                users.add(user);
            }
            System.out.println("Этап получения данных из таблицы...");
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    public void cleanUsersTable() {                                         // Удалю список Юзеров из Таблицы(не удаляя её саму)
        String sqlDeleteTable = "DELETE FROM users";
        try (Statement statement = connection.createStatement()){
            statement.executeUpdate(sqlDeleteTable);
            System.out.println("Этап удаления всех объектов из таблицы...");
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
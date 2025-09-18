package jm.task.core.jdbc.util;

import jm.task.core.jdbc.model.User;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Util {
    // реализуйте настройку соеденения с БД
    private final static String URL = "jdbc:mysql://localhost:3306/mydbtest";
    private final static String USERNAME = "Khusein313";
    private final static String PASSWORD = "1vfvfgfgf";
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static SessionFactory sf;

    public static Connection getConnection()  {
        //Connection to database; Соединение с базой данных
        Connection connection = null;

        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

        }catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static SessionFactory getsf() {
        try {
            Properties properties = new Properties();
            properties.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
            properties.put(Environment.URL, "jdbc:mysql://localhost:3306/mydbtest");
            properties.put(Environment.USER, "Khusein313");
            properties.put(Environment.PASS, "1vfvfgfgf");
            properties.put(Environment.DIALECT, "org.hibernate.dialect.MySQLDialect");
            properties.put(Environment.SHOW_SQL, "true");

            sf = new Configuration().setProperties(properties)
                    .addAnnotatedClass(User.class)
                    .buildSessionFactory();

        } catch (HibernateException e) {
            e.printStackTrace();
        }
        finally {
            sf.close();
        }
        return sf;
    }
   }


//    public static SessionFactory factory() {
//        SessionFactory sessionFactory = new Configuration()
//                .configure("hibernate.cfg.xml") //команда позволяющая СФ прочитать наш файл из ресурсов
//                .addAnnotatedClass(User.class) //метод указывает на класс который имеет анотации для работы с БД
//                .buildSessionFactory(); // Метод для итоговой настройки СФ.
//        try {
//            Session session = sessionFactory.getCurrentSession();   //с помощью заданных настроек СФ создай временную сессию
//            User user = new User("Khusein", "Navruzov", (byte) 26);
//            session.beginTransaction();     //запускаем программу сессии далее можно выполнять действия
//            session.save(user);         //сохранили объект в базу
//            session.getTransaction().commit();  //Закрытие сессии и сохранение действий
//        }
//        finally {
//            sessionFactory.close();
//        }
//        return sessionFactory;
//    }
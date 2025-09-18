package jm.task.core.jdbc.model;

import javax.persistence.*;

@Entity // ан-я означает что этот класс будет отображён в виде таблицы в БД.
@Table (name = "user") // ан-я привязывает класс к таблице указанной в БД (если имена отличаются но надо вложить туда)
public class User {
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                '}';
    }
    @Column(name = "id") //ан-я указывает на то к какому столцу таблицы мы привязываем поле класса (name,id,age т.д)
    @Id //ан-я указывает на то что это данное поле и стобец таблицы являются Primary Key
    @GeneratedValue(strategy = GenerationType.IDENTITY) //ан-я для генирирования уникальных значений по опред-му алгоритму
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "lastName")
    private String lastName;

    @Column(name = "age")
    private Byte age;

    public User() {     //по правилам обязан быть один пустой конструктор(даже если есть готовый заполненый)

    }

    public User(String name, String lastName, Byte age) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Byte getAge() {
        return age;
    }

    public void setAge(Byte age) {
        this.age = age;
    }
}

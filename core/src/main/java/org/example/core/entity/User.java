package org.example.core.entity;

public class User {

    private String id;
    private String name;
    private int age;

    public static User create(String name, int age) {
        User User = new User();
        User.setAge(age);
        User.setName(name);
        return User;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}

package org.example.core.domain;

public class Student {
    private String id;
    private String name;
    private int age;


    public static Student create(String name, int age) {
        Student student = new Student();
        student.setAge(age);
        student.setName(name);
        return student;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

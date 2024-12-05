package org.example.client.model;

public class StudentCreateResponse {

    private String id;
    private String name;
    private int age;

    public StudentCreateResponse(String id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}

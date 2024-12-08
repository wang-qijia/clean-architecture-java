package org.cleanarchitecture.infrastructure.rpc.api.model;

public class UserResponse {

    private String id;
    private String name;
    private int age;

    public UserResponse(String id, String name, int age) {
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

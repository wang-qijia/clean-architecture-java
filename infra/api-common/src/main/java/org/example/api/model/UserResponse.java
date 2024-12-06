package org.example.api.model;

import org.example.core.usecase.model.UserOutput;

/**
 * @author : wangqijia create at:  2024/12/6  2:01 PM
 */
public class UserResponse {

    private String id;
    private String name;
    private int age;

    public UserResponse(String id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public static UserResponse toResponse(UserOutput output) {
        return new UserResponse(output.getId(), output.getName(), output.getAge());
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

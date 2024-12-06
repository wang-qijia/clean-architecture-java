package org.example.core.usecase.model;

import org.example.core.entity.User;

/**
 * @author : wangqijia create at:  2024/12/5  10:53 AM
 */
public class UserOutput {

    private final String id;

    private final String name;

    private final int age;

    public UserOutput(String id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public static UserOutput from(User User) {
        return new UserOutput(User.getId(), User.getName(), User.getAge());
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

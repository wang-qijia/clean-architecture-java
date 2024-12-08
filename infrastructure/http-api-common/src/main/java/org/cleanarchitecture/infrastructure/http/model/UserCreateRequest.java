package org.cleanarchitecture.infrastructure.http.model;

import org.cleanarchitecture.core.usecase.model.CreateUserInput;

/**
 * @author : wangqijia create at:  2024/12/5  2:26 PM
 */
public class UserCreateRequest {

    private String name;
    private int age;

    public CreateUserInput toInput() {
        return new CreateUserInput(this.getName(), this.getAge());
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
}

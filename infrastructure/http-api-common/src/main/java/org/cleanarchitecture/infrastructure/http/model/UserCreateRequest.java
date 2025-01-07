package org.cleanarchitecture.infrastructure.http.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.cleanarchitecture.core.usecase.model.CreateUserInput;

/**
 * @author : wangqijia create at:  2024/12/5  2:26 PM
 */
public class UserCreateRequest {
    @NotBlank
    private String name;

    @NotNull
    private Integer age;

    public CreateUserInput toInput() {
        return new CreateUserInput(this.getName(), this.getAge());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}

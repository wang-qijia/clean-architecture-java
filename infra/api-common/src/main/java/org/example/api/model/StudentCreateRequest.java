package org.example.api.model;

import org.example.core.usecase.model.CreateStudentInput;

/**
 * @author : wangqijia create at:  2024/12/5  2:26 PM
 */
public class StudentCreateRequest {
    private String name;
    private int age;

    public CreateStudentInput toInput() {
        return new CreateStudentInput(this.getName(), this.getAge());
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

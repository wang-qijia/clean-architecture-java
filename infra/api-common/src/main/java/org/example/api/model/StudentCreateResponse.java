package org.example.api.model;

import org.example.core.usecase.model.CreateStudentOutput;

public class StudentCreateResponse {

    private String id;
    private String name;
    private int age;

    public StudentCreateResponse(String id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public static StudentCreateResponse toResponse(CreateStudentOutput output) {
        return new StudentCreateResponse(output.getId(), output.getName(), output.getAge());
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

package org.example.api.model;

import org.example.core.usecase.model.FindStudentByNameOutput;

public class StudentFindResponse {

    private String id;
    private String name;
    private int age;

    public StudentFindResponse(String id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public static StudentFindResponse toResponse(FindStudentByNameOutput output) {
        return new StudentFindResponse(output.getId(), output.getName(), output.getAge());
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

package org.example.api.model;

import org.example.core.usecase.model.StudentData;

/**
 * @author : wangqijia create at:  2024/12/5  3:09 PM
 */
public class StudentJson {

    private final String id;

    private final String name;

    private final int age;

    public StudentJson(String id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }


    public static StudentJson toJson(StudentData studentData) {
        return new StudentJson(studentData.getId(), studentData.getName(), studentData.getAge());
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

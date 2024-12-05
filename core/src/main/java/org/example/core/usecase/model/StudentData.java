package org.example.core.usecase.model;

import org.example.core.domain.Student;

/**
 * @author : wangqijia create at:  2024/12/5  10:53 AM
 */
public class StudentData {

    private final String id;

    private final String name;

    private final int age;

    public StudentData(String id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public static StudentData from(Student student) {
        return new StudentData(student.getId(), student.getName(), student.getAge());
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

package org.example.core.usecase.model;

import org.example.core.domain.Student;

/**
 * @author : wangqijia create at:  2024/12/5  1:58 PM
 */
public class FindStudentByNameOutput {

    private final String id;

    private final String name;

    private final int age;


    private FindStudentByNameOutput(String id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public static FindStudentByNameOutput from(Student student) {
        return new FindStudentByNameOutput(student.getId(), student.getName(), student.getAge());
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
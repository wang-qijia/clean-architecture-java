package org.example.core.usecase.model;

/**
 * @author : wangqijia create at:  2024/12/5  11:18 AM
 */
public class CreateStudentInput {

    private final String name;

    private final int age;

    public CreateStudentInput(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void validate() {
        if (name == null) {
//        throw new UseCaseException(name);
        }

    }


    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
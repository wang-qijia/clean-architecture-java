package org.cleanarchitecture.core.usecase.model;

/**
 * @author : wangqijia create at:  2024/12/5  11:18 AM
 */
public class CreateUserInput {

    private final String name;

    private final int age;

    public CreateUserInput(String name, int age) {
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
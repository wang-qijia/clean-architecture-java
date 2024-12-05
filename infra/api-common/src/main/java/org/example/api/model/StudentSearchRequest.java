package org.example.api.model;

import org.example.core.usecase.model.SearchStudentInput;

/**
 * @author : wangqijia create at:  2024/12/5  11:21 AM
 */
public class StudentSearchRequest {
    private int page;
    private int size;
    private String name;

    public StudentSearchRequest(int page, int size) {
        this.page = page;
        this.size = size;
    }


    public SearchStudentInput toInput(){
        SearchStudentInput input = new SearchStudentInput(this.page, this.size);
        input.setName(getName());
        return input;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPage() {
        return page;
    }

    public int getSize() {
        return size;
    }
}

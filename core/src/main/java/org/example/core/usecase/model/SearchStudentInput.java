package org.example.core.usecase.model;

/**
 * @author : wangqijia create at:  2024/12/5  11:21 AM
 */
public class SearchStudentInput {

    private int page;
    private int size;
    private String name;

    public SearchStudentInput(int page, int size) {
        this.page = page;
        this.size = size;
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

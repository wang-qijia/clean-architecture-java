package org.cleanarchitecture.infrastructure.http.model;

import org.cleanarchitecture.core.usecase.model.SearchUserInput;

/**
 * @author : wangqijia create at:  2024/12/5  11:21 AM
 */
public class UserSearchRequest {

    private int page;
    private int size;
    private String name;

    public UserSearchRequest(int page, int size) {
        this.page = page;
        this.size = size;
    }


    public SearchUserInput toInput() {
        SearchUserInput input = new SearchUserInput(this.page, this.size);
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

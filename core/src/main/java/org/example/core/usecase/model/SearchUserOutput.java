package org.example.core.usecase.model;

import java.util.Collections;
import java.util.List;

/**
 * @author : wangqijia create at:  2024/12/5  11:29 AM
 */
public class SearchUserOutput {

    private List<UserOutput> Users;
    private int total;
    private boolean hasNext;

    public static SearchUserOutput emptyResult() {
        SearchUserOutput emptyResult = new SearchUserOutput();
        emptyResult.setUsers(Collections.emptyList());
        return emptyResult;
    }

    public static SearchUserOutput create(List<UserOutput> Users, int total, boolean hasNext) {
        SearchUserOutput result = new SearchUserOutput();
        result.setUsers(Users);
        result.setTotal(total);
        result.setHasNext(hasNext);
        return result;
    }

    public List<UserOutput> getUsers() {
        return Users;
    }

    public void setUsers(List<UserOutput> Users) {
        this.Users = Users;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public boolean getHasNext() {
        return hasNext;
    }

    public void setHasNext(boolean hasNext) {
        this.hasNext = hasNext;
    }
}
package org.example.api.model;

import java.util.List;
import java.util.stream.Collectors;
import org.example.core.usecase.model.SearchUserOutput;

/**
 * @author : wangqijia create at:  2024/12/5  11:21 AM
 */
public class UserSearchResponse {

    private List<UserResponse> users;
    private int total;
    private boolean hasNext;

    public UserSearchResponse() {
    }

    public UserSearchResponse(List<UserResponse> users, int total, boolean hasNext) {
        this.users = users;
        this.total = total;
        this.hasNext = hasNext;
    }

    public static UserSearchResponse toResponse(SearchUserOutput output) {
        List<UserResponse> UserResponses = output.getUsers().stream()
            .map(UserResponse::toResponse)
            .collect(Collectors.toList());
        return new UserSearchResponse(UserResponses, output.getTotal(), output.getHasNext());

    }

    public List<UserResponse> getUsers() {
        return users;
    }

    public void setUsers(List<UserResponse> users) {
        this.users = users;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public boolean isHasNext() {
        return hasNext;
    }

    public void setHasNext(boolean hasNext) {
        this.hasNext = hasNext;
    }
}

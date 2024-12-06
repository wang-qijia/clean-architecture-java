package org.example.client;

import org.example.client.model.Response;
import org.example.client.model.UserCreateRequest;
import org.example.client.model.UserResponse;

/**
 * @author : wangqijia create at:  2024/12/5  5:29 PM
 */
public interface UserService {


    Response<UserResponse> create(UserCreateRequest request);

}

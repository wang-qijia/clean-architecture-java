package org.cleanarchitecture.infrastructure.rpc.api;

import org.cleanarchitecture.infrastructure.rpc.api.model.Response;
import org.cleanarchitecture.infrastructure.rpc.api.model.UserResponse;
import org.cleanarchitecture.infrastructure.rpc.api.model.UserCreateRequest;

/**
 * @author : wangqijia create at:  2024/12/5  5:29 PM
 */
public interface UserService {


    Response<UserResponse> create(UserCreateRequest request);

}

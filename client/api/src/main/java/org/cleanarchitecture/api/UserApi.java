package org.cleanarchitecture.api;

import org.cleanarchitecture.api.model.Response;
import org.cleanarchitecture.api.model.UserResponse;
import org.cleanarchitecture.api.model.UserCreateRequest;

/**
 * @author : wangqijia create at:  2024/12/5  5:29 PM
 */
public interface UserApi {

    Response<UserResponse> create(UserCreateRequest request);

}

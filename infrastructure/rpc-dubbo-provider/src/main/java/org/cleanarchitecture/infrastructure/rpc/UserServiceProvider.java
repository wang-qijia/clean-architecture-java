package org.cleanarchitecture.infrastructure.rpc;

import org.apache.dubbo.config.annotation.DubboService;

import org.cleanarchitecture.core.usecase.CreateUserUseCase;
import org.cleanarchitecture.core.usecase.model.CreateUserInput;
import org.cleanarchitecture.core.usecase.model.UserOutput;
import org.cleanarchitecture.infrastructure.rpc.api.UserService;
import org.cleanarchitecture.infrastructure.rpc.api.model.Response;
import org.cleanarchitecture.infrastructure.rpc.api.model.UserCreateRequest;
import org.cleanarchitecture.infrastructure.rpc.api.model.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author : wangqijia create at:  2024/12/5  5:27 PM
 */
@DubboService
public class UserServiceProvider implements UserService {

    private final CreateUserUseCase createUserUseCase;

    @Autowired
    public UserServiceProvider(CreateUserUseCase createUserUseCase) {
        this.createUserUseCase = createUserUseCase;
    }

    @Override
    public Response<UserResponse> create(UserCreateRequest request) {
        UserOutput output = createUserUseCase.create(
            new CreateUserInput(request.getName(), request.getAge()));
        UserResponse userResponse = new UserResponse(output.getId(), output.getName(),
            output.getAge());
        return Response.success(userResponse);

    }
}

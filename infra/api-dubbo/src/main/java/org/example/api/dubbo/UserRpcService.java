package org.example.api.dubbo;

import org.apache.dubbo.config.annotation.DubboService;
import org.example.client.UserService;
import org.example.client.model.Response;
import org.example.client.model.UserCreateRequest;
import org.example.client.model.UserResponse;
import org.example.core.usecase.CreateUserUseCase;
import org.example.core.usecase.model.CreateUserInput;
import org.example.core.usecase.model.UserOutput;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author : wangqijia create at:  2024/12/5  5:27 PM
 */
@DubboService
public class UserRpcService implements UserService {

    private final CreateUserUseCase createUserUseCase;

    @Autowired
    public UserRpcService(CreateUserUseCase createUserUseCase) {
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

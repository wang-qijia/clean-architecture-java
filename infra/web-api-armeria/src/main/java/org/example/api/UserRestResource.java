package org.example.api;

import com.linecorp.armeria.common.HttpResponse;
import com.linecorp.armeria.server.annotation.ExceptionHandler;
import com.linecorp.armeria.server.annotation.Get;
import com.linecorp.armeria.server.annotation.Param;
import com.linecorp.armeria.server.annotation.PathPrefix;
import com.linecorp.armeria.server.annotation.Post;
import com.linecorp.armeria.server.annotation.RequestObject;
import org.example.api.exception.handler.GlobalExceptionHandler;
import org.example.api.model.UserCreateRequest;
import org.example.api.model.UserResponse;
import org.example.api.model.UserSearchRequest;
import org.example.api.model.UserSearchResponse;
import org.example.core.usecase.CreateUserUseCase;
import org.example.core.usecase.FindUserByNameUseCase;
import org.example.core.usecase.SearchUserUseCase;
import org.example.core.usecase.model.SearchUserOutput;
import org.example.core.usecase.model.UserOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;


@Component
@Validated
@ExceptionHandler(GlobalExceptionHandler.class)
@PathPrefix("/users")
public class UserRestResource {

    @Autowired
    private FindUserByNameUseCase findUserByNameUseCase;

    @Autowired
    private CreateUserUseCase createUserUseCase;

    @Autowired
    private SearchUserUseCase searchUserUseCase;


    @Get("/{name}")
    public HttpResponse findByName(@Param String name) {
        UserOutput result = findUserByNameUseCase.find(name);
        return HttpResponse.ofJson(UserResponse.toResponse(result));
    }


    @Post("/")
    public HttpResponse create(@RequestObject UserCreateRequest request) {
        UserOutput result = createUserUseCase.create(request.toInput());
        return HttpResponse.ofJson(UserResponse.toResponse(result));
    }


    @Get("/")
    public HttpResponse search(UserSearchRequest request) {
        SearchUserOutput UserOutput = searchUserUseCase.search(request.toInput());
        return HttpResponse.ofJson(UserSearchResponse.toResponse(UserOutput));
    }


}

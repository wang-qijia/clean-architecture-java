package org.cleanarchitecture.infrastructure.http;

import com.linecorp.armeria.common.HttpResponse;
import com.linecorp.armeria.server.annotation.ExceptionHandler;
import com.linecorp.armeria.server.annotation.Get;
import com.linecorp.armeria.server.annotation.Param;
import com.linecorp.armeria.server.annotation.PathPrefix;
import com.linecorp.armeria.server.annotation.Post;
import com.linecorp.armeria.server.annotation.RequestObject;
import org.cleanarchitecture.infrastructure.http.exception.handler.GlobalExceptionHandler;
import org.cleanarchitecture.infrastructure.http.model.UserCreateRequest;
import org.cleanarchitecture.infrastructure.http.model.UserResponse;
import org.cleanarchitecture.infrastructure.http.model.UserSearchRequest;
import org.cleanarchitecture.infrastructure.http.model.UserSearchResponse;
import org.cleanarchitecture.core.usecase.CreateUserUseCase;
import org.cleanarchitecture.core.usecase.FindUserByNameUseCase;
import org.cleanarchitecture.core.usecase.SearchUserUseCase;
import org.cleanarchitecture.core.usecase.model.SearchUserOutput;
import org.cleanarchitecture.core.usecase.model.UserOutput;
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

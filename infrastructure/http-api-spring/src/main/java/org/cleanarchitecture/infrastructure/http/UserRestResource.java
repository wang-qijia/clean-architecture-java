package org.cleanarchitecture.infrastructure.http;

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
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/users")
@Validated
public class UserRestResource {

    @Autowired
    private FindUserByNameUseCase findUserByNameUseCase;

    @Autowired
    private CreateUserUseCase createUserUseCase;

    @Autowired
    private SearchUserUseCase searchUserUseCase;

    @GetMapping("/{name}")
    public UserResponse findByName(@PathVariable String name) {
        UserOutput result = findUserByNameUseCase.find(name);
        return UserResponse.toResponse(result);
    }


    @PostMapping("")
    public UserResponse create(@RequestBody UserCreateRequest request) {
        UserOutput result = createUserUseCase.create(request.toInput());
        return UserResponse.toResponse(result);
    }


    @GetMapping("")
    public UserSearchResponse search(UserSearchRequest request) {
        SearchUserOutput UserOutput = searchUserUseCase.search(request.toInput());
        return UserSearchResponse.toResponse(UserOutput);
    }


}

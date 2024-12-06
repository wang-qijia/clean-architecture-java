package org.example.api;

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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/users")
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


    @PostMapping("/")
    public UserResponse create(@RequestBody UserCreateRequest request) {
        UserOutput result = createUserUseCase.create(request.toInput());
        return UserResponse.toResponse(result);
    }


    @GetMapping("/")
    public UserSearchResponse search(UserSearchRequest request) {
        SearchUserOutput UserOutput = searchUserUseCase.search(request.toInput());
        return UserSearchResponse.toResponse(UserOutput);
    }


}

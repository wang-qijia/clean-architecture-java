package org.example.core.usecase;

import java.util.ArrayList;
import java.util.List;
import org.example.core.entity.User;
import org.example.core.usecase.model.Page;
import org.example.core.usecase.model.SearchUserInput;
import org.example.core.usecase.model.SearchUserOutput;
import org.example.core.usecase.model.UserOutput;
import org.example.core.usecase.repository.UserRepository;

public class SearchUserUseCase {

    private final UserRepository repository;

    public SearchUserUseCase(UserRepository repository) {
        this.repository = repository;
    }


    public SearchUserOutput search(SearchUserInput input) {
        Page<User> usersPerPage = repository.findAll(input);
        if (usersPerPage.isEmpty()) {
            return SearchUserOutput.emptyResult();
        }

        List<UserOutput> userOutputs = new ArrayList<>();
        for (User User : usersPerPage.getList()) {
            userOutputs.add(UserOutput.from(User));
        }
        return SearchUserOutput.create(userOutputs, usersPerPage.getTotal(),
            usersPerPage.isHasNext());
    }


}

package org.cleanarchitecture.core.usecase;

import java.util.ArrayList;
import java.util.List;
import org.cleanarchitecture.core.entity.User;
import org.cleanarchitecture.core.usecase.model.Page;
import org.cleanarchitecture.core.usecase.model.SearchUserInput;
import org.cleanarchitecture.core.usecase.model.SearchUserOutput;
import org.cleanarchitecture.core.usecase.model.UserOutput;
import org.cleanarchitecture.core.usecase.repository.UserRepository;

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

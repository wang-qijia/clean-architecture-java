package org.cleanarchitecture.core.usecase;

import java.util.Optional;
import org.cleanarchitecture.core.entity.User;
import org.cleanarchitecture.core.usecase.exception.UseCaseErrorCode;
import org.cleanarchitecture.core.usecase.exception.UseCaseException;
import org.cleanarchitecture.core.usecase.model.UserOutput;
import org.cleanarchitecture.core.usecase.repository.UserRepository;

public class FindUserByNameUseCase {

    private final UserRepository repository;

    public FindUserByNameUseCase(UserRepository repository) {
        this.repository = repository;
    }

    public UserOutput find(String name) {
        Optional<User> userOptional = repository.findByName(name);
        User user = userOptional.orElseThrow(
            () -> new UseCaseException(UseCaseErrorCode.User_NOT_FOUND));
        return UserOutput.from(user);
    }


}

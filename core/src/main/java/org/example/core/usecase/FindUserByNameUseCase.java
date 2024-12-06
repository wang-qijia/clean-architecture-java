package org.example.core.usecase;

import java.util.Optional;
import org.example.core.entity.User;
import org.example.core.exception.UseCaseErrorCode;
import org.example.core.exception.UseCaseException;
import org.example.core.usecase.model.UserOutput;
import org.example.core.usecase.repository.UserRepository;

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

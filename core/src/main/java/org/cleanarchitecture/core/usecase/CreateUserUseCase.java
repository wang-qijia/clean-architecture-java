package org.cleanarchitecture.core.usecase;

import java.util.Optional;
import org.cleanarchitecture.core.entity.User;
import org.cleanarchitecture.core.usecase.exception.UseCaseErrorCode;
import org.cleanarchitecture.core.usecase.exception.UseCaseException;
import org.cleanarchitecture.core.usecase.model.CreateUserInput;
import org.cleanarchitecture.core.usecase.model.UserOutput;
import org.cleanarchitecture.core.usecase.repository.UserRepository;

public class CreateUserUseCase {

    private final UserRepository repository;

    public CreateUserUseCase(UserRepository repository) {
        this.repository = repository;
    }

    public UserOutput create(CreateUserInput input) {
        Optional<User> existingUser = repository.findByName(input.getName());
        if (existingUser.isPresent()) {
            throw new UseCaseException(UseCaseErrorCode.User_NOT_FOUND);
        }

        User user = User.create(input.getName(), input.getAge());
        repository.save(user);
        return UserOutput.from(user);
    }


}

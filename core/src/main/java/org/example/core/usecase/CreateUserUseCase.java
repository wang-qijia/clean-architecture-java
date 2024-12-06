package org.example.core.usecase;

import java.util.Optional;
import org.example.core.entity.User;
import org.example.core.exception.UseCaseErrorCode;
import org.example.core.exception.UseCaseException;
import org.example.core.usecase.model.CreateUserInput;
import org.example.core.usecase.model.UserOutput;
import org.example.core.usecase.repository.UserRepository;

public class CreateUserUseCase {

    private final UserRepository repository;

    public CreateUserUseCase(UserRepository repository) {
        this.repository = repository;
    }

    public UserOutput create(CreateUserInput input) {
        Optional<User> userOptional = repository.findByName(input.getName());
        userOptional.ifPresent((u) -> new UseCaseException(UseCaseErrorCode.User_NOT_FOUND));

        User user = User.create(input.getName(), input.getAge());
        repository.save(user);
        return UserOutput.from(user);
    }


}

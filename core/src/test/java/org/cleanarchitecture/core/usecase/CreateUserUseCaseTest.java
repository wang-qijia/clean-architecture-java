package org.cleanarchitecture.core.usecase;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Optional;

import org.cleanarchitecture.core.entity.User;
import org.cleanarchitecture.core.usecase.exception.UseCaseErrorCode;
import org.cleanarchitecture.core.usecase.exception.UseCaseException;
import org.cleanarchitecture.core.usecase.model.CreateUserInput;
import org.cleanarchitecture.core.usecase.model.UserOutput;
import org.cleanarchitecture.core.usecase.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class CreateUserUseCaseTest {

    @Mock
    private UserRepository repository;

    @InjectMocks
    private CreateUserUseCase createUserUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void createUser_Success() {
        // Arrange
        String name = "Test User";
        int age = 25;
        CreateUserInput input = new CreateUserInput(name, age);

        when(repository.findByName(name)).thenReturn(Optional.empty());

        // Act
        UserOutput output = createUserUseCase.create(input);

        // Assert
        assertNotNull(output);
        assertEquals(name, output.getName());
        assertEquals(age, output.getAge());
        verify(repository, times(1)).save(any(User.class));
    }

    @Test
    void createUser_UserAlreadyExists() {
        // Arrange
        String name = "Existing User";
        int age = 30;
        CreateUserInput input = new CreateUserInput(name, age);
        User existingUser = User.create(name, age);

        when(repository.findByName(name)).thenReturn(Optional.of(existingUser));

        // Act & Assert
        UseCaseException exception = assertThrows(UseCaseException.class, () -> createUserUseCase.create(input));
        assertEquals(UseCaseErrorCode.User_NOT_FOUND, exception.getErrorCode());
        verify(repository, never()).save(any(User.class));
    }
}

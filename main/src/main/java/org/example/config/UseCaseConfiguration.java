package org.example.config;

import org.example.core.usecase.CreateUserUseCase;
import org.example.core.usecase.FindUserByNameUseCase;
import org.example.core.usecase.SearchUserUseCase;
import org.example.core.usecase.repository.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author : wangqijia create at:  2024/12/5  2:20 PM
 */
@Configuration
public class UseCaseConfiguration {

    @Bean
    FindUserByNameUseCase findUserByNameUseCase(UserRepository UserRepository) {
        return new FindUserByNameUseCase(UserRepository);
    }

    @Bean
    CreateUserUseCase createUserUseCase(UserRepository UserRepository) {
        return new CreateUserUseCase(UserRepository);
    }

    @Bean
    SearchUserUseCase searchUserUseCase(UserRepository UserRepository) {
        return new SearchUserUseCase(UserRepository);
    }

}

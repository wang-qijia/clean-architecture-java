package org.cleanarchitecture.main.config;

import org.cleanarchitecture.core.usecase.CreateUserUseCase;
import org.cleanarchitecture.core.usecase.FindUserByNameUseCase;
import org.cleanarchitecture.core.usecase.SearchUserUseCase;
import org.cleanarchitecture.core.usecase.repository.UserRepository;
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

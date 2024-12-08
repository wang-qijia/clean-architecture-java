package org.cleanarchitecture.main.config;

import org.cleanarchitecture.core.usecase.repository.UserRepository;
import org.cleanarchitecture.infrastructure.store.InMemoryUserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author : wangqijia create at:  2024/12/5  2:22 PM
 */
@Configuration
public class StoreConfiguration {

    @Bean
    UserRepository UserRepository() {
        return new InMemoryUserRepository();
    }
}

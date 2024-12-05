package org.example.config;

import org.example.core.usecase.repository.StudentRepository;
import org.example.store.InMemoryStudentRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author : wangqijia create at:  2024/12/5  2:22 PM
 */
@Configuration
public class StoreConfiguration {


    @Bean
    StudentRepository studentRepository() {
        return new InMemoryStudentRepository();
    }
}

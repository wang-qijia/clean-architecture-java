package org.example.config;

import org.example.core.usecase.CreateStudentUseCase;
import org.example.core.usecase.FindStudentByNameUseCase;
import org.example.core.usecase.SearchStudentUseCase;
import org.example.core.usecase.repository.StudentRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author : wangqijia create at:  2024/12/5  2:20 PM
 */
@Configuration
public class UseCaseConfiguration {

    @Bean
    FindStudentByNameUseCase findStudentByNameUseCase(StudentRepository studentRepository) {
        return new FindStudentByNameUseCase(studentRepository);
    }

    @Bean
    CreateStudentUseCase createStudentUseCase(StudentRepository studentRepository) {
        return new CreateStudentUseCase(studentRepository);
    }

    @Bean
    SearchStudentUseCase searchStudentUseCase(StudentRepository studentRepository) {
        return new SearchStudentUseCase(studentRepository);
    }

}

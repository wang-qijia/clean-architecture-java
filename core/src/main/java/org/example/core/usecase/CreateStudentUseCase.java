package org.example.core.usecase;

import org.example.core.domain.Student;
import org.example.core.exception.UseCaseErrorCode;
import org.example.core.exception.UseCaseException;
import org.example.core.usecase.model.CreateStudentInput;
import org.example.core.usecase.model.CreateStudentOutput;
import org.example.core.usecase.repository.StudentRepository;

public class CreateStudentUseCase {
    private final StudentRepository repository;

    public CreateStudentUseCase(StudentRepository repository) {
        this.repository = repository;
    }

    public CreateStudentOutput create(CreateStudentInput input) {
        Student student = repository.findByName(input.getName());
        if (student != null) {
            throw new UseCaseException(UseCaseErrorCode.STUDENT_ALREADY_EXISTS);
        }

        student = Student.create(input.getName(), input.getAge());
        repository.save(student);
        return CreateStudentOutput.from(student);
    }


}

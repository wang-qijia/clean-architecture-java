package org.example.core.usecase;

import org.example.core.domain.Student;
import org.example.core.exception.UseCaseErrorCode;
import org.example.core.exception.UseCaseException;
import org.example.core.usecase.model.FindStudentByNameOutput;
import org.example.core.usecase.repository.StudentRepository;

public class FindStudentByNameUseCase  {

  private final StudentRepository repository;

  public FindStudentByNameUseCase(StudentRepository repository) {
    this.repository = repository;
  }

  public FindStudentByNameOutput find(String name) {
    Student student = repository.findByName(name);
    if (student == null) {
      throw new UseCaseException(UseCaseErrorCode.STUDENT_NOT_FOUND);
    }

    return FindStudentByNameOutput.from(student);
  }




}

package org.example.core.usecase;

import java.util.ArrayList;
import java.util.List;
import org.example.core.domain.Student;
import org.example.core.usecase.model.Page;
import org.example.core.usecase.model.SearchStudentInput;
import org.example.core.usecase.model.SearchStudentOutput;
import org.example.core.usecase.model.StudentData;
import org.example.core.usecase.repository.StudentRepository;

public class SearchStudentUseCase {

  private final StudentRepository repository;

  public SearchStudentUseCase(StudentRepository repository) {
    this.repository = repository;
  }


  public SearchStudentOutput search(SearchStudentInput input) {
    Page<Student> studentsPerPage = repository.findAll(input);
    if (studentsPerPage.isEmpty()) {
      return SearchStudentOutput.emptyResult();
    }

    List<StudentData> studentResult = new ArrayList<>();
    for (Student student : studentsPerPage.getList()) {
      studentResult.add(StudentData.from(student));
    }
    return SearchStudentOutput.create(studentResult, studentsPerPage.getTotal(),
        studentsPerPage.isHasNext());
  }







}

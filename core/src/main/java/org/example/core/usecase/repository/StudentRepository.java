package org.example.core.usecase.repository;


import org.example.core.domain.Student;
import org.example.core.usecase.model.Page;
import org.example.core.usecase.model.SearchStudentInput;

public interface StudentRepository {

    Student findByName(String name);

    Page<Student> findAll(SearchStudentInput query);

    Student save(Student student);


}

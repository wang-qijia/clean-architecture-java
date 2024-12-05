package org.example.api;

import org.example.api.model.StudentCreateRequest;
import org.example.api.model.StudentCreateResponse;
import org.example.api.model.StudentFindResponse;
import org.example.api.model.StudentSearchRequest;
import org.example.api.model.StudentSearchResponse;
import org.example.core.usecase.CreateStudentUseCase;
import org.example.core.usecase.FindStudentByNameUseCase;
import org.example.core.usecase.SearchStudentUseCase;
import org.example.core.usecase.model.CreateStudentOutput;
import org.example.core.usecase.model.FindStudentByNameOutput;
import org.example.core.usecase.model.SearchStudentOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private FindStudentByNameUseCase findStudentByNameUseCase;

    @Autowired
    private CreateStudentUseCase createStudentUseCase;

    @Autowired
    private SearchStudentUseCase searchStudentUseCase;


    @GetMapping("/{name}")
    public StudentFindResponse findByName(@PathVariable String name) {
        FindStudentByNameOutput result = findStudentByNameUseCase.find(name);
        return StudentFindResponse.toResponse(result);
    }


    @PostMapping("/")
    public StudentCreateResponse create(@RequestBody StudentCreateRequest request) {
        CreateStudentOutput result = createStudentUseCase.create(request.toInput());
        return StudentCreateResponse.toResponse(result);
    }


    @GetMapping("/")
    public StudentSearchResponse search(StudentSearchRequest request) {
        SearchStudentOutput studentOutput = searchStudentUseCase.search(request.toInput());
        return StudentSearchResponse.toResponse(studentOutput);
    }


}

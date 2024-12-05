package org.example.api;

import com.linecorp.armeria.common.HttpResponse;
import com.linecorp.armeria.server.annotation.ExceptionHandler;
import com.linecorp.armeria.server.annotation.Get;
import com.linecorp.armeria.server.annotation.Param;
import com.linecorp.armeria.server.annotation.PathPrefix;
import com.linecorp.armeria.server.annotation.Post;
import com.linecorp.armeria.server.annotation.RequestObject;
import org.example.api.exception.handler.GlobalExceptionHandler;
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
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;


@Component
@Validated
@ExceptionHandler(GlobalExceptionHandler.class)
@PathPrefix("/students")
public class StudentController {

    @Autowired
    private FindStudentByNameUseCase findStudentByNameUseCase;

    @Autowired
    private CreateStudentUseCase createStudentUseCase;

    @Autowired
    private SearchStudentUseCase searchStudentUseCase;


    @Get("/{name}")
    public HttpResponse findByName(@Param String name) {
        FindStudentByNameOutput result = findStudentByNameUseCase.find(name);
        return HttpResponse.ofJson(StudentFindResponse.toResponse(result));
    }


    @Post("/")
    public HttpResponse create(@RequestObject StudentCreateRequest request) {
        CreateStudentOutput result = createStudentUseCase.create(request.toInput());
        return HttpResponse.ofJson(StudentCreateResponse.toResponse(result));
    }


    @Get("/")
    public HttpResponse search(StudentSearchRequest request) {
        SearchStudentOutput studentOutput = searchStudentUseCase.search(request.toInput());
        return HttpResponse.ofJson(StudentSearchResponse.toResponse(studentOutput));
    }


}

package org.example.api.dubbo;

import org.apache.dubbo.config.annotation.DubboService;
import org.example.client.StudentService;
import org.example.client.model.Response;
import org.example.client.model.StudentCreateRequest;
import org.example.client.model.StudentCreateResponse;
import org.example.core.usecase.CreateStudentUseCase;
import org.example.core.usecase.model.CreateStudentInput;
import org.example.core.usecase.model.CreateStudentOutput;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author : wangqijia create at:  2024/12/5  5:27 PM
 */
@DubboService
public class DubboStudentService implements StudentService {

    @Autowired
    private CreateStudentUseCase createStudentUseCase;

    @Override
    public Response<StudentCreateResponse> create(StudentCreateRequest request) {
        CreateStudentOutput output = createStudentUseCase.create(
            new CreateStudentInput(request.getName(), request.getAge()));
        return new Response<>("0", "",
            new StudentCreateResponse(output.getId(), output.getName(), output.getAge()));

    }
}

package org.example.client;

import org.example.client.model.Response;
import org.example.client.model.StudentCreateRequest;
import org.example.client.model.StudentCreateResponse;

/**
 * @author : wangqijia create at:  2024/12/5  5:29 PM
 */
public interface StudentService {


    Response<StudentCreateResponse> create(StudentCreateRequest request);

}

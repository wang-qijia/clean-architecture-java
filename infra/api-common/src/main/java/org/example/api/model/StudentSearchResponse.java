package org.example.api.model;

import java.util.List;
import java.util.stream.Collectors;
import org.example.core.usecase.model.SearchStudentOutput;

/**
 * @author : wangqijia create at:  2024/12/5  11:21 AM
 */
public class StudentSearchResponse {

    private List<StudentJson> students;
    private int total;
    private boolean hasNext;

    public StudentSearchResponse() {
    }

    public StudentSearchResponse(List<StudentJson> students, int total, boolean hasNext) {
        this.students = students;
        this.total = total;
        this.hasNext = hasNext;
    }

    public static StudentSearchResponse toResponse(SearchStudentOutput output) {
        List<StudentJson> studentJsons = output.getStudents().stream()
            .map(StudentJson::toJson)
            .collect(Collectors.toList());
        return new StudentSearchResponse(studentJsons, output.getTotal(), output.getHasNext());

    }

    public List<StudentJson> getStudents() {
        return students;
    }

    public void setStudents(List<StudentJson> students) {
        this.students = students;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public boolean isHasNext() {
        return hasNext;
    }

    public void setHasNext(boolean hasNext) {
        this.hasNext = hasNext;
    }
}

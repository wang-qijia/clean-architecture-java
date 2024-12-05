package org.example.core.usecase.model;

import java.util.Collections;
import java.util.List;

/**
 * @author : wangqijia create at:  2024/12/5  11:29 AM
 */
public class SearchStudentOutput {
    private List<StudentData> students;
    private int total;
    private boolean hasNext;

    public static SearchStudentOutput emptyResult() {
        SearchStudentOutput emptyResult = new SearchStudentOutput();
        emptyResult.setStudents(Collections.emptyList());
        return emptyResult;
    }

    public static SearchStudentOutput create(List<StudentData> students, int total,boolean hasNext) {
        SearchStudentOutput result = new SearchStudentOutput();
        result.setStudents(students);
        result.setTotal(total);
        result.setHasNext(hasNext);
        return result;
    }

    public List<StudentData> getStudents() {
        return students;
    }

    public void setStudents(List<StudentData> students) {
        this.students = students;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public boolean getHasNext() {
        return hasNext;
    }

    public void setHasNext(boolean hasNext) {
        this.hasNext = hasNext;
    }
}
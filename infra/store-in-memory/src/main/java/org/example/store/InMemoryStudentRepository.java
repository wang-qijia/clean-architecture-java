package org.example.store;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import org.example.core.domain.Student;
import org.example.core.usecase.model.Page;
import org.example.core.usecase.model.SearchStudentInput;
import org.example.core.usecase.repository.StudentRepository;

/**
 * @author : wangqijia create at:  2024/12/5  11:41 AM
 */
public class InMemoryStudentRepository implements StudentRepository {

    private final ConcurrentMap<String, Student> store = new ConcurrentHashMap<>();

    @Override
    public Student findByName(String name) {
        return store.get(name);
    }

    @Override
    public Page<Student> findAll(SearchStudentInput query) {
        List<Student> filteredList = new ArrayList<>();
        store.forEach((name, student)->{
            if (name.contains(query.getName())) {
                filteredList.add(student);
            }
        });

        int fromIndex=query.getPage() * query.getSize();
        int endIndex = fromIndex + query.getSize();
        List<Student> students = filteredList.subList(fromIndex, endIndex);
        return new Page<>(students, query.getPage(), query.getSize(), filteredList.size());
    }

    @Override
    public Student save(Student student) {
        student.setId(UUID.randomUUID().toString());
        store.put(student.getName(), student);
        return student;
    }
}

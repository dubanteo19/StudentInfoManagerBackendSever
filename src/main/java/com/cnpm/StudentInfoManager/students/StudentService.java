package com.cnpm.StudentInfoManager.students;

import java.util.List;

public interface StudentService {
    Student save(Student student);

    Student findById(Long id);

    boolean deleteById(Long id);

    boolean updateById(Long id, Student student);

    List<Student> findAll();

}

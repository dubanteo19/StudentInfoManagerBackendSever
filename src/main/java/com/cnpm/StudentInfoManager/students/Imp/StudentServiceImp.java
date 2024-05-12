package com.cnpm.StudentInfoManager.students.Imp;

import com.cnpm.StudentInfoManager.students.Student;
import com.cnpm.StudentInfoManager.students.StudentRepository;
import com.cnpm.StudentInfoManager.students.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImp implements StudentService {
    StudentRepository studentRepository;

    public StudentServiceImp(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Student save(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student findById(Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    @Override
    public boolean deleteById(Long id) {
        studentRepository.deleteById(id);
        return true;
    }

    @Override
    public boolean updateById(Long id, Student student) {
        var oldStudent = studentRepository.findById(id);
        if (oldStudent.isEmpty()) {
            return false;
        }
        student.setStudentId(id);
        student.setAddress(student.getAddress());
        student.setGender(student.getGender());
        student.setAvatar(oldStudent.get().getAvatar());
        student.setName(student.getName());
        student.setPhone(student.getPhone());
        student.setFaculty(student.getFaculty());
        student.setDob(student.getDob());
        studentRepository.save(student);
        return true;
    }


    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }
}

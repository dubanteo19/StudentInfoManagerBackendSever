package com.cnpm.StudentInfoManager.students;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/students")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping()
    public List<Student> getStudents() {
        return studentService.findAll();
    }

    @PostMapping()
    public ResponseEntity<String> addStudent(@RequestBody Student student) {
        studentService.save(student);
        return new ResponseEntity<String>("Student added successfully", HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateStudent(@PathVariable Long id, @RequestBody Student student) {
        studentService.updateById(id, student);
        return new ResponseEntity<String>("Student update successfully", HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Long id) {
        if (studentService.findById(id) == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return ResponseEntity.ok(studentService.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudentById(@PathVariable Long id) {
        if (studentService.findById(id) == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        studentService.deleteById(id);
        return ResponseEntity.ok("Delete student successfully");
    }
}

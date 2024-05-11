package com.cnpm.StudentInfoManager.students;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;

@Data
@Entity
@Table(name = "students")
public class Student{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long studentId;
    private String name;
    private String email;
    private String phone;
    private String address;
    private Date dob;
    private String gender;
    private String avatar;
    private String faculty;

}

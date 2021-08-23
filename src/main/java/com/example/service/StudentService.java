package com.example.service;

import com.example.entity.Student;

import java.util.List;

public interface StudentService {
    void add(Student student);
    void delete(String id);
    void change(Student student);
    List<Student> queryAll();
    Student queryOne(String id);
}

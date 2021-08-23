package com.example.dao;

import com.example.entity.Student;

import java.util.List;

public interface StudentFDao extends BaseFDao<Student,String>{
   void delete(String id);
   void update(Student student);
   List<Student> selectAll();
}

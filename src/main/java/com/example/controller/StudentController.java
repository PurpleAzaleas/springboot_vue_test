package com.example.controller;

import com.example.entity.Student;
import com.example.service.StudentService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("student")
@CrossOrigin
public class StudentController {
    @Resource
    private StudentService studentService;

    @RequestMapping("add")
    public String add(@RequestBody Student student){
        studentService.add(student);
        return null;
    }

    @RequestMapping("delete")
    public String delete(String id){
        studentService.delete(id);
        return null;
    }

    @RequestMapping("change")
    public String change(@RequestBody Student student){
        studentService.change(student);
        return null;
    }

    @RequestMapping("queryAll")
    public List<Student> queryAll(){
        return studentService.queryAll();
    }

    @RequestMapping("queryOne")
    public Student queryOne(String id){
        return studentService.queryOne(id);
    }
}

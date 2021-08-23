package com.example.service;

import com.example.dao.StudentFDao;
import com.example.entity.Student;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class StudentServiceImpl implements StudentService{
    @Resource
    private StudentFDao studentFDao;

    @Override
    public void add(Student student) {
        student.setId(UUID.randomUUID().toString());
        studentFDao.insert(student);
    }

    @Override
    public void delete(String id) {
        studentFDao.delete(id);
    }

    @Override
    public void change(Student student) {
        studentFDao.update(student);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Student> queryAll() {
        List<Student> list = studentFDao.selectAll();
        return list;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Student queryOne(String id) {
        Student student = studentFDao.selectOne(id);
        return student;
    }
}

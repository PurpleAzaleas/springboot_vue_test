package com.example.service;

import com.example.dao.UserFDao;
import com.example.entity.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
@Transactional
public class UserServiceImpl implements UserService{
    @Resource
    private UserFDao userFDao;

    @Override
    public void add(User user) {
            userFDao.insert(user);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public User queryOne(String username) {
        User user = userFDao.selectOne(username);
        return user;
    }
}

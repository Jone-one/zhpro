package com.lyi.zhpro.sys.service.impl;

import com.lyi.zhpro.sys.dao.UserDao;
import com.lyi.zhpro.sys.service.UserService;
import com.lyi.zhpro.sys.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;
    @Override
    public UserVo getUserByAccount(String account) {
        return userDao.getUserByAccount(account);
    }
}

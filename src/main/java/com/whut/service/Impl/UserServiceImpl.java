package com.whut.service.Impl;

import com.whut.dao.UserDao;
import com.whut.domain.User;
import com.whut.service.UserService;

/**
 * Created by WH on 2017/6/21.
 */
public class UserServiceImpl implements UserService {
    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public boolean userLogin(User user) {
        User aUser=userDao.queryUser(user);
        if (aUser!=null)
            return true;
        else
        return false;
    }
}

package cn.takeout.service.impl;

import cn.takeout.dao.IUserDao;
import cn.takeout.domain.User;
import cn.takeout.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements IUserService {
    @Autowired
    IUserDao userDao;
    @Override
    public void saveUser(String openId) {
        userDao.saveUser(openId);
    }

    @Override
    public User checkUser(String openId) {
        User user = userDao.checkUser(openId);
        return user;
    }
}

package cn.takeout.service;

import cn.takeout.domain.User;

public interface IUserService {
    void saveUser(String openid);
    User checkUser(String openid);
}

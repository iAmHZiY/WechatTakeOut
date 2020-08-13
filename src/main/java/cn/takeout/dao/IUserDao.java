package cn.takeout.dao;

import cn.takeout.domain.User;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserDao {
    void saveUser(String openId);
    User checkUser(String openId);

}

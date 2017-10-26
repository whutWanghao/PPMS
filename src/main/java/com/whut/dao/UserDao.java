package com.whut.dao;
import com.whut.domain.User;
/**
 * Created by WH on 2017/6/21.
 */
public interface UserDao {
    public void add();
    public User queryUser(User user);
}

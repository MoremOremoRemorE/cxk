package cxk.cxk.service.impl;

import cxk.cxk.mapper.UserMapper;
import cxk.cxk.model.User;
import cxk.cxk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User selectUserCountByName(String username) {
        return userMapper.selectUserCountByName(username);
    }

    @Override
    public int resuserpasswordByUserName(String resusername) {
        return userMapper.resuserpasswordByUserName(resusername);
    }

    @Override
    public int regiterByName(String username) {
        return userMapper.regiterByName(username);
    }

    @Override
    public void addUser(User user) {
        userMapper.addUser(user);
    }
}

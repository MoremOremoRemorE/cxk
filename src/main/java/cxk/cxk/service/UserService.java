package cxk.cxk.service;

import cxk.cxk.model.User;

public interface UserService {
    User selectUserCountByName(String username);

    int resuserpasswordByUserName(String resusername);

    int regiterByName(String username);

    void addUser(User user);
}

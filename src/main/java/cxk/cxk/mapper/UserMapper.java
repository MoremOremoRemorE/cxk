package cxk.cxk.mapper;

import cxk.cxk.model.User;

public interface UserMapper {
    int deleteByPrimaryKey(Integer userid);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer userid);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    User selectUserCountByName(String username);

    int resuserpasswordByUserName(String resusername);

    int regiterByName(String username);

    void addUser(User user);
}
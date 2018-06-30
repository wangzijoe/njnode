package cn.njnode.system.dao;

import java.util.List;

import cn.njnode.beans.system.User;

public interface UserDao {

	void addUser(User user);

	void deleteUserById(String id);

	void updateUserById(User user);

	User queryUserById(String id);

	List<User> queryUserList(User user);

	List<String> queryRolesByUserName(String userName);

	List<String> queryPermisionByUserName(String userName);

}
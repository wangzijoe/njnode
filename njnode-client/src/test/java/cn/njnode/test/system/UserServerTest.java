package cn.njnode.test.system;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import cn.njnode.HandlerResult;
import cn.njnode.beans.system.User;
import cn.njnode.common.xml.XMLUtil;
import cn.njnode.system.server.UserServer;
import cn.njnode.system.sever.impl.UserServerImpl;

public class UserServerTest {
	
	UserServer us;
	
	@Before
	public void beforeTest() {
		us = new UserServerImpl();
	}

	@Test
	public void TestQueryUserById() {
		HandlerResult<User> result = us.queryUserById("123");
		System.out.println(XMLUtil.convertToXml(result.getResultObj()));
	}
	
	@Test
	public void TestqueryUserList() {
		User user = new User();
		user.setUsername("admin");
		HandlerResult<List<User>> result = us.queryUserList(user, 1, 10);
		System.out.println(result.getResultObj());
	}
	
	@Test
	public void TestQueryRolesByUserName() {
		HandlerResult<List<String>> result = us.queryRolesByUserName("admin");
		System.out.println(result.getResultObj());
	}
}

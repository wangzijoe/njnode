package cn.njnode.test.system;

import java.util.List;

import org.junit.Test;

import com.alibaba.fastjson.JSON;

import cn.njnode.HandlerResult;
import cn.njnode.beans.system.User;
import cn.njnode.common.exception.ExceptionUtil;
import cn.njnode.common.http.HttpUtil;
import cn.njnode.common.json.JsonUtils;

public class UserTest {

	@Test
	public void queryUserList() {
		try {
			User user = new User();
			user.setUsername("njnode");
			HandlerResult<List<User>> result = HttpUtil.postArray("http://localhost:8099/webService/system/userServer/queryUserList/1/5", user, User.class);
			String jsonString = JSON.toJSONString(result);
			String json = JsonUtils.formatJson(jsonString);
			System.out.println(json);
		} catch (Exception e) {
			ExceptionUtil.getStackTrace(e);
		}
	}
}

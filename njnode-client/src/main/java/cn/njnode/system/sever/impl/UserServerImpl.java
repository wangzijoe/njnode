package cn.njnode.system.sever.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;

import cn.njnode.Base;
import cn.njnode.HandlerConstants;
import cn.njnode.HandlerResult;
import cn.njnode.beans.system.User;
import cn.njnode.common.config.ConfigUtils;
import cn.njnode.common.http.HttpUtil;
import cn.njnode.system.server.UserServer;

@Service
public class UserServerImpl extends Base<UserServer> implements UserServer {

	private Logger log = LogManager.getLogger(getClass());

	private static final String WEBSERVICE_URL = ConfigUtils.getProperty("WEBSERVICE_URL", UserServer.class, "config.properties");
	
	@Override
	public HandlerResult<User> addUser(User user) {
		HandlerResult<User> result = HandlerResult.getHandlerResult();
		try {
			String url = WEBSERVICE_URL + this.buildPath("addUser");
			result = HttpUtil.post(url, user, User.class);
		} catch (Exception e) {
			log.error("", e);
			result.setResultCode(HandlerConstants.S_FAIL);
		}
		return result;
	}

	@Override
	public HandlerResult<String> deleteUserById(String id) {
		HandlerResult<String> result = HandlerResult.getHandlerResult();
		try {
			String url = WEBSERVICE_URL + this.buildPath("deleteUserById",id.toString());
			result = HttpUtil.get(url, String.class);
		}catch(Exception e) {
			log.error("", e);
			result.setResultCode(HandlerConstants.S_FAIL);
		}
		return result;
	}

	@Override
	public HandlerResult<String> updateUserById(User user) {
		HandlerResult<String> result = HandlerResult.getHandlerResult();
		try {
			String url = WEBSERVICE_URL + this.buildPath("updateUserById");
			result = HttpUtil.post(url, user, String.class);
		}catch (Exception e) {
			log.error("", e);
			result.setResultCode(HandlerConstants.S_FAIL);
		}
		return result;
	}

	@Override
	public HandlerResult<User> queryUserById(String id) {
		HandlerResult<User> result = HandlerResult.getHandlerResult();
		try {
			String url = WEBSERVICE_URL + this.buildPath("queryUserById", id.toString());
			result = HttpUtil.get(url, User.class);
		} catch (Exception e) {
			log.error("", e);
			result.setResultCode(HandlerConstants.S_FAIL);
		}
		return result;
	}

	@Override
	public HandlerResult<List<User>> queryUserList(User user, Integer pageNum, Integer pageSize) {
		HandlerResult<List<User>> result = HandlerResult.getHandlerResult();
		try {
			String url = WEBSERVICE_URL + this.buildPath("queryUserList", pageNum.toString(), pageSize.toString());
			result = HttpUtil.postArray(url, user, User.class);
		} catch (Exception e) {
			log.error("", e);
			result.setResultCode(HandlerConstants.S_FAIL);
		}
		return result;
	}

	@Override
	public HandlerResult<List<String>> queryRolesByUserName(String userName) {
		HandlerResult<List<String>> result = HandlerResult.getHandlerResult();
		try {
			String url = WEBSERVICE_URL + this.buildPath("queryRolesByUserName", userName);
			String tempRes = HttpUtil.get(url);
			// 将tempRes转换成JSONObject
			JSONObject jsonObject = (JSONObject) JSONObject.parse(tempRes);
			// 根据key值获取value值
			String roleStr = jsonObject.getString("resultObj");
			List<String> roleStrList = new ArrayList<>();
			StringTokenizer stk = new StringTokenizer(roleStr, ",");
			while (stk.hasMoreElements()) {
				String role = stk.nextToken();
				roleStrList.add(role);
			}
			result.setResultObj(roleStrList);
		} catch (Exception e) {
			log.error("", e);
			result.setResultCode(HandlerConstants.S_FAIL);
		}
		return result;
	}

	@Override
	public HandlerResult<List<String>> queryPermisionByUserName(String userName) {
		HandlerResult<List<String>> result = HandlerResult.getHandlerResult();
		try {
			String url = WEBSERVICE_URL + this.buildPath("queryPermisionByUserName", userName);
			String tempPermissionStr = HttpUtil.get(url);
			JSONObject jsonObject = (JSONObject) JSONObject.parse(tempPermissionStr);
			String permissionStr = jsonObject.getString("resultObj");
			List<String> permissionStrList = new ArrayList<>();
			StringTokenizer stk = new StringTokenizer(permissionStr, ",");
			while(stk.hasMoreElements()) {
				String permission = stk.nextToken();
				permissionStrList.add(permission);
			}
			result.setResultObj(permissionStrList);
		} catch (Exception e) {
			log.error("", e);
			result.setResultCode(HandlerConstants.S_FAIL);
		}
		return result;
	}

}

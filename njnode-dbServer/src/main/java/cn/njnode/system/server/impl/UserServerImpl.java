package cn.njnode.system.server.impl;

import cn.njnode.HandlerConstants;
import cn.njnode.HandlerResult;
import cn.njnode.beans.system.User;
import cn.njnode.system.dao.UserDao;
import cn.njnode.system.server.UserServer;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.util.Assert;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServerImpl implements UserServer {
	
	private Logger log = LogManager.getLogger(getClass());

	@Resource
	private UserDao UserDao;
	
	@Override
	public HandlerResult<User> addUser(User user) {
		HandlerResult<User> result = HandlerResult.getHandlerResult();
		try {
			Assert.notNull(user, "user");
			UserDao.addUser(user);
			result.setResultObj(user);
		} catch (Exception e) {
			log.error("UserServerImpl addUser fail", e);
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			result.setResultCode(HandlerConstants.S_FAIL);
		}
		return result;
	}

	@Override
	public HandlerResult<String> deleteUserById(String id) {
		HandlerResult<String> result = HandlerResult.getHandlerResult();
		try {
			Assert.notNull(id, "id");
			UserDao.deleteUserById(id);
		} catch (Exception e) {
			log.error("UserServerImpl deleteUserById fail", e);
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			result.setResultCode(HandlerConstants.S_FAIL);
		}
		return result;
	}

	@Override
	public HandlerResult<String> updateUserById(User user) {
		HandlerResult<String> result = HandlerResult.getHandlerResult();
		try {
			Assert.notNull(user, "user");
			UserDao.updateUserById(user);
		} catch (Exception e) {
			log.error("UserServerImpl updateUserById fail", e);
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			result.setResultCode(HandlerConstants.S_FAIL);
		}
		return result;
	}

	@Override
	public HandlerResult<User> queryUserById(String id) {
		HandlerResult<User> result = HandlerResult.getHandlerResult();
		try {
			Assert.notNull(id, "id");
			User user = UserDao.queryUserById(id);
			result.setResultObj(user);
		} catch (Exception e) {
			log.error("UserServerImpl queryUserById fail", e);
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			result.setResultCode(HandlerConstants.S_FAIL);
		}
		return result;
	}

	@Override
	public HandlerResult<List<User>> queryUserList(User user, Integer pageNum, Integer pageSize) {
		HandlerResult<List<User>> result = HandlerResult.getHandlerResult();
		try {
			Assert.notNull(user, "user");
			PageHelper.startPage(pageNum, pageSize);
			List<User> list = UserDao.queryUserList(user);
			result.setPageInfo(new PageInfo<>(list));
			result.setResultObj(list);
		} catch (Exception e) {
			log.error("UserServerImpl queryUserList fail", e);
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			result.setResultCode(HandlerConstants.S_FAIL);
		}
		return result;
	}

	@Override
	public HandlerResult<List<String>> queryRolesByUserName(String userName) {
		HandlerResult<List<String>> result = HandlerResult.getHandlerResult();
		try {
			Assert.notNull(userName, "userName");
			List<String> roles = UserDao.queryRolesByUserName(userName);
			result.setResultObj(roles);
		} catch (Exception e) {
			log.error("UserServerImpl queryRolesByUserName fail", e);
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			result.setResultCode(HandlerConstants.S_FAIL);
		}
		return result;
	}

	@Override
	public HandlerResult<List<String>> queryPermisionByUserName(String userName) {
		HandlerResult<List<String>> result = HandlerResult.getHandlerResult();
		try {
			Assert.notNull(userName, "userName");
			List<String> permisions = UserDao.queryPermisionByUserName(userName);
			result.setResultObj(permisions);
		} catch (Exception e) {
			log.error("UserServerImpl queryPermisionByUserName fail", e);
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			result.setResultCode(HandlerConstants.S_FAIL);
		}
		return result;
	}

}

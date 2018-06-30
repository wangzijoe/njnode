package cn.njnode.subscriber.server.impl;

import cn.njnode.HandlerConstants;
import cn.njnode.HandlerResult;
import cn.njnode.beans.subscriber.Friends;
import cn.njnode.subscriber.dao.FriendsDao;
import cn.njnode.subscriber.server.FriendsServer;
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
public class FriendsServerImpl implements FriendsServer {

	private Logger log = LogManager.getLogger(getClass());
	
	@Resource
	private FriendsDao FriendsDao;
	
	@Override
	public HandlerResult<Friends> addFriends(Friends friends) {
		HandlerResult<Friends> result = HandlerResult.getHandlerResult();
		try {
			Assert.notNull(friends, "friends");
			FriendsDao.addFriends(friends);
			result.setResultObj(friends);
		} catch (Exception e) {
			log.error("FriendsServerImpl addFriends fail", e);
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			result.setResultCode(HandlerConstants.S_FAIL);
		}
		return result;
	}

	@Override
	public HandlerResult<String> deleteFriendsById(Integer id) {
		HandlerResult<String> result = HandlerResult.getHandlerResult();
		try {
			Assert.notNull(id, "id");
			FriendsDao.deleteFriendsById(id);
		} catch (Exception e) {
			log.error("FriendsServerImpl deleteFriendsById fail", e);
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			result.setResultCode(HandlerConstants.S_FAIL);
		}
		return result;
	}

	@Override
	public HandlerResult<String> updateFriendsById(Friends friends) {
		HandlerResult<String> result = HandlerResult.getHandlerResult();
		try {
			Assert.notNull(friends, "friends");
			FriendsDao.updateFriendsById(friends);
		} catch (Exception e) {
			log.error("FriendsServerImpl updateFriendsById fail", e);
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			result.setResultCode(HandlerConstants.S_FAIL);
		}
		return result;
	}

	@Override
	public HandlerResult<Friends> queryFriendsById(Integer id) {
		HandlerResult<Friends> result = HandlerResult.getHandlerResult();
		try {
			Assert.notNull(id, "id");
			Friends friends = FriendsDao.queryFriendsById(id);
			result.setResultObj(friends);
		} catch (Exception e) {
			log.error("FriendsServerImpl queryFriendsById fail", e);
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			result.setResultCode(HandlerConstants.S_FAIL);
		}
		return result;
	}

	@Override
	public HandlerResult<List<Friends>> queryFriendsList(Friends friends, Integer pageNum, Integer pageSize) {
		HandlerResult<List<Friends>> result = HandlerResult.getHandlerResult();
		try {
			Assert.notNull(friends, "friends");
			PageHelper.startPage(pageNum, pageSize);
			List<Friends> list = FriendsDao.queryFriendsList(friends);
			result.setPageInfo(new PageInfo<>(list));
			result.setResultObj(list);
		} catch (Exception e) {
			log.error("FriendsServerImpl queryFriendsList fail", e);
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			result.setResultCode(HandlerConstants.S_FAIL);
		}
		return result;
	}

}

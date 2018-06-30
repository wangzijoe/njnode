package cn.njnode.subscriber.server.impl;

import cn.njnode.Base;
import cn.njnode.HandlerConstants;
import cn.njnode.HandlerResult;
import cn.njnode.beans.subscriber.Friends;
import cn.njnode.common.config.ConfigUtils;
import cn.njnode.common.http.HttpUtil;
import cn.njnode.subscriber.server.FriendsServer;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FriendsServerImpl extends Base<FriendsServer> implements FriendsServer {


    private Logger log = LogManager.getLogger(getClass());

    private static final String WEBSERVICE_URL = ConfigUtils.getProperty("WEBSERVICE_URL", FriendsServer.class, "config.properties");


    @Override
    public HandlerResult<Friends> addFriends(Friends friends) {
        HandlerResult<Friends> result = HandlerResult.getHandlerResult();
        try {
            String url = WEBSERVICE_URL + this.buildPath("addFriends");
            result = HttpUtil.post(url, friends, Friends.class);
        } catch (Exception e) {
            log.error("", e);
            result.setResultCode(HandlerConstants.S_FAIL);
        }
        return result;
    }

    @Override
    public HandlerResult<String> deleteFriendsById(Integer id) {
        HandlerResult<String> result = HandlerResult.getHandlerResult();
        try {
            String url = WEBSERVICE_URL + this.buildPath("deleteFriendsById",id.toString());
            result = HttpUtil.get(url, String.class);
        }catch(Exception e) {
            log.error("", e);
            result.setResultCode(HandlerConstants.S_FAIL);
        }
        return result;
    }

    @Override
    public HandlerResult<String> updateFriendsById(Friends friends) {
        HandlerResult<String> result = HandlerResult.getHandlerResult();
        try {
            String url = WEBSERVICE_URL + this.buildPath("updateFriendsById");
            result = HttpUtil.post(url, friends, String.class);
        }catch (Exception e) {
            log.error("", e);
            result.setResultCode(HandlerConstants.S_FAIL);
        }
        return result;
    }

    @Override
    public HandlerResult<Friends> queryFriendsById(Integer id) {
        HandlerResult<Friends> result = HandlerResult.getHandlerResult();
        try {
            String url = WEBSERVICE_URL + this.buildPath("queryFriendsById", id.toString());
            result = HttpUtil.get(url, Friends.class);
        } catch (Exception e) {
            log.error("", e);
            result.setResultCode(HandlerConstants.S_FAIL);
        }
        return result;
    }

    @Override
    public HandlerResult<List<Friends>> queryFriendsList(Friends friends, Integer pageNum, Integer pageSize) {
        HandlerResult<List<Friends>> result = HandlerResult.getHandlerResult();
        try {
            String url = WEBSERVICE_URL + this.buildPath("queryFriendsList"
                    , pageNum.toString(), pageSize.toString());
            result = HttpUtil.postArray(url, friends, Friends.class);
        } catch (Exception e) {
            log.error("", e);
            result.setResultCode(HandlerConstants.S_FAIL);
        }
        return result;
    }
}

package cn.njnode.subscriber.dao;

import java.util.List;

import cn.njnode.beans.subscriber.Friends;

public interface FriendsDao {
	
	void addFriends(Friends friends);

	void deleteFriendsById(Integer id);

	void updateFriendsById(Friends friends);

	Friends queryFriendsById(Integer id);
	
	List<Friends> queryFriendsList(Friends friends);

}
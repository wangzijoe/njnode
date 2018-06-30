package cn.njnode.beans.subscriber;

public class Friends {
    /**
     * <pre>
     * 
     * 表字段 : t_friends.id
     * </pre>
     */
    private Integer id;

    /**
     * <pre>
     * 
     * 表字段 : t_friends.user_id
     * </pre>
     */
    private String userId;

    /**
     * <pre>
     * 
     * 表字段 : t_friends.friends_id
     * </pre>
     */
    private String friendsId;

    /**
     * <pre>
     * 两人关系，0-无关、1-关注、2-好友、3-黑名单
     * 表字段 : t_friends.relationship
     * </pre>
     */
    private Integer relationship;

    /**
     * <pre>
     * 分组
     * 表字段 : t_friends.group
     * </pre>
     */
    private String group;

    /**
     * <pre>
     * 获取：
     * 表字段：t_friends.id
     * </pre>
     *
     * @return t_friends.id：
     */
    public Integer getId() {
        return id;
    }

    /**
     * <pre>
     * 设置：
     * 表字段：t_friends.id
     * </pre>
     *
     * @param id
     *            t_friends.id：
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * <pre>
     * 获取：
     * 表字段：t_friends.user_id
     * </pre>
     *
     * @return t_friends.user_id：
     */
    public String getUserId() {
        return userId;
    }

    /**
     * <pre>
     * 设置：
     * 表字段：t_friends.user_id
     * </pre>
     *
     * @param userId
     *            t_friends.user_id：
     */
    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    /**
     * <pre>
     * 获取：
     * 表字段：t_friends.friends_id
     * </pre>
     *
     * @return t_friends.friends_id：
     */
    public String getFriendsId() {
        return friendsId;
    }

    /**
     * <pre>
     * 设置：
     * 表字段：t_friends.friends_id
     * </pre>
     *
     * @param friendsId
     *            t_friends.friends_id：
     */
    public void setFriendsId(String friendsId) {
        this.friendsId = friendsId == null ? null : friendsId.trim();
    }

    /**
     * <pre>
     * 获取：两人关系，0-无关、1-关注、2-好友、3-黑名单
     * 表字段：t_friends.relationship
     * </pre>
     *
     * @return t_friends.relationship：两人关系，0-无关、1-关注、2-好友、3-黑名单
     */
    public Integer getRelationship() {
        return relationship;
    }

    /**
     * <pre>
     * 设置：两人关系，0-无关、1-关注、2-好友、3-黑名单
     * 表字段：t_friends.relationship
     * </pre>
     *
     * @param relationship
     *            t_friends.relationship：两人关系，0-无关、1-关注、2-好友、3-黑名单
     */
    public void setRelationship(Integer relationship) {
        this.relationship = relationship;
    }

    /**
     * <pre>
     * 获取：分组
     * 表字段：t_friends.group
     * </pre>
     *
     * @return t_friends.group：分组
     */
    public String getGroup() {
        return group;
    }

    /**
     * <pre>
     * 设置：分组
     * 表字段：t_friends.group
     * </pre>
     *
     * @param group
     *            t_friends.group：分组
     */
    public void setGroup(String group) {
        this.group = group == null ? null : group.trim();
    }
}
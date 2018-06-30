package cn.njnode.beans.system;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)  
//XML文件中的根标识  
@XmlRootElement(name = "User")  
//控制JAXB 绑定类中属性和字段的排序  
@XmlType(propOrder = {   
     "id",   
     "username",   
     "password",   
     "salt",   
     "roleNames",   
     "locked",
     "des",
     "pid"
})  
public class User implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = -2993259615361580044L;

	/**
     * <pre>
     * 
     * 表字段 : sys_user.id
     * </pre>
     */
    private String id;

    /**
     * <pre>
     * 
     * 表字段 : sys_user.username
     * </pre>
     */
    private String username;

    /**
     * <pre>
     * 
     * 表字段 : sys_user.password
     * </pre>
     */
    private String password;

    /**
     * <pre>
     * 
     * 表字段 : sys_user.salt
     * </pre>
     */
    private String salt;

    /**
     * <pre>
     * 
     * 表字段 : sys_user.role_names
     * </pre>
     */
    private String roleNames;

    /**
     * <pre>
     * 
     * 表字段 : sys_user.locked
     * </pre>
     */
    private Boolean locked;

    /**
     * <pre>
     * 
     * 表字段 : sys_user.des
     * </pre>
     */
    private String des;

    /**
     * <pre>
     * 
     * 表字段 : sys_user.pid
     * </pre>
     */
    private String pid;

    /**
     * <pre>
     * 获取：
     * 表字段：sys_user.id
     * </pre>
     *
     * @return sys_user.id：
     */
    public String getId() {
        return id;
    }

    /**
     * <pre>
     * 设置：
     * 表字段：sys_user.id
     * </pre>
     *
     * @param id
     *            sys_user.id：
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * <pre>
     * 获取：
     * 表字段：sys_user.username
     * </pre>
     *
     * @return sys_user.username：
     */
    public String getUsername() {
        return username;
    }

    /**
     * <pre>
     * 设置：
     * 表字段：sys_user.username
     * </pre>
     *
     * @param username
     *            sys_user.username：
     */
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    /**
     * <pre>
     * 获取：
     * 表字段：sys_user.password
     * </pre>
     *
     * @return sys_user.password：
     */
    public String getPassword() {
        return password;
    }

    /**
     * <pre>
     * 设置：
     * 表字段：sys_user.password
     * </pre>
     *
     * @param password
     *            sys_user.password：
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * <pre>
     * 获取：
     * 表字段：sys_user.salt
     * </pre>
     *
     * @return sys_user.salt：
     */
    public String getSalt() {
        return salt;
    }

    /**
     * <pre>
     * 设置：
     * 表字段：sys_user.salt
     * </pre>
     *
     * @param salt
     *            sys_user.salt：
     */
    public void setSalt(String salt) {
        this.salt = salt == null ? null : salt.trim();
    }

    /**
     * <pre>
     * 获取：
     * 表字段：sys_user.role_names
     * </pre>
     *
     * @return sys_user.role_names：
     */
    public String getRoleNames() {
        return roleNames;
    }

    /**
     * <pre>
     * 设置：
     * 表字段：sys_user.role_names
     * </pre>
     *
     * @param roleNames
     *            sys_user.role_names：
     */
    public void setRoleNames(String roleNames) {
        this.roleNames = roleNames == null ? null : roleNames.trim();
    }

    /**
     * <pre>
     * 获取：
     * 表字段：sys_user.locked
     * </pre>
     *
     * @return sys_user.locked：
     */
    public Boolean getLocked() {
        return locked;
    }

    /**
     * <pre>
     * 设置：
     * 表字段：sys_user.locked
     * </pre>
     *
     * @param locked
     *            sys_user.locked：
     */
    public void setLocked(Boolean locked) {
        this.locked = locked;
    }

    /**
     * <pre>
     * 获取：
     * 表字段：sys_user.des
     * </pre>
     *
     * @return sys_user.des：
     */
    public String getDes() {
        return des;
    }

    /**
     * <pre>
     * 设置：
     * 表字段：sys_user.des
     * </pre>
     *
     * @param des
     *            sys_user.des：
     */
    public void setDes(String des) {
        this.des = des == null ? null : des.trim();
    }

    /**
     * <pre>
     * 获取：
     * 表字段：sys_user.pid
     * </pre>
     *
     * @return sys_user.pid：
     */
    public String getPid() {
        return pid;
    }

    /**
     * <pre>
     * 设置：
     * 表字段：sys_user.pid
     * </pre>
     *
     * @param pid
     *            sys_user.pid：
     */
    public void setPid(String pid) {
        this.pid = pid == null ? null : pid.trim();
    }
}
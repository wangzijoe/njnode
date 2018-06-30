package cn.njnode.shiro.realm;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import cn.njnode.HandlerResult;
import cn.njnode.beans.system.User;
import cn.njnode.system.server.UserServer;

public class UserRealm extends AuthorizingRealm {

	@Resource
	UserServer UserServer;

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
		if (null != principals) {
			String userName = (String) principals.getPrimaryPrincipal();
			// this.clearCache(SecurityUtils.getSubject().getPreviousPrincipals());
			HandlerResult<List<String>> result = UserServer.queryRolesByUserName(userName);

			Set<String> roles = new HashSet<String>(result.getResultObj());

			// 设置角色
			authorizationInfo.setRoles(roles);
			result = UserServer.queryPermisionByUserName(userName);
			Set<String> permissions = new HashSet<String>(result.getResultObj());
			// 设置权限
			authorizationInfo.setStringPermissions(permissions);
			return authorizationInfo;
		}

		return authorizationInfo;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		String username = (String) token.getPrincipal();
		User tempUser = new User();
		tempUser.setUsername(username);
		HandlerResult<List<User>> result = UserServer.queryUserList(tempUser, 1, 10);
		User user = result.getResultObj().get(0);
		if (null == user) {
			throw new UnknownAccountException();// 没找到帐号
		}

		if (Boolean.TRUE.equals(user.getLocked())) {
			throw new LockedAccountException(); // 帐号锁定
		}

		// 交给AuthenticatingRealm使用CredentialsMatcher进行密码匹配，如果觉得人家的不好可以自定义实现
		SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(user.getUsername(), // 用户名
				user.getPassword(), // 密码
				ByteSource.Util.bytes(user.getUsername() + user.getSalt()), // salt=username+salt
				getName() // realm name
		);
		return authenticationInfo;
	}

}

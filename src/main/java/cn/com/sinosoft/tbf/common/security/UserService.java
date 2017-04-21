package cn.com.sinosoft.tbf.common.security;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.stereotype.Service;

import cn.com.sinosoft.tbf.common.security.exception.SecurityExceptionUserNotLogin;
import cn.com.sinosoft.tbf.common.security.exception.SecurityExceptionUserNotValid;
import cn.com.sinosoft.tbf.common.util.StringUtil;
import cn.com.sinosoft.tbf.common.util.security.MD5Util;
import cn.com.sinosoft.tbf.common.util.security.UserUtil;
import cn.com.sinosoft.tbf.dao.BaseDaoAbst;
import cn.com.sinosoft.tbf.domain.common.security.RoleInfo;
import cn.com.sinosoft.tbf.domain.common.security.UserInfo;

/**
 * 用户相关业务
 *
 * @author <a href="mainto:nytclizy@gmail.com">lizhiyong</a>
 * @since 2016年8月10日
 */
@Service
public class UserService {

	public static final String NAMESPACE_BASE_DEFAULT = "cn.com.sinosoft.tbf.default.";

	@Resource
	UserUtil userUtil;
	@Resource
	BaseDaoAbst baseDao;

	/**
	 * 验证用户名和密码
	 *
	 * @param userName
	 *            用户名
	 * @param passWord
	 *            密码
	 * @return 是否正确
	 */
	public boolean validUser(String userName, String passWord)
			throws AuthenticationServiceException {
		if (userName == null || passWord == null) {
			throw new SecurityExceptionUserNotValid("用户名、密码不能为空");
		}
		UserInfo userInfo = getUserBaseInfo(userName, passWord);
		if (userInfo == null) {
			throw new SecurityExceptionUserNotValid("用户名或密码错误");
		}
		return true;
	}

	/**
	 * 获取用户基础信息
	 *
	 * @param userName
	 *            用户名
	 * @param passWord
	 *            密码
	 * @return 用户基础信息
	 */
	public UserInfo getUserBaseInfo(String userName, String passWord)
			throws AuthenticationServiceException {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("userName", userName);
		params.put("passWord", MD5Util.digestMD5(passWord));
		List<UserInfo> users = baseDao
				.queryList(NAMESPACE_BASE_DEFAULT + "User-list", params);
		return users.size() > 0 ? users.get(0) : null;
	}

	/**
	 * 获取用户基础信息并验证
	 *
	 * @param userName
	 *            用户名
	 * @param passWord
	 *            密码
	 * @return 用户基础信息
	 */
	public UserInfo getUserBaseInfoAndValid(String userName, String passWord)
			throws AuthenticationServiceException {
		if (userName == null) {
			throw new SecurityExceptionUserNotLogin("未登录");
		}
		return getUserBaseInfo(userName, passWord);
	}

	/**
	 * 根据用户id获取用户角色信息
	 *
	 * @param userId
	 *            用户id
	 * @return 角色信息
	 */
	public List<RoleInfo> getRoleByUserId(String userId) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("userId", userId);
		return baseDao.queryList(
				NAMESPACE_BASE_DEFAULT + "Role-list-getByUserid", params);
	}

	/**
	 * 根据角色id获取用户授权信息
	 *
	 * @param roleIds
	 *            角色ids
	 * @return 授权信息
	 */
	public List<String> getGrantsByUserId(List<String> roleIds) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("roleIds", roleIds);
		return baseDao.queryList(
				NAMESPACE_BASE_DEFAULT + "Grants-list-getByRoleids", params);
	}

	/**
	 * 登录、获取用户信息-包括权限、角色等
	 *
	 * @param userName
	 *            用户名
	 * @param passWord
	 *            密码
	 * @return 用户信息
	 */
	public UserInfo login(String userName, String passWord)
			throws AuthenticationServiceException {
		if (StringUtil.isEmpty(userName) || StringUtil.isEmpty(passWord)) {
			throw new SecurityExceptionUserNotValid("用户、密码不能为空");
		}
		UserInfo userInfo = getUserBaseInfo(userName, passWord);
		if (userInfo != null) {// 登录成功

			if (UserUtil.USER_STATE_LOCKED.equals(userInfo.getState())) {
				throw new SecurityExceptionUserNotValid("用户已被锁定");
			}

			// 角色信息
			List<RoleInfo> roleInfos = getRoleByUserId(userInfo.getUserId());
			userInfo.setRoles(roleInfos);
			List<String> roleIds = new ArrayList<String>();
			for (RoleInfo roleInfo : roleInfos) {
				roleIds.add(roleInfo.getRoleId());
			}

			// 授权信息
			userInfo.setGrants(getGrantsByUserId(roleIds));

		} else {
			throw new SecurityExceptionUserNotValid("用户名或者密码错误");
		}
		return userInfo;
	}

	/**
	 * 根据用户名获取用户基础信息
	 *
	 * @param string
	 * @return
	 */
	public UserInfo getUserInfoByName(String userName) {
		if (StringUtil.isEmpty(userName)) {
			return null;
		}
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("userName", userName);
		List<UserInfo> users = baseDao
				.queryList(NAMESPACE_BASE_DEFAULT + "User-list", params);
		return users.size() > 0 ? users.get(0) : null;
	}

	/**
	 * 查询所有的用户名
	 *
	 * @param userName
	 *            用户名
	 * @return
	 */
	public List<String> getUserName(String userName) {
		List<String> countnum = baseDao
				.queryList(NAMESPACE_BASE_DEFAULT + "User-loginName", userName);
		return countnum;
	}
}

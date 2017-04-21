package cn.com.sinosoft.tbf.common.util.security;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.sinosoft.tbf.common.util.StringUtil;
import cn.com.sinosoft.tbf.domain.common.security.RoleInfo;
import cn.com.sinosoft.tbf.domain.common.security.UserInfo;

/**
 * 用户相关信息
 *
 * @author <a href="mainto:nytclizy@gmail.com">lizhiyong</a>
 * @since 2016年8月23日
 */
@Service
public class UserUtil {
	
	/**
	 * session中存储用户信息
	 */
	public static final String SESSION_NAME_USERINFO = "loginUserInfo";

	/**
	 * 用户状态-锁定
	 */
	public static final String USER_STATE_LOCKED = "1";

	/**
	 * 用户状态-未锁定
	 */
	public static final String USER_STATE_UNLOCKED = "0";

	/**
	 * 用户默认密码
	 */
	public static final String USER_PWD_DEFAULT = "00000000";

	@Autowired
	HttpServletRequest request;

	/**
	 * 获取请求用户信息
	 *
	 * @return
	 */
	public UserInfo getRequestUser() {
		try{
			return (UserInfo)request.getSession().getAttribute(SESSION_NAME_USERINFO);
		}catch(Exception e){
			// 非web环境下会出此异常，不影响后续操作
			return null;
		}
	}

	/**
	 * 获取请求用户用户名
	 *
	 * @return
	 */
	public String getRequestUserLoginName() {
		UserInfo user = getRequestUser();
		return user != null ? user.getLoginName() : null;
	}

	/**
	 * 获取请求用户id
	 *
	 * @return
	 */
	public String getRequestUserId() {
		UserInfo user = getRequestUser();
		return user != null ? user.getUserId() : null;
	}

	/**
	 * 获取请求用户的角色
	 *
	 * @return
	 */
	public List<RoleInfo> getRequestRoles() {
		UserInfo userInfo = getRequestUser();
		return userInfo == null
				? new ArrayList<RoleInfo>()
				: userInfo.getRoles();
	}

	/**
	 * 是否请求用户拥有指定角色
	 *
	 * @param roleId
	 * @return
	 */
	public boolean isRequestHasRole(String roleId) {
		if (StringUtil.isEmpty(roleId)) {
			return false;
		}
		List<RoleInfo> roles = getRequestRoles();
		if (roles == null || roles.size() == 0) {
			return false;
		}
		for (RoleInfo role : roles) {
			if (role.getRoleId().equals(roleId)) {
				return true;
			}
		}
		return false;
	}

}

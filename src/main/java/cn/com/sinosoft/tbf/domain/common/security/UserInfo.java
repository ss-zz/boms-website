package cn.com.sinosoft.tbf.domain.common.security;

import java.util.List;

/**
 * api登录用户信息
 *
 * @author <a href="mainto:nytclizy@gmail.com">lizhiyong</a>
 * @since 2016年8月12日
 */
public class UserInfo {
	
	/**
	 * 用户id
	 */
	private String userId;
	
	/**
	 * 登录名
	 */
	private String loginName;
	
	/**
	 * 用户名称
	 */
	private String name;
	
	/**
	 * 用户状态
	 */
	private String state;

	/**
	 * 角色信息
	 */
	private List<RoleInfo> roles;
	
	/**
	 * 授权信息
	 */
	private List<String> grants;
	
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public List<RoleInfo> getRoles() {
		return roles;
	}

	public void setRoles(List<RoleInfo> roles) {
		this.roles = roles;
	}

	public List<String> getGrants() {
		return grants;
	}

	public void setGrants(List<String> grants) {
		this.grants = grants;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

}

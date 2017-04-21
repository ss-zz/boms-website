package cn.com.sinosoft.tbf.domain.common.security;

/**
 * 角色信息
 *
 * @author <a href="mainto:nytclizy@gmail.com">lizhiyong</a>
 * @since 2016年8月12日
 */
public class RoleInfo {
	
	/**
	 * 角色id
	 */
	private String roleId;
	
	/**
	 * 角色名
	 */
	private String roleName;
	
	/**
	 * 角色描述
	 */
	private String roleDesc;
	
	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRoleDesc() {
		return roleDesc;
	}

	public void setRoleDesc(String roleDesc) {
		this.roleDesc = roleDesc;
	}

}

package com.shoe.pojo;

/**
 * 角色表(t_role)
 * 
 * @author 李杨
 * @param roleId
 *            Integer 角色编号ID,主键标识符
 * @param roleName
 *            String 角色名称
 * @param roleInformation
 *            String 角色介绍
 */
public class Role {

	private Integer roleId;

	private String roleName;

	private String roleInformation;

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRoleInformation() {
		return roleInformation;
	}

	public void setRoleInformation(String roleInformation) {
		this.roleInformation = roleInformation;
	}

	@Override
	public String toString() {
		return "Role [roleId=" + roleId + ", roleName=" + roleName + ", roleInformation=" + roleInformation + "]";
	}

}

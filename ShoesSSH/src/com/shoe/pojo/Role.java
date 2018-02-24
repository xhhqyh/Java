package com.shoe.pojo;

/**
 * ��ɫ��(t_role)
 * 
 * @author ����
 * @param roleId
 *            Integer ��ɫ���ID,������ʶ��
 * @param roleName
 *            String ��ɫ����
 * @param roleInformation
 *            String ��ɫ����
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

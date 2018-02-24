package com.shoe.pojo;

/**
 * 
 * ����ԱVO
 * ����Ա��(t_manager)
 * @gx
 * add by 2018-1-12
 *	@param managerId
 *            Integer ����Ա���id,������ʶ��
 * @param managerName
 *            String ����Ա�˺�
 * @param managerPwd
 *            String ����Ա����
 * @param roleId
 *            Integer ��ɫId
 * @param managerReark
 *            String ����Ա��ע
 */
public class ManagerVO {
	private Integer managerId;
	private String managerName;
	private String managerPwd;
	private Integer roleId;
	private String managerRemark;

	public Integer getManagerId() {
		return managerId;
	}

	public void setManagerId(Integer managerId) {
		this.managerId = managerId;
	}

	public String getManagerName() {
		return managerName;
	}

	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}

	public String getManagerPwd() {
		return managerPwd;
	}

	public void setManagerPwd(String managerPwd) {
		this.managerPwd = managerPwd;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public String getManagerRemark() {
		return managerRemark;
	}

	public void setManagerRemark(String managerRemark) {
		this.managerRemark = managerRemark;
	}

	@Override
	public String toString() {
		return "ManagerVO [managerId=" + managerId + ", managerName=" + managerName + ", managerPwd=" + managerPwd
				+ ", roleId=" + roleId + ", managerRemark=" + managerRemark + "]";
	}
}

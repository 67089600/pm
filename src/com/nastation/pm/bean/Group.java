/**
 * ����:�û���javaBean
 * @author liuliehui
 */
package com.nastation.pm.bean;

public class Group {
	private int id; //��ID
	private String name; //����
	private int userCount; //һ�����Ӧ���û���
	private int permissionSchemeId; //Ȩ��ģ��ID
	private String createDate; //��������
	private String permissionSchemeName; //Ȩ��ģ����
	private int userId; //�û�ID
	private int groupUserId; //�û���ID
	private String userName; //�û���
	private String userFullName; //�û�ȫ��
	private String userEmail; //�û�����
	

	public int getGroupUserId() {
		return groupUserId;
	}
	public void setGroupUserId(int groupUserId) {
		this.groupUserId = groupUserId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getUserCount() {
		return userCount;
	}
	public void setUserCount(int userCount) {
		this.userCount = userCount;
	}
	public int getPermissionSchemeId() {
		return permissionSchemeId;
	}
	public void setPermissionSchemeId(int permissionSchemeId) {
		this.permissionSchemeId = permissionSchemeId;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public String getPermissionSchemeName() {
		return permissionSchemeName;
	}
	public void setPermissionSchemeName(String permissionSchemeName) {
		this.permissionSchemeName = permissionSchemeName;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserFullName() {
		return userFullName;
	}
	public void setUserFullName(String userFullName) {
		this.userFullName = userFullName;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

}

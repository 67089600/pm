package com.nastation.pm.bean;

/**
 * Permission Assignee bean
 * 
 * @author sun
 * 
 */
public class PermissionAssignee {
	
	private int id;// Ȩ�޷���ID
	private int permissionId;// Ȩ��id
	private String assigneeType;
	private String assignee;
	private int schemeId;// Ȩ��ģ��id
	private String createTime;// Ȩ�޷��䴴��ʱ��
	private String permission;// Ȩ������
	private String permissionDescription; // Ȩ������
	private String permissionTypeName; // Ȩ����������
	private String permissionDateTime; // Ȩ�޴���ʱ��
	private String schemeName; // Ȩ��ģ������
	private String schemeDescription; // Ȩ��ģ������
	private String schemeDateTime;// Ȩ��ģ�鴴��ʱ��

	public String getPermissionDescription() {
		return permissionDescription;
	}

	public void setPermissionDescription(String permissionDescription) {
		this.permissionDescription = permissionDescription;
	}

	public String getPermissionTypeName() {
		return permissionTypeName;
	}

	public void setPermissionTypeName(String permissionTypeName) {
		this.permissionTypeName = permissionTypeName;
	}

	public String getPermissionDateTime() {
		return permissionDateTime;
	}

	public void setPermissionDateTime(String permissionDateTime) {
		this.permissionDateTime = permissionDateTime;
	}

	public String getSchemeName() {
		return schemeName;
	}

	public void setSchemeName(String schemeName) {
		this.schemeName = schemeName;
	}

	public String getSchemeDescription() {
		return schemeDescription;
	}

	public void setSchemeDescription(String schemeDescription) {
		this.schemeDescription = schemeDescription;
	}

	public String getSchemeDateTime() {
		return schemeDateTime;
	}

	public void setSchemeDateTime(String schemeDateTime) {
		this.schemeDateTime = schemeDateTime;
	}

	public String getPermission() {
		return permission;
	}

	public void setPermission(String permission) {
		this.permission = permission;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPermissionId() {
		return permissionId;
	}

	public void setPermissionId(int permissionId) {
		this.permissionId = permissionId;
	}

	public String getAssigneeType() {
		return assigneeType;
	}

	public void setAssigneeType(String assigneeType) {
		this.assigneeType = assigneeType;
	}

	public String getAssignee() {
		return assignee;
	}

	public void setAssignee(String assignee) {
		this.assignee = assignee;
	}

	public int getSchemeId() {
		return schemeId;
	}

	public void setSchemeId(int schemeId) {
		this.schemeId = schemeId;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

}

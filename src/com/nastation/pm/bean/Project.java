package com.nastation.pm.bean;


/**
 * 
 * @author Zhangbo
 * ��������Ŀjavabean
 */

public class Project {
	
	private int projectId;
	private String name; //��Ŀ����
	private String projectKey; 
	private String description; //����
	private String url;  //��Ŀ·��
	private String leader;  //����Աid
	private int categoryId;  //����id
	private String createDate;  //��������
	private int permissionSchemeId;//����Ŀʹ�õ�Ȩ��ģ��id
	
	

	public int getPermissionSchemeId() {
		return permissionSchemeId;
	}

	public void setPermissionSchemeId(int permissionSchemeId) {
		this.permissionSchemeId = permissionSchemeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getProjectKey() {
		return projectKey;
	}

	public void setProjectKey(String projectKey) {
		this.projectKey = projectKey;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getLeader() {
		return leader;
	}

	public void setLeader(String leader) {
		this.leader = leader;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}
	
}

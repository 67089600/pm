package com.nastation.pm.bean;

/*
 * �����projectCategory��bean;
 */
public class ProjectCategory {
	private int id;// ��Ŀ����ID
	private String name;// ��Ŀ��������
	private String description;// ��Ŀ��������
	private String createDate;// ��Ŀ���ʹ�������

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
}

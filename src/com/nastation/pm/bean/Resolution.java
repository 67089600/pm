package com.nastation.pm.bean;

/**
 * ����Resolution
 * 
 * @author Kris
 * @version 2008-12-27
 */
public class Resolution {

	private int id; // ��������ID
	private String name; // ��������
	private String description; // ��������
	private int isDefault; // ͼ��URL

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

	public int getIsDefault() {
		return isDefault;
	}

	public void setIsDefault(int isDefault) {
		this.isDefault = isDefault;
	}

}
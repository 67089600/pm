package com.nastation.pm.bean;

/**
 * ���ܣ�Issue ״̬�ķ�װ��
 * @author ��ϣ��
 *
 */
public class IssueStatus {
	private int id;              // ״̬id
    private String name;         // ״̬����
    private String description;  //  ״̬������
    private String iconUrl;      // ״̬��ͼ��
    
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
	public String getIconUrl() {
		return iconUrl;
	}
	public void setIconUrl(String iconUrl) {
		this.iconUrl = iconUrl;
	}
    
    
}

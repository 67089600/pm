package com.nastation.pm.bean;

/**
 * ���ܣ��������ȼ� bean ��,��װ�ֶ�
 * @author ��ϣ��
 *
 */
public class IssuePriority {
	
    private int id;                // �������ȼ�ID
    private String name;           // ���ȼ�����
    private String description;    // ���ȼ�����
    private String priorityColor; // ���ȼ���ɫ
    private String iconUrl;       // ���ȼ�ͼ��URL
    
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
	public String getPriorityColor() {
		return priorityColor;
	}
	public void setPriorityColor(String priorityColor) {
		this.priorityColor = priorityColor;
	}
	public String getIconUrl() {
		return iconUrl;
	}
	public void setIconUrl(String iconUrl) {
		this.iconUrl = iconUrl;
	}
    
	
}

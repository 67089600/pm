package com.nastation.pm.bean;

/**
 * ���ܣ��������� bean ��,��װ�ֶ�
 * @author ��ϣ��
 *
 */
public class IssueType {
	
    private int id;               // ��������ID
    private String name;          // ��������
    private String description;   // �������� 
    private String iconUrl;      // ͼ��URL
    private String createDate;   // �����ʹ�����ʱ��
    
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
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
}

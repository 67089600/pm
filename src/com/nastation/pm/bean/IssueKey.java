package com.nastation.pm.bean;

 /**
  * ���ܣ�����Issue ��Key,��װ����ֶ�
  * @author ��ϣ��
  *
  */
public class IssueKey {
    
	private String issueKey; // Keyֵ
	private int issueId;     // ���� Issue ���� Id
	private int projectId;   // ��Ŀ Project ���� Id
	public String getIssueKey() {
		return issueKey;
	}
	
	public void setIssueKey(String issueKey) {
		this.issueKey = issueKey;
	}
	public int getIssueId() {
		return issueId;
	}
	public void setIssueId(int issueId) {
		this.issueId = issueId;
	}
	public int getProjectId() {
		return projectId;
	}
	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}
	
	
	
}

package com.nastation.pm.bean;

/**
 * 
 * @author liuliehui ��ע��javaBean��
 */
public class Comment {
	public int id; // ��עID
	public String commentContent; // ��ע����
	public String author; // ������
	public int issueId; // ����ID
	public String createDate; // ��ע����ʱ��

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCommentContent() {
		return commentContent;
	}

	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getIssueId() {
		return issueId;
	}

	public void setIssueId(int issueId) {
		this.issueId = issueId;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

}

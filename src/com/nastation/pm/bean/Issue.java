package com.nastation.pm.bean;

/**
 * ���ܣ����������Ϣ bean ��,��װ�ֶ�
 * 
 * @author ��ϣ��
 */
public class Issue {

	private int id; // ����ID
	private String issueKey;
	private int issueTypeId; // ��������ID
	private String issueTypeName; // ������������
	private String issueTypeIcon;
	private String name; // �����Ҫ
	private int priorityLevelId; // ���ȼ�ID
	private String priorityLevel; // ���ȼ�����
	private String priorityLevelIcon;
	private String startTime; // ʵ�ʿ�ʼʱ��
	private String endTime; // ʵ�ʽ�������
	private String planEndTime; // �ƻ�����ʱ��
	private int componentId; // ģ��ID
	private String componentName; // ģ������
	private int assigneeId; // ������ID
	private String assignee; // ����������
	private String assigneeFullname;
	private int reporterId; // ������ID
	private String reporter; // ����������
	private String reporterFullname;
	private String environment; // ����
	private String description; // ��������
	private int projectId; // ��ĿID
	private String projectName; // ��Ŀ����
	private String lastUpdateDate; // ����������
	private String createDate; // ��������
	private int issueStatus; // ����״̬
	private int resolutionId;
	private String resolution;
	private String issueStatusName;
	private String issueStatusIcon;

	public String getIssueStatusName() {
		return issueStatusName;
	}

	public void setIssueStatusName(String issueStatusName) {
		this.issueStatusName = issueStatusName;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getPlanEndTime() {
		return planEndTime;
	}

	public void setPlanEndTime(String planEndTime) {
		this.planEndTime = planEndTime;
	}

	public int getIssueStatus() {
		return issueStatus;
	}

	public void setIssueStatus(int issueStatus) {
		this.issueStatus = issueStatus;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIssueTypeId() {
		return issueTypeId;
	}

	public void setIssueTypeId(int issueTypeId) {
		this.issueTypeId = issueTypeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPriorityLevelId() {
		return priorityLevelId;
	}

	public void setPriorityLevelId(int priorityLevelId) {
		this.priorityLevelId = priorityLevelId;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public int getComponentId() {
		return componentId;
	}

	public void setComponentId(int componentId) {
		this.componentId = componentId;
	}

	public int getAssigneeId() {
		return assigneeId;
	}

	public void setAssigneeId(int assigneeId) {
		this.assigneeId = assigneeId;
	}

	public int getReporterId() {
		return reporterId;
	}

	public void setReporterId(int reporterId) {
		this.reporterId = reporterId;
	}

	public String getEnvironment() {
		return environment;
	}

	public void setEnvironment(String environment) {
		this.environment = environment;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	public String getLastUpdateDate() {
		return lastUpdateDate;
	}

	public void setLastUpdateDate(String lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public String getIssueKey() {
		return issueKey;
	}

	public void setIssueKey(String issueKey) {
		this.issueKey = issueKey;
	}

	public String getIssueTypeName() {
		return issueTypeName;
	}

	public void setIssueTypeName(String issueTypeName) {
		this.issueTypeName = issueTypeName;
	}

	public String getPriorityLevel() {
		return priorityLevel;
	}

	public void setPriorityLevel(String priorityLevel) {
		this.priorityLevel = priorityLevel;
	}

	public String getComponentName() {
		return componentName;
	}

	public void setComponentName(String componentName) {
		this.componentName = componentName;
	}

	public String getAssignee() {
		return assignee;
	}

	public void setAssignee(String assignee) {
		this.assignee = assignee;
	}

	public String getReporter() {
		return reporter;
	}

	public void setReporter(String reporter) {
		this.reporter = reporter;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getIssueTypeIcon() {
		return issueTypeIcon;
	}

	public void setIssueTypeIcon(String issueTypeIcon) {
		this.issueTypeIcon = issueTypeIcon;
	}

	public String getPriorityLevelIcon() {
		return priorityLevelIcon;
	}

	public void setPriorityLevelIcon(String priorityLevelIcon) {
		this.priorityLevelIcon = priorityLevelIcon;
	}

	public String getIssueStatusIcon() {
		return issueStatusIcon;
	}

	public void setIssueStatusIcon(String issueStatusIcon) {
		this.issueStatusIcon = issueStatusIcon;
	}

	public int getResolutionId() {
		return resolutionId;
	}

	public void setResolutionId(int resolutionId) {
		this.resolutionId = resolutionId;
	}

	public String getResolution() {
		return resolution;
	}

	public void setResolution(String resolution) {
		this.resolution = resolution;
	}

	public String getAssigneeFullname() {
		return assigneeFullname;
	}

	public void setAssigneeFullname(String assigneeFullname) {
		this.assigneeFullname = assigneeFullname;
	}

	public String getReporterFullname() {
		return reporterFullname;
	}

	public void setReporterFullname(String reporterFullname) {
		this.reporterFullname = reporterFullname;
	}

}

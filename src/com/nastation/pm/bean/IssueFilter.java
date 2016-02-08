package com.nastation.pm.bean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class IssueFilter {

	// ----������item�е�keyֵ -------
	public static final String pid = "��Ŀ";
	public static final String issue_type = "��������";
	public static final String query = "��ѯ";
	public static final String query_summary = "��Ҫ";
	public static final String query_description = "����";
	public static final String query_body = "��ע";
	public static final String query_environment = "����";
	public static final String reporterSelect = "������ѡ��";
	public static final String reporter = "������";
	public static final String assigneeSelect = "������ѡ��";
	public static final String assignee = "������";
	public static final String status = "״̬";
	public static final String resolution = "ƥ��Ľ�����";
	public static final String priority = "ƥ������ȼ�";
	public static final String createdafter = "����..֮��";
	public static final String createdbefore = "����..֮ǰ";
	public static final String duedateafter = "����..֮��";
	public static final String duedatebefore = "����..֮ǰ";

	private String filterName;
	private int id;
	private String authorName;
	private String description;
	private int projectId;
	private String projectName;
	private String requestContent;
	private HashMap item;
	private List paramValues;

	public boolean isSaved() {
		return ((id != 0) && (filterName != null));
	}

	public boolean isNotSaved() {
		return !isSaved();
	}

	public HashMap getItem() {
		return item;
	}

	public void setItem(HashMap item) {
		this.item = item;
	}

	public String getFilterName() {
		return filterName;
	}

	public void setFilterName(String filterName) {
		this.filterName = filterName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
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

	public String getRequestContent() {
		return requestContent;
	}

	public void setRequestContent(String requestContent) {
		this.requestContent = requestContent;
	}

	public String getItemValue(String key) {
		if (item != null) {
			return (String) item.get(key);
		}
		return null;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public List getParamValues() {
		return paramValues;
	}

	public void setParamValues(List paramValues) {
		this.paramValues = paramValues;
	}

	/**
	 * ֻ�ǱȽ����ݣ����Ƚ�id, ���Ҳ��Ƚ�id������дequals����
	 * 
	 * @param oneFilter
	 * @return
	 */
	public boolean isChanged(IssueFilter oneFilter) {
		if (oneFilter == null) {
			return false;
		}
		if (this == oneFilter) {
			return true;
		}

		boolean changed = false;
		if (this.authorName != null) {
			if (!authorName.equals(oneFilter.getAuthorName())) {
				changed = true;
			}
		} else {
			if (oneFilter.getAuthorName() != null) {
				changed = true;
			}
		}
		if (this.description != null) {
			if (!description.equals(oneFilter.getDescription())) {
				changed = true;
			}
		} else {
			if (oneFilter.getDescription() != null) {
				changed = true;
			}
		}
		if (this.filterName != null) {
			if (!filterName.equals(oneFilter.getFilterName())) {
				changed = true;
			}
		} else {
			if (oneFilter.getFilterName() != null) {
				changed = true;
			}
		}
		if (this.projectName != null) {
			if (!projectName.equals(oneFilter.getProjectName())) {
				changed = true;
			}
		} else {
			if (oneFilter.getProjectName() != null) {
				changed = true;
			}
		}
		if (this.requestContent != null) {
			if (!requestContent.equals(oneFilter.getRequestContent())) {
				changed = true;
			}
		} else {
			if (oneFilter.getRequestContent() != null) {
				changed = true;
			}
		}
		if (this.projectId != oneFilter.getProjectId()) {
			changed = true;
		}
		if (this.item != null) {
			if (!item.equals(oneFilter.getItem())) {
				changed = true;
			}
		} else {
			if (oneFilter.getItem() != null) {
				changed = true;
			}
		}
		if (this.paramValues != null) {
			if (!paramValues.equals(oneFilter.getParamValues())) {
				changed = true;
			}
		} else {
			if (oneFilter.getParamValues() != null) {
				changed = true;
			}
		}
		return changed;
	}
	
	
	public static void main(String[] args) {
		HashMap hm1 = new HashMap();
		hm1.put(2, "kris");
		
		HashMap hm2 = new HashMap();
		hm2.put(1, "kris");
		
		List list1 = new ArrayList();
		list1.add("kris");
		List list2 = new ArrayList();
		list2.add("krisss");
		
		System.out.println("same==" + hm1.equals(hm2));
		System.out.println("same==" + list1.equals(list2));
	}

}

package com.nastation.pm;

public interface Global {

	// --------Task Status -----
	// ��״̬��ֵ�����Ӧt_issue_status�е�id
	int OPEN = 1;
	int IN_PROGRESS = 2;
	int REOPEN = 3;
	int RESOLVED = 4;
	int CLOSE = 5;

	/** ���ֵΪ1����ΪresolutionĬ��ѡ�� */
	int RESOLUTION_DEFAULT = 1;

	// ---------- key in session -------------
	String SESSION_FILTER = "SESSION_FILTER_KEY";
	String SESSION_USER = "SESSION_USER_KEY";

}

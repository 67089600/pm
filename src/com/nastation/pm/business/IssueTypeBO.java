package com.nastation.pm.business;

/**
 * ���ܣ������ҵ���߼���
 * @author ��ϣ��
 * 
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.nastation.pm.bean.Icon;
import com.nastation.pm.bean.IssueType;
import com.nastation.pm.util.DBConn;

public class IssueTypeBO {

	/**
	 * �����ݿ�����Ӽ�¼ IssueType ����
	 */
	public void addIssueType(IssueType issueType) {

		Connection conn = DBConn.getConnection();
		PreparedStatement pstmt = null;

		String sql = "insert into t_issue_type(name,description,icon_url,create_date)values(?,?,?,?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, issueType.getName());
			pstmt.setString(2, issueType.getDescription());
			pstmt.setString(3, issueType.getIconUrl());
			pstmt.setString(4, issueType.getCreateDate());

			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			DBConn.closeConn(conn);
		}
	}

	/**
	 * ���� Id ��������֪�ļ�¼IssueType ����
	 */
	public void updateIssueType(IssueType issueType) {

		Connection conn = DBConn.getConnection();
		PreparedStatement pstmt = null;

		String sql = "update t_issue_type set name=?,description=?,icon_url=? where id=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, issueType.getName());
			pstmt.setString(2, issueType.getDescription());
			pstmt.setString(3, issueType.getIconUrl());
			pstmt.setInt(4, issueType.getId());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			DBConn.closeConn(conn);
		}
	}

	/*
	 * ɾ����ӦID��IssueType ����
	 */
	public void deleteIssueType(int id) {
		Connection conn = DBConn.getConnection();
		try {
			String sql = "delete from t_issue_type where id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConn.closeConn(conn);
		}
	}

	/*
	 * ������֪�� name �����IssueType����
	 */
	public IssueType getIssueType(String name) {

		Connection conn = DBConn.getConnection();
		PreparedStatement pstmt = null;

		IssueType issueType = new IssueType();
		ResultSet rs = null;
		try {
			String sql = "select * from t_issue_type where name=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				issueType.setId(rs.getInt(1));
				issueType.setName(rs.getString(2));
				issueType.setDescription(rs.getString(3));
				issueType.setIconUrl(rs.getString(4));
				issueType.setCreateDate(rs.getString(5));

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			DBConn.closeConn(conn);
		}
		return issueType;
	}

	/*
	 * ������֪�� id ����� IssueType ����
	 */
	public IssueType getIssueType(int id) {

		Connection conn = DBConn.getConnection();
		PreparedStatement pstmt = null;

		IssueType issueType = new IssueType();
		ResultSet rs = null;
		try {
			String sql = "select * from t_issue_type where id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				issueType.setId(rs.getInt(1));
				issueType.setName(rs.getString(2));
				issueType.setDescription(rs.getString(3));
				issueType.setIconUrl(rs.getString(4));
				issueType.setCreateDate(rs.getString(5));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			DBConn.closeConn(conn);
		}
		return issueType;
	}

	/*
	 * ������������б� List
	 */
	public List<IssueType> getIssueTypeList() {

		Connection conn = DBConn.getConnection();
		PreparedStatement pstmt = null;

		List<IssueType> list = new ArrayList<IssueType>();
		ResultSet rs = null;
		try {
			String sql = "select * from t_issue_type ";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				IssueType issueType = new IssueType();
				issueType.setId(rs.getInt(1));
				issueType.setName(rs.getString(2));
				issueType.setDescription(rs.getString(3));
				issueType.setIconUrl(rs.getString(4));
				issueType.setCreateDate(rs.getString(5));
				list.add(issueType);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			DBConn.closeConn(conn);
		}
		return list;
	}

	/*
	 * ����Ƿ񴴽���ͬ��IssueType
	 */
	public boolean checkIssueType(IssueType issueType) {
		Connection conn = DBConn.getConnection();
		try {
			String sql = "select * from t_issue_type where name=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, issueType.getName());
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConn.closeConn(conn);
		}
		return true;
	}

	/**
	 * ����Ƿ񴴽���ͬ��IssueType
	 */
	public boolean exist(IssueType issueType) {
		Connection conn = DBConn.getConnection();
		try {
			String sql = "select id from t_issue_type where name=? and id!=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, issueType.getName());
			ps.setInt(2, issueType.getId());
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConn.closeConn(conn);
		}
		return false;
	}

	/**
	 * ��ô�ͼƬ���͵�list
	 * 
	 * @return
	 */
	public List<Icon> getIconList() {

		Connection conn = DBConn.getConnection();
		PreparedStatement pstmt = null;

		List<Icon> list = new ArrayList<Icon>();
		ResultSet rs = null;
		try {
			String sql = "select * from t_icon where icon_type=? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, 2);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Icon icon = new Icon();
				icon.setId(rs.getInt(1));
				icon.setFileName(rs.getString(2));
				icon.setIconType(rs.getInt(3));
				list.add(icon);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			DBConn.closeConn(conn);
		}
		return list;
	}

	/**
	 * ����icon
	 * ������������б� List
	 */
	public List<IssueType> getIssueTypeListByIcon(Icon icon) {

		Connection conn = DBConn.getConnection();
		PreparedStatement pstmt = null;

		List<IssueType> list = new ArrayList<IssueType>();
		ResultSet rs = null;
		try {
			String sql = "select * from t_issue_type where icon_url=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, icon.getFileName());
			rs = pstmt.executeQuery();
			while (rs.next()) {
				IssueType issueType = new IssueType();
				issueType.setId(rs.getInt(1));
				issueType.setName(rs.getString(2));
				issueType.setDescription(rs.getString(3));
				issueType.setIconUrl(rs.getString(4));
				issueType.setCreateDate(rs.getString(5));
				list.add(issueType);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			DBConn.closeConn(conn);
		}
		return list;
	}

}

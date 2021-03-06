<%-- 
	描述： 删除用户组里组对应的用户表单
	作者: 刘列辉
	日期: 2008-12-22
--%>
<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.nastation.pm.bean.*"%>
<%@ page import="com.nastation.pm.business.*"%>
<%@ page import="com.nastation.pm.util.*"%>
<%@ page import="java.util.*"%>
<%@taglib uri="http://java.sun.com/jstl/core" prefix="c"%>

		<%
			String moveGroupName = request.getParameter("groupName");
			if (StringUtils.isBlank(moveGroupName)) {
				System.out.println("==============moveGroupName is null ===");
				moveGroupName = "";
			}

			GroupBO moveGroupBO = new GroupBO();
			List<Group> groupUserList = moveGroupBO.getUserGroup(moveGroupName);
		%>
		
		<form action="doMoveGroupUser.jsp">
		  <table>
		  <tr>
		     <td bgcolor="#fffff0" align="center">
                <b> <%=groupUserList.size() %> Group Member(s) </b>
             </td>
		  </tr>
		  <tr>
		     <td align="center">
			   <input type="submit" value="Leave >>" />
			   <input type="hidden" name="groupName" value="<%=moveGroupName %>"/>
			</td>
		 </tr>	
		 <tr>
		    <td align="center">
		    <br>
                <%
                  if(groupUserList == null || groupUserList.size() ==0){
                      out.println("No users in selected group(s) ");
                  }else{
                      System.out.println("========44===groupUserList=========="+groupUserList);
                      out.println("<select id='usersToUnassign' size='20' name='groupUserId'>");
                      out.println("<optgroup label='"+moveGroupName+"'>");
	                  for(int i = 0;i < groupUserList.size();i++){
	                     Group moveGroup =(Group) groupUserList.get(i);
	                     if(StringUtils.isBlank(moveGroup.getUserName())){
	                       System.out.println("========UserName is null==========");
	                     }else{
	                     out.println("<option value='"+moveGroup.getGroupUserId()+"'>"+moveGroup.getUserName()+"</option>");
	                     }
	                  }   
	                  out.println("</optgroup>");
	                  out.println("</select>");
	              }    
                 %>
			</td>
		</tr>
		</table>	
	</form>
	
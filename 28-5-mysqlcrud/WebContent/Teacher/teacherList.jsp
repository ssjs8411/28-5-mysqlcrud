<!-- �̰漱 -->
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import = "service.TeacherDao" %>
<%@ page import = "java.util.ArrayList" %>
<%@ page import = "service.Teacher" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
		<title>Insert title here</title>
		<style>
			table, th, td{
				border: 1px solid;
			}
		</style>
	</head>
	<body>
		<h1>��ü��ȸ</h1>
		<table>
			<tr>
				<th>��ȣ</th>
				<th>�̸�</th>
				<th>����</th>
				<th>�ּ��Է�</th>
				<th>�����Է�</th>
				<th>����</th>
				<th>����</th>
			</tr>
<%
	request.setCharacterEncoding("euc-kr");
	
	String searchword = "";
	if(request.getParameter("searchword") != null){
		searchword = request.getParameter("searchword");
}
	
	int currentPage = 1;	// ������ ��ȣ
	int rowPerPage = 3;		// �� �������� ���� ����
			
	if(request.getParameter("currentPage") !=null ){
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
	}
	
	int startRow = (currentPage - 1) * rowPerPage;	// ���۹�ȣ = (��������ȣ-1) * �� �������� ���� ����
			
	TeacherDao tdao = new TeacherDao();		
	ArrayList<Teacher> list = tdao.selectTeacherByPage(startRow, rowPerPage);	
	
	for(int i=0; i<list.size(); i++){
		Teacher t = list.get(i);
%>
		
			<tr>
				<td><%= t.getTeacher_no() %></td>
				<td><a href="<%=request.getContextPath()%>/Teacher/teacherAddrList.jsp?teacher_no=<%=t.getTeacher_no()%>"><%= t.getTeacher_name() %></a></td>
				<td><%= t.getTeacher_age() %></td>
				<td><a href="<%=request.getContextPath()%>/Teacher/insertTeacherAddrForm.jsp?teacher_no=<%=t.getTeacher_no()%>">�ּҵ��</a></td>
				<td><a href="<%=request.getContextPath()%>/Teacher/insertScoreForm.jsp?teacher_no=<%=t.getTeacher_no()%>">�����Է�</a></td>
				<td><a href="<%=request.getContextPath()%>/Teacher/updateTeacherForm.jsp?teacher_no=<%=t.getTeacher_no()%>">����</a></td>
				<td><a href="<%=request.getContextPath()%>/Teacher/deleteTeacher.jsp?teacher_no=<%=t.getTeacher_no()%>">����</a></td>
			</tr>	
<%		
	}
%>
		</table>
		<form action="<%=request.getContextPath()%>/Teacher/teacherList.jsp" method="post">
			<input type="text" name="searchWord">
			<input type="submit" value="�˻�">
		</form>
<%	
	int totalRow = tdao.selectCount();	// ��ü ����
	int lastPage = 0;	// ������������
	
	if(totalRow % rowPerPage == 0){		// �� ���� % ���������� ���� ����
		lastPage = totalRow / rowPerPage ;		
	        // ������������ = �� ���� / ���������� ���� ����
	}else{
		lastPage = totalRow / rowPerPage + 1 ;	
	       // ������������ = �� ���� / ���������� ���� ���� + 1
	}
				
	if(currentPage > 1){
%>
		<a href="<%=request.getContextPath() %>/Teacher/teacherList.jsp?currentPage=<%=currentPage-1 %>">����</a>
<%
	}
	if(currentPage < lastPage){
%>
		<a href="<%=request.getContextPath() %>/Teacher/teacherList.jsp?currentPage=<%=currentPage+1%>">����</a>
<%
	}
%>
	</body>
</html>
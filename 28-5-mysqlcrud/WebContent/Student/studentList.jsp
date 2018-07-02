<!-- 18.7.2 ������ -->
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import = "service.StudentDao" %>
<%@ page import = "java.util.ArrayList" %>
<%@ page import = "service.Student" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
		<title>Insert title here</title>
	</head>
	<body>
		<table>
			<tr>
				<th>��ȣ</th>
				<th>�̸�</th>
				<th>����</th>
			</tr>
<%
	request.setCharacterEncoding("euc-kr");
	
	int currentPage = 1;	// ������ ��ȣ
	int rowPerPage = 1;		// �� �������� ���� ����
			
	if(request.getParameter("currentPage") !=null ){
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
	}
	
	int startRow = (currentPage - 1) * rowPerPage;	// ���۹�ȣ = (��������ȣ-1) * �� �������� ���� ����
			
	StudentDao sdao = new StudentDao();		// StudentDao Ŭ���� ����
	ArrayList<Student> list = sdao.selectStudentByPage(startRow, rowPerPage);	// StudentDao Ŭ���� �� selectStudentByPage�޼��� ȣ��(�Ű����� ���۹�ȣ, ���������� ���°���)
	
	for(int i=0; i<list.size(); i++){
		Student s = list.get(i);
%>
		
			<tr>
				<td><%= s.getStudent_no() %></td>
				<td><%= s.getStudent_name() %></td>
				<td><%= s.getStudent_age() %></td>
			</tr>	
<%		
	}
%>
		</table>
<%	
	int totalRow = sdao.selectCount();	// ��ü ����
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
		<a href="<%=request.getContextPath() %>/Student/studentList.jsp?currentPage=<%=currentPage-1 %>">����</a>
<%
	}
	if(currentPage < lastPage){
%>
		<a href="<%=request.getContextPath() %>/Student/studentList.jsp?currentPage=<%=currentPage+1%>">����</a>
<%
	}
%>
	</body>
</html>
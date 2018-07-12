<!-- 18.7.2 ������ -->
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import = "service.StudentDao" %>
<%@ page import = "java.util.ArrayList" %>
<%@ page import = "service.Student" %>
<%@ page import = "service.StudentScoreDao" %>
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
				<th>�ּҵ��</th>
				<th>�����Է�</th>
				<th>����</th>
				<th>����</th>
			</tr>
<%
	request.setCharacterEncoding("euc-kr");

	String searchWord = "";
	if(request.getParameter("searchWord") != null){
		searchWord = request.getParameter("searchWord");
	}
	
	int currentPage = 1;	// ������ ��ȣ
	int rowPerPage = 3;		// �� �������� ���� ����
			
	if(request.getParameter("currentPage") !=null ){
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
	}
	
	int startRow = (currentPage - 1) * rowPerPage;	// ���۹�ȣ = (��������ȣ-1) * �� �������� ���� ����
			
	StudentDao sdao = new StudentDao();		// StudentDao Ŭ���� ����
	ArrayList<Student> list = sdao.selectStudentByPage(startRow, rowPerPage,searchWord);	// StudentDao Ŭ���� �� selectStudentByPage�޼��� ȣ��(�Ű����� ���۹�ȣ, ���������� ���°���)
	
	StudentScoreDao scdao = new StudentScoreDao();
	for(int i=0; i<list.size(); i++){
		Student s = list.get(i);
		int scoreCheck = scdao.selectStudentScore(s.getStudent_no());
%>
		
			<tr>
				<td><%= s.getStudent_no() %></td>
				<td><a href="<%=request.getContextPath()%>/Student/studentAddrList.jsp?student_no=<%=s.getStudent_no()%>"><%= s.getStudent_name() %></a></td>
				<td><%= s.getStudent_age() %></td>
				<td><a href="<%=request.getContextPath()%>/Student/insertStudentAddrForm.jsp?student_no=<%=s.getStudent_no()%>">�ּҵ��</a></td>
				<td>
					<a href="<%=request.getContextPath()%>/Student/insertScoreForm.jsp?student_no=<%=s.getStudent_no()%>">
<%
		if(scoreCheck == 0){
%>					
					�����Է�
<%
		}else{
%>
					��������
<%
		}
%>
					</a>
				</td>
				<td><a href="<%=request.getContextPath()%>/Student/updateStudentForm.jsp?student_no=<%=s.getStudent_no()%>">����</a></td>
				<td><a href="<%=request.getContextPath()%>/Student/deleteStudent.jsp?student_no=<%=s.getStudent_no()%>">����</a></td>
			</tr>	
<%		
	}
%>
		</table>
		<form action="<%=request.getContextPath()%>/Student/studentList.jsp" method="post">
			<input type="text" name="searchWord">
			<input type="submit" value="�˻�">
		</form>
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
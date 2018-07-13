<!-- 18.7.3 ������ -->
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import = "service.EmployedDao" %>
<%@ page import = "java.util.ArrayList" %>
<%@ page import = "service.Employed" %>
<%@ page import = "service.EmployedScoreDao" %>
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
		<table>
			<tr>
				<th>������ȣ</th>
				<th>�̸�</th>
				<th>����</th>
				<th>�ּҵ��</th>
				<th>�����Է�</th>
				<th>��������</th>
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
			
	EmployedDao edao = new EmployedDao();		// EmployedDao Ŭ���� ����
	ArrayList<Employed> list = edao.selectEmployedByPage(startRow, rowPerPage, searchWord);	// EmployedDao Ŭ���� �� selectEmployedByPage ȣ��(�Ű����� ���۹�ȣ, ���������� ���°���)
	EmployedScoreDao esdao = new EmployedScoreDao();
	for(int i=0; i<list.size(); i++){
		Employed e = list.get(i);
		int scoreCheck = esdao.selectEmployedScore(e.getEmployed_no());
%>
		
			<tr>
				<td><%= e.getEmployed_no() %></td>
				<td><a href="<%=request.getContextPath()%>/Employed/employedAddrList.jsp?employed_no=<%=e.getEmployed_no()%>"><%= e.getEmployed_name() %></a></td>
				<td><%= e.getEmployed_age() %></td>
				<td><a href="<%=request.getContextPath()%>/Employed/insertEmployedAddrForm.jsp?employed_no=<%=e.getEmployed_no()%>">�ּҵ��</a></td>
				<td>
					<a href="<%=request.getContextPath()%>/Employed/insertEmployedScoreForm.jsp?employed_no=<%=e.getEmployed_no()%>">
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
				<td><a href="<%=request.getContextPath()%>/Employed/employedAndScoreList.jsp">��������</a></td>
				<td><a href="<%=request.getContextPath()%>/Employed/updateEmployedForm.jsp?employed_no=<%=e.getEmployed_no()%>">����</a></td>
				<td><a href="<%=request.getContextPath()%>/Employed/deleteEmployed.jsp?employed_no=<%=e.getEmployed_no()%>">����</a></td>				
			</tr>	
<%		
	}
%>
		</table>
		<form action="<%=request.getContextPath()%>/Employed/employedList.jsp" method="post">
			<input type="text" name="searchWord">
			<input type="submit" value="�˻�">
		</form>
<%	
	int totalRow = edao.selectCountEmployed();	// ��ü ����
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
		<a href="<%=request.getContextPath() %>/Employed/employedList.jsp?currentPage=<%=currentPage-1 %>">����</a>
<%
	}
	if(currentPage < lastPage){
%>
		<a href="<%=request.getContextPath() %>/Employed/employedList.jsp?currentPage=<%=currentPage+1%>">����</a>
<%
	}
%>	
	</body>
</html>
<!-- 18.7.3 최지수 -->
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import = "service.EmployedDao" %>
<%@ page import = "java.util.ArrayList" %>
<%@ page import = "service.Employed" %>
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
				<th>번호</th>
				<th>이름</th>
				<th>나이</th>
			</tr>	
<%
	request.setCharacterEncoding("euc-kr");
	
	int currentPage = 1;	// 페이지 번호
	int rowPerPage = 3;		// 한 페이지당 보는 갯수
			
	if(request.getParameter("currentPage") !=null ){
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
	}
	
	int startRow = (currentPage - 1) * rowPerPage;	// 시작번호 = (페이지번호-1) * 한 페이지당 보는 갯수
			
	EmployedDao edao = new EmployedDao();		// EmployedDao 클래스 연결
	ArrayList<Employed> list = edao.selectEmployedByPage(startRow, rowPerPage);	// EmployedDao 클래스 내 selectEmployedByPage 호출(매개변수 시작번호, 한페이지당 보는갯수)
	
	for(int i=0; i<list.size(); i++){
		Employed e = list.get(i);
%>
		
			<tr>
				<td><%= e.getEmployed_no() %></td>
				<td><%= e.getEmployed_name() %></td>
				<td><%= e.getEmployed_age() %></td>
			</tr>	
<%		
	}
%>
		</table>
<%	
	int totalRow = edao.selectCountEmployed();	// 전체 갯수
	int lastPage = 0;	// 마지막페이지
	
	if(totalRow % rowPerPage == 0){		// 총 갯수 % 한페이지당 보는 갯수
		lastPage = totalRow / rowPerPage ;		
	        // 마지막페이지 = 총 갯수 / 한페이지당 보는 갯수
	}else{
		lastPage = totalRow / rowPerPage + 1 ;	
	       // 마지막페이지 = 총 갯수 / 한페이지당 보는 갯수 + 1
	}
				
	if(currentPage > 1){
%>
		<a href="<%=request.getContextPath() %>/Employed/EmployedList.jsp?currentPage=<%=currentPage-1 %>">이전</a>
<%
	}
	if(currentPage < lastPage){
%>
		<a href="<%=request.getContextPath() %>/Employed/EmployedList.jsp?currentPage=<%=currentPage+1%>">다음</a>
<%
	}
%>	
	</body>
</html>
<!-- 이경선 -->
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
		<h1>전체조회</h1>
		<table>
			<tr>
				<th>번호</th>
				<th>이름</th>
				<th>나이</th>
				<th>주소입력</th>
				<th>점수입력</th>
				<th>수정</th>
				<th>삭제</th>
			</tr>
<%
	request.setCharacterEncoding("euc-kr");
	
	String searchword = "";
	if(request.getParameter("searchword") != null){
		searchword = request.getParameter("searchword");
}
	
	int currentPage = 1;	// 페이지 번호
	int rowPerPage = 3;		// 한 페이지당 보는 갯수
			
	if(request.getParameter("currentPage") !=null ){
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
	}
	
	int startRow = (currentPage - 1) * rowPerPage;	// 시작번호 = (페이지번호-1) * 한 페이지당 보는 갯수
			
	TeacherDao tdao = new TeacherDao();		
	ArrayList<Teacher> list = tdao.selectTeacherByPage(startRow, rowPerPage);	
	
	for(int i=0; i<list.size(); i++){
		Teacher t = list.get(i);
%>
		
			<tr>
				<td><%= t.getTeacher_no() %></td>
				<td><a href="<%=request.getContextPath()%>/Teacher/teacherAddrList.jsp?teacher_no=<%=t.getTeacher_no()%>"><%= t.getTeacher_name() %></a></td>
				<td><%= t.getTeacher_age() %></td>
				<td><a href="<%=request.getContextPath()%>/Teacher/insertTeacherAddrForm.jsp?teacher_no=<%=t.getTeacher_no()%>">주소등록</a></td>
				<td><a href="<%=request.getContextPath()%>/Teacher/insertScoreForm.jsp?teacher_no=<%=t.getTeacher_no()%>">점수입력</a></td>
				<td><a href="<%=request.getContextPath()%>/Teacher/updateTeacherForm.jsp?teacher_no=<%=t.getTeacher_no()%>">수정</a></td>
				<td><a href="<%=request.getContextPath()%>/Teacher/deleteTeacher.jsp?teacher_no=<%=t.getTeacher_no()%>">삭제</a></td>
			</tr>	
<%		
	}
%>
		</table>
		<form action="<%=request.getContextPath()%>/Teacher/teacherList.jsp" method="post">
			<input type="text" name="searchWord">
			<input type="submit" value="검색">
		</form>
<%	
	int totalRow = tdao.selectCount();	// 전체 갯수
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
		<a href="<%=request.getContextPath() %>/Teacher/teacherList.jsp?currentPage=<%=currentPage-1 %>">이전</a>
<%
	}
	if(currentPage < lastPage){
%>
		<a href="<%=request.getContextPath() %>/Teacher/teacherList.jsp?currentPage=<%=currentPage+1%>">다음</a>
<%
	}
%>
	</body>
</html>
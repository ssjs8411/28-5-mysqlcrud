<!-- 18.7.2 최지수 -->
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
		<h1>전체조회</h1>
		<table>
			<tr>
				<th>번호</th>
				<th>이름</th>
				<th>나이</th>
				<th>주소등록</th>
				<th>점수입력</th>
				<th>수정</th>
				<th>삭제</th>
			</tr>
<%
	request.setCharacterEncoding("euc-kr");

	String searchWord = "";
	if(request.getParameter("searchWord") != null){
		searchWord = request.getParameter("searchWord");
	}
	
	int currentPage = 1;	// 페이지 번호
	int rowPerPage = 3;		// 한 페이지당 보는 갯수
			
	if(request.getParameter("currentPage") !=null ){
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
	}
	
	int startRow = (currentPage - 1) * rowPerPage;	// 시작번호 = (페이지번호-1) * 한 페이지당 보는 갯수
			
	StudentDao sdao = new StudentDao();		// StudentDao 클래스 연결
	ArrayList<Student> list = sdao.selectStudentByPage(startRow, rowPerPage,searchWord);	// StudentDao 클래스 내 selectStudentByPage메서드 호출(매개변수 시작번호, 한페이지당 보는갯수)
	
	StudentScoreDao scdao = new StudentScoreDao();
	for(int i=0; i<list.size(); i++){
		Student s = list.get(i);
		int scoreCheck = scdao.selectStudentScore(s.getStudent_no());
%>
		
			<tr>
				<td><%= s.getStudent_no() %></td>
				<td><a href="<%=request.getContextPath()%>/Student/studentAddrList.jsp?student_no=<%=s.getStudent_no()%>"><%= s.getStudent_name() %></a></td>
				<td><%= s.getStudent_age() %></td>
				<td><a href="<%=request.getContextPath()%>/Student/insertStudentAddrForm.jsp?student_no=<%=s.getStudent_no()%>">주소등록</a></td>
				<td>
					<a href="<%=request.getContextPath()%>/Student/insertScoreForm.jsp?student_no=<%=s.getStudent_no()%>">
<%
		if(scoreCheck == 0){
%>					
					점수입력
<%
		}else{
%>
					점수수정
<%
		}
%>
					</a>
				</td>
				<td><a href="<%=request.getContextPath()%>/Student/updateStudentForm.jsp?student_no=<%=s.getStudent_no()%>">수정</a></td>
				<td><a href="<%=request.getContextPath()%>/Student/deleteStudent.jsp?student_no=<%=s.getStudent_no()%>">삭제</a></td>
			</tr>	
<%		
	}
%>
		</table>
		<form action="<%=request.getContextPath()%>/Student/studentList.jsp" method="post">
			<input type="text" name="searchWord">
			<input type="submit" value="검색">
		</form>
<%	
	int totalRow = sdao.selectCount();	// 전체 갯수
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
		<a href="<%=request.getContextPath() %>/Student/studentList.jsp?currentPage=<%=currentPage-1 %>">이전</a>
<%
	}
	if(currentPage < lastPage){
%>
		<a href="<%=request.getContextPath() %>/Student/studentList.jsp?currentPage=<%=currentPage+1%>">다음</a>
<%
	}
%>
	</body>
</html>
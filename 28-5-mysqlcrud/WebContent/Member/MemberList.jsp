<!-- 2018-07-02 김소희 -->
<%@ page language="java" contentType="text/html; charset=EUC-KR"  pageEncoding="EUC-KR"%>
<%@ page import = "java.util.ArrayList" %>
<%@ page import = "service.Member" %>
<%@ page import = "service.MemberDao" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
	<body>
		<table>
			<tr>
				<td>번호</td>
				<td>이름</td>
				<td>나이</td>
			</tr>
		
<%
	int currentPage = 1;							// 페이지 번호
	int rowPerPage = 1;								// 한 페이지에 보이는 개수
	
	if(request.getParameter("currentPage") !=null){
		currentPage = Integer.parseInt(request.getParameter("currentPage"));
	}
	
	int startRow = (currentPage - 1 ) * rowPerPage;	// 시작= (현제페이지-1) * 한 페이지에 보이는 개수
	
	MemberDao mdao = new MemberDao();				// mdao객체 생성
	ArrayList<Member> list = mdao.selectStudentByPage(startRow, rowPerPage);
	
	for (int i=0; i<list.size(); i++){				// 배열
		Member m = list.get(i);						// 인덱스로 값을 조회
%>

			<tr>
				<td><%= m.getMember_no() %></td>
				<td><%= m.getMember_name() %></td>
				<td><%= m.getMember_age() %></td>
			</tr>
<%
	}
%>
		</table>
<% 
	int totalRow = mdao.selectCount();				// 총 개수
	int lastPage = 0;								// 마지막 페이지
	
	if(totalRow % rowPerPage == 0) {
		lastPage = totalRow / rowPerPage;			// 마지막 페이지 = 총 개수 나누기 한 페이지에 보이는 개수
		
	}else{
		lastPage = totalRow / rowPerPage + 1;		// 마지막 페이지 = 총 개수 나누기 한 페이지에 보이는 개수 + 1
				
	}
	
	if(currentPage > 1){
%>
		<a href="<%=request.getContextPath()%>/Member/MemberList.jsp?currentPage=<%=currentPage-1%>">이전</a>
<% 		
	}
	if(currentPage < lastPage){
%>
		<a href="<%=request.getContextPath()%>/Member/MemberList.jsp?currentPage=<%=currentPage+1%>">다음</a>
<%
	}
%>		
	

	</body>
</html>
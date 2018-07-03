
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import="java.util.*" %>
<%@ page import="service.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	
	<%	
			
			int currentPage = 1;
			if(request.getParameter("currentPage")!=null) {
				currentPage = Integer.parseInt(request.getParameter("currentPage"));
			}
			
			int rowPerPage = 5;
			int startRow = (currentPage - 1)* rowPerPage;
			TeachterDao teacherDao = new TeachterDao();
			ArrayList<Teachter> teacherList = teacherDao.selectMemberByPage(startRow, rowPerPage);
		%>
			<h2>교사 목록</h2>
			<table border="1">
				<tr>
					<th>번호</th>
					<th>이름</th>
					<th>나이</th>
				</tr>
		<%
				
				for(int i=0;i<teacherList.size();i++){
					Teachter teachter = teacherList.get(i); 
		%>
				<tr>
					<td><%=teachter.getTeachter_no()%></td> 
					<td><%=teachter.getTeachter_name()%></td> 
					<td><%=teachter.getTeachter_age()%></td> 
				</tr>
		<%
				}
		%>
			</table>
		<%
			
			int totalRow = teacherDao.count();
			
			
			int lastPage = (totalRow-1) / rowPerPage;
			
			if((totalRow-1) % rowPerPage != 0) {
				lastPage++;
			}
			
			if(currentPage>1){
				%>
				<a href = "<%=request.getContextPath() %>/Teachter/Teachterlist.jsp?currentPage=<%=currentPage-1%>">◀ 이전</a>
				<%
			}
			if(currentPage<lastPage){
				%>
				<a href = "<%=request.getContextPath() %>/Teachter/Teachterlist.jsp?currentPage=<%=currentPage+1%>">다음 ▶</a>
				<%
			}
		%>
		
</body>
</html>
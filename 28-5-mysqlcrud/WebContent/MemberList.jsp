<%@ page language="java" contentType="text/html; charset=EUC-KR"  pageEncoding="EUC-KR"%>
<%@ page import = "service.Member" %>
<%@ page import = "service.MemberDao" %>
<%@ page import = "java.util.ArrayList" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
	<body>
		<table>
			<tr>
				<td>��ȣ</td>
				<td>�̸�</td>
				<td>����</td>
			</tr>
<%
	int currentPage = 1;		//����������
	int pagePerRow = 1;			//������ �� ���̴� ����
	
	if(request.getParameter("currentPage") !=null ){
		 currentPage = Integer.parseInt(request.getParameter("currentPage"));
	}
	
	int startRow =  (currentPage - 1) * pagePerRow;
	
	MemberDao mdao = new MemberDao();
	ArrayList<Member> list = mdao.selectMemberByPage(startRow, pagePerRow);
	
	for (int i=0; i<list.size(); i++){	//�迭
		Member m = list.get(i);			//�ε����� ���� ��ȸ
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
	int totalRow = mdao.selectCount();
	int lastPage = 0;
	
	if(totalRow % pagePerRow ==0 ){
		lastPage = totalRow / pagePerRow ; 
		
	}else {
		lastPage = totalRow / pagePerRow +1 ;
		
	}
	if(currentPage >1){
%>
	<a href="<%=request.getContextPath()%>/Member/MemberList.jsp?currentPage=<%=currentPage-1%>">����</a>
<%
	}if(currentPage < lastPage){
%>
	<a href="<%=request.getContextPath()%>/Member/MemberList.jsp?currentPage=<%=currentPage+1%>">����</a>
<%
	}
%>		
> 
	</body>
</html>
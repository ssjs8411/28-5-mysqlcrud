<%@ page language="java" contentType="text/html; charset=EUC-KR"  pageEncoding="EUC-KR"%>
<%@ page import = "service.MemberDao" %>
<%@ page import = "service.MemberAddrDao" %>
<!DOCTYPE html>
<%
	request.setCharacterEncoding("euc-kr");

	int member_no = Integer.parseInt(request.getParameter("member_no"));
	
	MemberAddrDao maddrdao = new MemberAddrDao();
	maddrdao.deleteMemberAddr(member_no);
	
	response.sendRedirect(request.getContextPath() + "/Member/MemberList.jsp");
	
%>
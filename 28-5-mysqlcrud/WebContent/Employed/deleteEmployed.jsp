<!-- 18.7.4 ÃÖÁö¼ö -->
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import = "service.EmployedDao" %>
<%@ page import = "service.EmployedAddrDao" %>
<!DOCTYPE html>
<%
	int employed_no = Integer.parseInt(request.getParameter("employed_no"));

	EmployedAddrDao saddrdao = new EmployedAddrDao();
	int check = saddrdao.deleteEmployedAddr(employed_no);
	System.out.println(check);
	
	if(check==1){
		EmployedDao sdao = new EmployedDao();
		sdao.deleteEmployed(employed_no);
	}
	
	response.sendRedirect(request.getContextPath() + "/Employed/EmployedList.jsp");
%>
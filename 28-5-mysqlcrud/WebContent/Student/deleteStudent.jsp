<!-- 18.7.3 ÃÖÁö¼ö -->
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import = "service.StudentDao" %>
<%@ page import = "service.StudentAddrDao" %>
<!DOCTYPE html>
<%
	int student_no = Integer.parseInt(request.getParameter("student_no"));

	StudentAddrDao saddrdao = new StudentAddrDao();
	int check = saddrdao.deleteStudentAddr(student_no);
	System.out.println(check);
	
	if(check==1){
		StudentDao sdao = new StudentDao();
		sdao.deleteStudent(student_no);
	}
	
	response.sendRedirect(request.getContextPath() + "/Student/studentList.jsp");
%>
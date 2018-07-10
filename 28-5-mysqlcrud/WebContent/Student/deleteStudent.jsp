<!-- 18.7.3 ÃÖÁö¼ö -->
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import = "service.StudentDao" %>
<%@ page import = "service.StudentAddrDao" %>
<%@ page import = "service.StudentScoreDao" %>
<!DOCTYPE html>
<%
	int student_no = Integer.parseInt(request.getParameter("student_no"));
	StudentScoreDao scdao = new StudentScoreDao();
	StudentAddrDao saddrdao = new StudentAddrDao();
	int scoreCheck = scdao.deleteStudentScore(student_no);
	int check = saddrdao.deleteStudentAddr(student_no);
	
	
	if(check==1 & scoreCheck==1){
		StudentDao sdao = new StudentDao();
		sdao.deleteStudent(student_no);
	}
	
	response.sendRedirect(request.getContextPath() + "/Student/studentList.jsp");
%>
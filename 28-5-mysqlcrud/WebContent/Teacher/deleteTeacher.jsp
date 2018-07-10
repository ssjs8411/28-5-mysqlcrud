<!-- �̰漱 -->
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import = "service.TeacherDao" %>
<%@ page import = "service.TeacherAddrDao" %>
<!DOCTYPE html>
<%
	int teacher_no = Integer.parseInt(request.getParameter("teacher_no"));

	TeacherAddrDao taddrdao = new TeacherAddrDao();
	int check = taddrdao.deleteTeacherAddr(teacher_no);
	
	
	if(check==1){
		TeacherDao tdao = new TeacherDao();
		tdao.deleteTeacher(teacher_no);
	}
	
	response.sendRedirect(request.getContextPath() + "/Teacher/teacherList.jsp");
%>
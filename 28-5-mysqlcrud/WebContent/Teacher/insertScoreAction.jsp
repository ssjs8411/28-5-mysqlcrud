<!-- �̰漱 -->
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import = "service.TeacherScoreDao"%>
<!DOCTYPE html>
<% request.setCharacterEncoding("euc-kr"); %>
<jsp:useBean id= "ts" class="service.TeacherScore"/>
<jsp:setProperty name="ts" property="*"/>
<%
TeacherScoreDao tsdao = new TeacherScoreDao();
int check = tsdao.updateTeacherScore(ts);

if(check == 0 ){
	tsdao.insertTeacherScore(ts);
}

response.sendRedirect(request.getContextPath() + "/Teacher/teacherList.jsp");
%>
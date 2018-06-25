<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<%@ page import = "service.StudentDao"%>

<%
	request.setCharacterEncoding("euc-kr");
	StudentDao sdao = new StudentDao();
	sdao.insertStudent(s);
%>
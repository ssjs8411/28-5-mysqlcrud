<!-- 18.6.25 ������ -->
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import = "service.StudentDao"%>		<!-- service��Ű������ StudentDaoŬ���� import -->
<!DOCTYPE html>
<% request.setCharacterEncoding("euc-kr"); %>	<!-- �ѱ� �޾ƿ��� -->
<jsp:useBean id="s" class="service.Student"/> 	<!--  service��Ű���� StudentŬ������ �ּҰ��� ����s�� ���� -->
<jsp:setProperty name="s" property="*"/>		<!--  ���� s�� ����ִ� StudentŬ������ �޼��带 ������ŭ ȣ���Ѵ� -->
<%
	StudentDao sdao = new StudentDao();			// StudentDao type���� sdao������ �����ϰ� new�����ڸ޼���� StudentDao��ü �� �ּҰ��� ������ ����
	sdao.insertStudent(s);						// sdao ����ִ� �ּҰ��� ���󰡼� insertStudent�޼��� ȣ��
%>
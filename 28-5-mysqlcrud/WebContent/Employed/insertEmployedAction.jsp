<!-- 18.6.26 ������ -->
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import = "service.EmployedDao"%>			<!-- service��Ű������ EmployedDaoŬ���� import -->
<!DOCTYPE html>
<% request.setCharacterEncoding("euc-kr"); %>		<!-- �ѱ� �޾ƿ��� -->
<jsp:useBean id="emp" class="service.Employed"/> 	<!--  service��Ű���� EmployedŬ������ �ּҰ��� ���� emp�� ���� -->
<jsp:setProperty name="emp" property="*"/>			<!--  ���� emp�� ����ִ� EmployedŬ������ �޼��带 ������ŭ ȣ���Ѵ� -->
<%
EmployedDao edao = new EmployedDao();			// EmployedDao type���� edao������ �����ϰ� new�����ڸ޼���� EmployedDao��ü �� �ּҰ��� ������ ����
	edao.insertEmployed(emp);					// edao ����ִ� �ּҰ��� ���󰡼� insertEmployed�޼��� ȣ��
%>
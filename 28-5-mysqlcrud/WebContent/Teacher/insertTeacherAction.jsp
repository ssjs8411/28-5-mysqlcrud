<!-- �̰漱 -->
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import ="service.TeacherDao"%>
<!DOCTYPE html>
<% request.setCharacterEncoding("euc-kr");%><!-- �ѱ� �������ʰ� -->
<jsp:useBean id="t" class="service.Teacher"/><!-- Teacher�� �ּҰ��� ���� t�� ���� Teacher ��ü ������ �������� ������ set�޼��忡 ���� ����  -->
<jsp:setProperty name="t" property="*"/><!-- t�� ����ִ� �ּҰ��� ���󰡼� �޼ҵ� ������ŭ ��� ȣ��  -->
<% 

TeacherDao tdao = new TeacherDao();
tdao.insertTeacher(t);
%>

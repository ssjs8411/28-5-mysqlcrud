<!-- �̰漱 -->
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import ="service.TeachterDao"%>
<!DOCTYPE html>
<% request.setCharacterEncoding("euc-kr");%><!-- �ѱ� �������ʰ� -->
<jsp:useBean id="t" class="service.Teachter"/><!-- Teachter�� �ּҰ��� ���� t�� ���� Teachter ��ü ������ �������� ������ set�޼��忡 ���� ����  -->
<jsp:setProperty name="t" property="*"/><!-- t�� ����ִ� �ּҰ��� ���󰡼� �޼ҵ� ������ŭ ��� ȣ��  -->
<% 
TeachterDao tdao = new TeachterDao();
tdao.InsertTeachter(t);
%>
<!-- 이경선 -->
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import ="service.TeachterDao"%>
<!DOCTYPE html>
<% request.setCharacterEncoding("euc-kr");%><!-- 한글 깨지지않게 -->
<jsp:useBean id="t" class="service.Teachter"/><!-- Teachter의 주소값을 변수 t에 대입 Teachter 객체 내부의 변수명이 같으면 set메서드에 값을 셋팅  -->
<jsp:setProperty name="t" property="*"/><!-- t에 담겨있는 주소값을 따라가서 메소드 개수만큼 모두 호출  -->
<% 
TeachterDao tdao = new TeachterDao();
tdao.InsertTeachter(t);
%>
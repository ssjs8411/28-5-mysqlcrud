<!-- 2018-07-08 -->
<%@ page language="java" contentType="text/html; charset=EUC-KR"  pageEncoding="EUC-KR"%>
<%@ page import = "service.MemberAddrDao" %>
<!DOCTYPE html>
<% request.setCharacterEncoding("euc-kr"); %>
<jsp:useBean id="maddr" class="service.MemberAddr"/>  <!-- MemberAddrDao�� �ּҰ��� ���� maddr�� ���� MemberAddrDao ��ü ������ �������� ������ set�޼��忡 ���� ����  -->
<jsp:setProperty name="maddr" property="*"/> <!-- maddr�� ����ִ� �ּҰ��� ���󰡼� �޼ҵ� ������ŭ ��� ȣ��  -->
<%
MemberAddrDao maddrDao = new MemberAddrDao();
maddrDao.insertMemberAddr(maddr);

response.sendRedirect(request.getContextPath() + "/Member/MemberList.jsp");
%>

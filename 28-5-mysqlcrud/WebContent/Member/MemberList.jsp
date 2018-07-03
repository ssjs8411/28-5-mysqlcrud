<!-- 2018-07-02 ����� -->
<%@ page language="java" contentType="text/html; charset=EUC-KR"  pageEncoding="EUC-KR"%>
<%@ page import = "java.util.ArrayList" %>
<%@ page import = "service.Member" %>
<%@ page import = "service.MemberDao" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>MemberList</title>
</head>
    <body>
        <table border="1">
            <tr>
                <td>��ȣ</td>
                <td>�̸�</td>
                <td>����</td>
                <td>�ּ��Է�</td>
                <td>����</td>
                <td>����</td>
            </tr>
        
<%
    int currentPage = 1;		// ������ ��ȣ
    int rowPerPage = 3;		// �� �������� ���̴� ����
    
    if(request.getParameter("currentPage") !=null){
        currentPage = Integer.parseInt(request.getParameter("currentPage"));
    }
    
    int startRow = (currentPage - 1 ) * rowPerPage;		// ����= (���� ������-1) * �� �������� ���̴� ����
    
    MemberDao mdao = new MemberDao();		// mdao��ü ����
    ArrayList<Member> list = mdao.selectStudentByPage(startRow, rowPerPage);
    
    for (int i=0; i<list.size(); i++){		// �迭
        Member m = list.get(i);		// �ε����� ���� ��ȸ
%>
 
            <tr>
                <td><%= m.getMember_no() %></td>
                <td><a href="./memberAddrList.jsp?no=?"><%= m.getMember_name() %></a></td> <!-- �̸� Ŭ���ϸ�  -->
                <td><%= m.getMember_age() %></td>
                <td><a href="./insertMemberAddr.jsp?no=?">�ּ��Է�</a></td>
                <td><a href="./deleteMemberAction.jsp?no=?">����</a></td>
                <td><a href="./updateMemberForm.jsp?no=?">����</a></td>
                <!-- updateMemberForm -> updateMemberAction �Ѿ�� -->
            </tr>
<%
    }
%>
        </table>
<% 		
    int totalRow = mdao.selectCount();		// �� ����
    int lastPage = 0;		// ������ ������
    
    if(totalRow % rowPerPage == 0) {
        lastPage = totalRow / rowPerPage;		// ������ ������ = �� ���� ������ �� �������� ���̴� ����
        
    }else{
        lastPage = totalRow / rowPerPage + 1;		// ������ ������ = �� ���� ������ �� �������� ���̴� ���� + 1
                
    }
   
    
    if(currentPage > 1){
%>
        <a href="<%=request.getContextPath()%>/Member/MemberList.jsp?currentPage=<%=currentPage-1%>">����</a>
<%         
    }
    if(currentPage < lastPage){
%>
        <a href="<%=request.getContextPath()%>/Member/MemberList.jsp?currentPage=<%=currentPage+1%>">����</a>
<%
    }
%>        
    
 <!-- 
 
 ���� ���� ��
<form>
 	<div>
 		�̸�:
 		<input type="text" name="searchWord">
 		<button type="button">�˻�</button>
 	</div>
</form>
 
 
  -->
    </body>
</html>
<!-- 2018-07-02 ����� -->
<%@ page language="java" contentType="text/html; charset=EUC-KR"  pageEncoding="EUC-KR"%>
<%@ page import = "java.util.ArrayList" %>			<!-- ArrayList�� java.util.ArrayList�� ���� import -->
<%@ page import = "service.Member" %>				<!-- service��Ű�� �ȿ� MemberŬ���� import-->
<%@ page import = "service.MemberDao" %>			<!-- service��Ű�� �ȿ� MemberDaoŬ���� import-->
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
                <td>�ּ��Է�</td><!-- �ټ� -->
                <td>�����Է�</td>
                <td>����</td>
                <td>����</td>
            </tr>
        
<%
	request.setCharacterEncoding("euc-kr");			//�ѱ� �� ������
	
	String searchWord = "";
	if(request.getParameter("searchWord") != null){
		searchWord = request.getParameter("searchWord");
	}
    int currentPage = 1;		// ������ ��ȣ 1������
    int rowPerPage = 3;			// �� �������� ���̴� ���� 3��
	
    if(request.getParameter("currentPage") !=null){
        currentPage = Integer.parseInt(request.getParameter("currentPage"));
    }
    
    int startRow = (currentPage - 1 ) * rowPerPage;		// ����= (���� ������-1) * �� �������� ���̴� ����
    
    MemberDao mdao = new MemberDao();
 	//MemberDao data type���� mdao ���� �����ϰ�  new������ �޼ҵ��  ������  MemberDao ��ü�� �ּ� ���� mdao ������ �Ҵ��Ѵ�
    ArrayList<Member> list = mdao.selectMemberByPage(startRow, rowPerPage, searchWord);
  	//ArrayList<Member> type���� list ���� ���� startRow,rowPerPage,searchWord ����ִ� �ּ� ���� ���󰡼� selectMemberByPage �޼ҵ� ȣ��
    for(int i=0; i<list.size(); i++){		// �迭
        Member m = list.get(i);				// �ε����� ���� ��ȸ
%>
 
            <tr>
                <td><%= m.getMember_no() %></td>
                <td><a href="<%=request.getContextPath()%>/Member/memberAddrList.jsp?member_no=<%= m.getMember_no() %>"><%= m.getMember_name() %></a></td> <!-- �̸� Ŭ���ϸ�  -->
                <td><%= m.getMember_age() %></td>
                <td><a href="<%=request.getContextPath()%>/Member/insertMemberAddrForm.jsp?member_no=<%= m.getMember_no() %>">�ּ��Է�</a></td>
                <td><a href="<%=request.getContextPath()%>/Member/insertScoreForm.jsp?member_no=<%= m.getMember_no() %>">�����Է�</a></td>
                <td><a href="<%=request.getContextPath()%>/Member/updateMemberForm.jsp?member_no=<%= m.getMember_no() %>">����</a></td>
                <td><a href="<%=request.getContextPath()%>/Member/deleteMember.jsp?member_no=<%= m.getMember_no() %>">����</a></td>
                <!-- updateMemberForm -> updateMemberAction �Ѿ�� -->
            </tr>
<%
    }
%>
        </table>
		<form action="<%=request.getContextPath()%>/Member/MemberList.jsp" method="post">
			<input type="text" name="searchWord">
			<input type="submit" value="�˻�">
        </form>
<% 		
    int totalRow = mdao.selectCount();			// �� ����
    int lastPage = 0;							// ������ ������
    
    if(totalRow % rowPerPage == 0) {
        lastPage = totalRow / rowPerPage;		// ������ ������ = �� ���� ������ �� �������� ���̴� ����
        
    }else{
        lastPage = totalRow / rowPerPage + 1;	// ������ ������ = �� ���� ������ �� �������� ���̴� ���� + 1
                
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
    
 
    </body>
</html>
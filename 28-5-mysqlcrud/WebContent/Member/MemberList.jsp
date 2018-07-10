<!-- 2018-07-02 김소희 -->
<%@ page language="java" contentType="text/html; charset=EUC-KR"  pageEncoding="EUC-KR"%>
<%@ page import = "java.util.ArrayList" %>			<!-- ArrayList는 java.util.ArrayList에 포함 import -->
<%@ page import = "service.Member" %>				<!-- service패키지 안에 Member클래스 import-->
<%@ page import = "service.MemberDao" %>			<!-- service패키지 안에 MemberDao클래스 import-->
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>MemberList</title>
</head>
    <body>
        <table border="1">
            <tr>
                <td>번호</td>
                <td>이름</td>
                <td>나이</td>
                <td>주소입력</td><!-- 다수 -->
                <td>점수입력</td>
                <td>수정</td>
                <td>삭제</td>
            </tr>
        
<%
	request.setCharacterEncoding("euc-kr");			//한글 안 깨지게
	
	String searchWord = "";
	if(request.getParameter("searchWord") != null){
		searchWord = request.getParameter("searchWord");
	}
    int currentPage = 1;		// 페이지 번호 1페이지
    int rowPerPage = 3;			// 한 페이지에 보이는 개수 3개
	
    if(request.getParameter("currentPage") !=null){
        currentPage = Integer.parseInt(request.getParameter("currentPage"));
    }
    
    int startRow = (currentPage - 1 ) * rowPerPage;		// 시작= (현재 페이지-1) * 한 페이지에 보이는 개수
    
    MemberDao mdao = new MemberDao();
 	//MemberDao data type으로 mdao 변수 생성하고  new생성자 메소드로  생성된  MemberDao 객체의 주소 값을 mdao 변수에 할당한다
    ArrayList<Member> list = mdao.selectMemberByPage(startRow, rowPerPage, searchWord);
  	//ArrayList<Member> type으로 list 변수 선언 startRow,rowPerPage,searchWord 담겨있는 주소 값을 따라가서 selectMemberByPage 메소드 호출
    for(int i=0; i<list.size(); i++){		// 배열
        Member m = list.get(i);				// 인덱스로 값을 조회
%>
 
            <tr>
                <td><%= m.getMember_no() %></td>
                <td><a href="<%=request.getContextPath()%>/Member/memberAddrList.jsp?member_no=<%= m.getMember_no() %>"><%= m.getMember_name() %></a></td> <!-- 이름 클릭하면  -->
                <td><%= m.getMember_age() %></td>
                <td><a href="<%=request.getContextPath()%>/Member/insertMemberAddrForm.jsp?member_no=<%= m.getMember_no() %>">주소입력</a></td>
                <td><a href="<%=request.getContextPath()%>/Member/insertScoreForm.jsp?member_no=<%= m.getMember_no() %>">점수입력</a></td>
                <td><a href="<%=request.getContextPath()%>/Member/updateMemberForm.jsp?member_no=<%= m.getMember_no() %>">수정</a></td>
                <td><a href="<%=request.getContextPath()%>/Member/deleteMember.jsp?member_no=<%= m.getMember_no() %>">삭제</a></td>
                <!-- updateMemberForm -> updateMemberAction 넘어가게 -->
            </tr>
<%
    }
%>
        </table>
		<form action="<%=request.getContextPath()%>/Member/MemberList.jsp" method="post">
			<input type="text" name="searchWord">
			<input type="submit" value="검색">
        </form>
<% 		
    int totalRow = mdao.selectCount();			// 총 개수
    int lastPage = 0;							// 마지막 페이지
    
    if(totalRow % rowPerPage == 0) {
        lastPage = totalRow / rowPerPage;		// 마지막 페이지 = 총 개수 나누기 한 페이지에 보이는 개수
        
    }else{
        lastPage = totalRow / rowPerPage + 1;	// 마지막 페이지 = 총 개수 나누기 한 페이지에 보이는 개수 + 1
                
    }
   
    
    if(currentPage > 1){
%>
        <a href="<%=request.getContextPath()%>/Member/MemberList.jsp?currentPage=<%=currentPage-1%>">이전</a>
<%         
    }
    if(currentPage < lastPage){
%>
        <a href="<%=request.getContextPath()%>/Member/MemberList.jsp?currentPage=<%=currentPage+1%>">다음</a>
<%
    }
%>        
    
 
    </body>
</html>
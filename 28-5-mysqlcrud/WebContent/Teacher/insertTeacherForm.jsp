<!-- �̰漱 -->
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
		<title>Insert title here</title>
	</head>
	<body>
	  <form action="<%=request.getContextPath()%>/Teachter/insertTeachterAction.jsp" method="post">
                <table>
                    <tr id="name">
                        <td>�̸�</td>
                        <td><input type="text" name="teachter_name"></td>
                    </tr>
                    <tr id="age">
                        <td>����</td>
                        <td><input type="text" name="teachter_age"></td>
      				</tr>
      			</table>
      			<input type="submit" value="�Է�">
      </form>			
	</body>
</html>
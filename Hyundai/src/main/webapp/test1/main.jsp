<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	/* #container {
	display: inline-block;
	padding:20px;
	border: 1px solid #ddd;
	margin: 0 auto;
	
	}
	 .box1 {
		width:300px;
		margin: 0px auto;
		padding: 20px;
		border: 1px solid #ddd;
	}
	.box2 {
		width:300px;
		margin: 0px auto;
		padding: 20px;
		border: 1px solid #ddd;
		
	} */ 
	div {
	display: inline-block;
	border: 1px solid #ddd;
	padding: 20px;
	margin: 0 auto;
	}
</style>
</head>
<body>

<!-- <div id="#container">-->	
	<div class="box1" >   <!-- style="display: inline-block" -->
	     <form action="result.jsp" method="post">
		   아이디 : <input type="text" name="userID" size=20 /><br><br>
		   비밀번호: <input type="password" name="userPw" size=20 /><br><br>
		   <input  type="submit" value="로그인" /> <input type="reset" value="다시입력"  />
	   </form> 
	</div>
	<div class="box2">
		<!-- request의 getContextPath()이용해 컨텍스트 이름 가져오기-->   
		<button type="button" onclick="location.href='${pageContext.request.contextPath}/test1/MemberForm.jsp'">회원가입하기</button>
		
		<%-- <a href="${pageContext.request.contextPath}/test1/MemberForm.jsp">회원가입하기</a> --%>
	</div>
<!-- </div> -->
</body>
</html>
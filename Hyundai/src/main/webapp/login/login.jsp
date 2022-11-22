<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> --%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"  /> 
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<c:set var="contextPath" value="/Hyundai"> 

<title>로그인</title>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link rel="stylesheet" type="text/css" href="../css/member.min.css">
<link rel="stylesheet" type="text/css" href="../css/common.min.css">
<link href="https://fonts.googleapis.com/css2?family=Nanum+Pen+Script&family=Noto+Sans+KR&display=swap" rel="stylesheet">
<script type="text/javascript" async="" src="https://www.google-analytics.com/analytics.js"></script>
<script type="text/javascript" src="/js/co/GoogleAnalyticsBuilder.js?ver=17"></script>
</head>
<body>


    <div id="wrap" class="member login">
        <div id="contents">
            <div class="innercon">
                <h2>로그인</h2>
                <p class="txt">현대식품관에 오신 것을 환영합니다.</p>
                <form name="memberLoginForm" action="http://localhost/Hyundai/login/login.jsp" method="post">
                    <fieldset class="form-field">
                        <legend class="hide">로그인</legend> <!-- 이거는 꼭 필요한가? -->
                        <ul>
                            <li>
                                <label class="form-entry"><input type="text" id="id" name="id" class="big" title="아이디 입력" placeholder="아이디" value="" onkeydown="javascript:fn.inputMsgClear(#id);">       
                                    <button type="button" class="btn-del" tabindex="-1">삭제</button>
                                </label>
                            </li>
                            <li>
                                <label class="form-entry"><input type="password" id="pwd" name="pwd" class="big" title="비밀번호 입력" placeholder="비밀번호" value="" onkeydown="javascript:fn.inputMsgClear(#pwd);">
                                    <button type="button" class="btn-del" tabindex="-1">삭제</button>
                                </label>
                            </li>
                        </ul>
                        <label class="form-save">
                            <input type="checkbox" id="idSaveYn" name="idSaveYn" class="big" checked="">
                            <span> 
                               
                                아이디저장
                            </span>
                        </label>
                        <ul class="btn-group login-support">
                            <li>
                                <a href="${pageContext.request.contextPath}/login/join.jsp" >회원가입</a>
                            </li>
                            <li><a href="http://localhost/Hyundai/%EB%B9%84%EB%B0%80%EB%B2%88%ED%98%B8%20%EC%B0%BE%EA%B8%B0" >아이디/비밀번호 찾기</a> <!--여기 경로 넣기-->
                            </li>
                        </ul>
                        <button type="button" class="btn fill big black" onclick="javascript:goLogin();">로그인</button>
                    </fieldset>

                </form>
    
            </div>
    
        </div>

    </div>

</c:set>
</body>
</html>
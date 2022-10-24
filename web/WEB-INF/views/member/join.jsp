<%--
  Created by IntelliJ IDEA.
  User: kimminhee
  Date: 21. 2. 22.
  Time: 오전 10:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>member Join Page</title>
    <link rel="stylesheet" href="/css/memberJoin.css">
    <script src="//code.jquery.com/jquery-1.11.0.min.js"></script>
    <script src="/script/memberJoin.js"></script>
</head>
<body>
<div class="wrapper">
    <form action="/member/join"  method="POST" name="memberForm">
        <div class="wrap">
            <div class="subject">
                <spa>회원가입</spa>
            </div>
            <div class="id_wrap">
                <div class="id_name">아이디</div>
                <div class="id_input_box">
                    <input class="id_input" id="id" name="id" placeholder="your id" autocomplete="username" required oninput="checkId()"/>
                    <span class="id_ok">사용 가능한 아이디 입니다.</span>
                    <span class="id_already">이미 사용중인 아이디 입니다.</span>
<%--                    <button class="idCheck" type="button" id="idCheck" onclick="fn_idCheck();">아이디 중복 검사</button>--%>
                </div>
            </div>
            <%--            <div class="join_button_wrap">--%>
            <%--                <button type="button" id="idCheck" name="idCheck" value="N" onclick="fn_idCheck()">중복</button>--%>
            <%--            </div>--%>
            <div class="password_wrap">
                <div class="password_name">비밀번호</div>
                <div class="password_input_box">
                    <input class="password_input" id="password" name="password">
                </div>
            </div>
            <div class="passwordCheck_wrap">
                <div class="passwordCheck_name">비밀번호 확인</div>
                <div class="passwordCheck_input_box">
                    <input class="passwordCheck_input" id="passwordCheck" name="passwordCheck">
                </div>
            </div>
            <div class="user_wrap">
                <div class="user_name">이름</div>
                <div class="user_input_box">
                    <input class="user_input" id="name" name="name">
                </div>
            </div>
            <div class="address_wrap">
                <div class="address_name">주소</div>
                <div class="address_input_box">
                    <input class="address_input" id="address" name="address">
                </div>
            </div>
            <div class="phoneNumber_wrap">
                <div class="phoneNumber_name">휴대폰번호</div>
                <div class="phoneNumber_input_box">
                    <input class="phoneNumber_input" id="phoneNumber" name="phoneNumber">
                </div>
            </div>
            <div class="email_wrap">
                <div class="email_name">이메일</div>
                <div class="email_input_box">
                    <input class="email_input" id="email" name="email">
                </div>
            </div>
            <div class="gender_wrap">
                <div class="gender_name">성별</div>
                <input type="radio"  name="gender" value="M" checked="checked">남
                <input type="radio"   name="gender" value="F">여
            </div>
        </div>
        <div class="join_button_wrap">
        <button type="button" class="join_button" id="join" onclick=" return checkAll()">가입하기</button>
        </div>
    </form>
</div>
</body>
</html>


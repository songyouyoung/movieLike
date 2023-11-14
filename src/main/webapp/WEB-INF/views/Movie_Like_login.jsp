<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
    <link rel="stylesheet" href="./css/common.css">
    <link rel="stylesheet" href="./css/header.css">
    <link rel="stylesheet" href="./css/login_page.css">
</head>
<body>
    <div id="wrap">
        <header class="header">
            <div class="logo"><a href="#"><img src="./img/logo.png" alt="로고 이미지"></a></div>
            <div class="h_left left_50"><a href="">영화 전체보기</a></div>
            <div class="h_left"><a href="./Movie_Like_find.html">차트</a></div>
            <div class="h_left"><a href="">키워드 찾기</a></div>
            <div class="h_right">
                <div class="login"><a href="">로그인</a></div>
                <div class="line"></div>
                <div class="join"><a href="">회원가입</a></div>
            </div>
        </header>

        <main class="container">
            <form action="" class="login_form">
                <div class="title">LOGIN</div>
                <input type="text" class="login_input" placeholder="아이디(이메일)을 입력하세요.">
                <input type="text" class="login_input" placeholder="비밀번호를 입력하세요">
                <input type="button" class="login_input" value="로그인">
                <hr>
                <div class="remember_id">아이디 기억하기</div>
                <div class="id_search_box">
                    <div class="id_search">아이디 찾기</div>
                    <div class="h_line"></div>
                    <div class="id_search">비밀번호 찾기</div>
                    <div class="h_line"></div>
                    <div class="id_search"><a href="./Movie_Like_join.html">회원가입</a></div>
                </div>
            </form>
        </main>

        <footer class="footer">
            <div class="name">Project Name: Movie Like</div>
        </footer>
    </div>
</body>
</html>
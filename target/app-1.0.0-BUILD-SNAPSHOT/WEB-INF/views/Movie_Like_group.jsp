<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Movie Like</title>
    <link rel="icon" href="<c:url value='/img/favicon.ico'/>">
    <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
    <link rel="stylesheet" href="<c:url value='/css/common.css'/> ">
    <link rel="stylesheet" href="<c:url value='/css/header.css'/> ">
    <link rel="stylesheet" href="<c:url value='/css/group_page.css'/> ">
</head>
<body>
    <div id="wrap">
        <header class="header">
            <div class="logo"><a href="<c:url value='/'/>"><img src="<c:url value='/img/logo.png'/>" alt="로고 이미지"></a></div>
            <div class="h_left left_50"><a href="<c:url value='/list/all'/>">영화 전체보기</a></div>
            <div class="h_left"><a href="./Movie_Like_find.html">차트</a></div>
            <div class="h_left"><a href="<c:url value='/find/keyword'/>">키워드 찾기</a></div>
            <div class="h_right">
                <div class="login"><a href="">로그인</a></div>
                <div class="line"></div>
                <div class="join"><a href="">회원가입</a></div>
            </div>
        </header>
        <main class="container">
            <div class="title_box">
                <div class="group_title">장르명(로맨스)${search}</div>
                <select class="select_r">
                    <option value="latest" selected>최신순</option>
                    <option value="popularity">인기순</option>
                </select>
            </div>
            <div class="content_box">
                
            </div>
        </main>
    </div>
    <script>
        var s_title = "${param.title}";
        var s_val = "${param.val}";
    </script>
    <script src="<c:url value='/js/group_item.js'/>"></script>
</body>
</html>
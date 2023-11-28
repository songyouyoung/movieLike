<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session = "false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:set var="sessionId" value="${ pageContext.request.getSession(false).getAttribute('liogdin')!=null? pageContext.request.getSession(false).getAttribute('liogdin'):null}" />
<head>
    <meta charset="UTF-8">
    <title>Movie Like</title>
    <link rel="stylesheet" href="<c:url value='/css/common.css'/> ">
    <link rel="stylesheet" href="<c:url value='/css/header.css'/> ">
</head>
<header class="header">
    <div class="main_logo"><a href="<c:url value='/'/>"><img src="<c:url value='/img/logo.png'/>" alt="MovieLike"></a></div>
    <div class="h_left">
        <div><a href="<c:url value='/list/chart?title=all'/>">영화 전체보기</a></div>
        <div><a href="<c:url value='/find/chart'/>">차트</a></div>
        <div><a href="<c:url value='/find/keyword'/>">키워드 찾기</a></div>
    </div>
    <div class="h_right">
        <div class="login"><a href="./Movie_Like_login.html">로그인</a></div>
        <div class="line"></div>
        <div class="join"><a href="./Movie_Like_join.html">회원가입</a></div>
    </div>
</header>

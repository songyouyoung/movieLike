<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

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
    <link rel="stylesheet" href="<c:url value='/css/list_page.css'/> ">
</head>
<body>
    <div id="wrap">
        <header class="header">
            <div class="main_logo"><a href="<c:url value='/'/>"><img src="<c:url value='/img/logo.png'/>" alt="movieLike"></a></div>
            <div class="h_left">
                <div><a href="<c:url value='/list/chart?title=all'/>">영화 전체보기</a></div>
                <div><a href="./Movie_Like_find.html">차트</a></div>
                <div><a href="<c:url value='/find/keyword'/>">키워드 찾기</a></div>
            </div>
            <div class="h_right">
                <div class="login"><a href="">로그인</a></div>
                <div class="line"></div>
                <div class="join"><a href="">회원가입</a></div>
            </div>
        </header>
        <main class="container">
            <div class="title_box"></div>
            <div class="content_box">
                <c:forEach var="movie" items="${movieList}">
                    <div class="content" data-movId="${movie.movId}">
                        <div class="poster"><img src="<c:url value='https://image.tmdb.org/t/p/w500/${movie.movPoster}'/>" alt="${movie.movName}"></div>
                        <div class="movie_name">${movie.movName}</div>
                            <fmt:formatDate var="year" value="${movie.movDate}" pattern="yyyy"/>
                            <div class="movie_year">${year}</div>
                        <div class="avg_box">
                            <div class="star_icon"><img src="<c:url value='/img/star.png'/>" alt="★"></div>
                            <div class="movie_avg">${movie.movScore}</div>
                            <div class="movie_avg_cnt">( <fmt:formatNumber value="${movie.movScoreCnt}" pattern="#,###"/> )</div>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </main>
        <footer class="footer">
            <div class="footer_content">
                <div class="f_box">
                    <div class="f_logo"><img src="<c:url value='/img/logo.png'/>" alt="movieLike"></div>
                    <div class="f_txt1">© 2023 by ML, Inc. All rights reserved.</div>
                </div>
                <div class="f_box">
                    <div>Project Name: Movie Like</div>
                    <div class="name">
                        <div>Team: 문수빈</div>
                        <div class="f_line"></div>
                        <div>김주영</div>
                        <div class="f_line"></div>
                        <div>송유영</div>
                        <div class="f_line"></div>
                        <div>전은서</div>
                        <div class="f_line"></div>
                        <div>박정선</div>
                    </div>
                </div>
            </div>
        </footer>
    </div>
    <script>
        var s_title = "${param.title}";
        var s_val = "${param.val}";
        var s_valName = "${param.valName}";
        var movieLength = ${fn:length(movieList)};
    </script>
    <script src="<c:url value='/js/list_item.js'/>"></script>
</body>
</html>
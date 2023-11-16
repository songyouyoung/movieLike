<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Movie Like</title>
    <link rel="icon" href="./img/favicon.ico">
    <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
    <link rel="stylesheet" href="<c:url value='/css/common.css'/> ">
    <link rel="stylesheet" href="<c:url value='/css/header.css'/> ">
    <link rel="stylesheet" href="<c:url value='/css/keyword_page.css'/> ">
</head>
<body>
    <div id="wrap">
        <header class="header">
            <div class="logo"><a href="/"><img src="<c:url value='/img/logo.png'/>" alt="로고 이미지"></a></div>
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
            <div class="m_head">취향 <span class="m_headKey">#키워드</span> 골라보기</div>

            <table class="m_table">
                <tr class="m_tr">
                    <th class="m_th">장르</th>
                    <td class="m_td">
                        <div class="m_tdList">
                            <span class="m_tdItem">액션</span>
                            <span class="m_tdItem">로맨스</span>
                            <span class="m_tdItem">코미디</span>
                            <span class="m_tdItem">스릴러</span>
                        </div>
                    </td>
                </tr>
                <tr class="m_tr">
                    <th class="m_th">OTT</th>
                    <td class="m_td">
                        <div class="m_tdList">
                            <span class="m_tdItem">넷플릭스</span>
                            <span class="m_tdItem">왓챠</span>
                            <span class="m_tdItem">디즈니+</span>
                            <span class="m_tdItem">티빙</span>
                            <span class="m_tdItem">쿠팡플레이</span>
                            <span class="m_tdItem">웨이브</span>
                        </div>
                    </td>
                </tr>
                <tr class="m_tr">
                    <th class="m_th">리뷰수</th>
                    <td class="m_td">
                        <div class="m_tdList">
                            <span class="m_tdItem">리뷰 500개 이상</span>
                            <span class="m_tdItem">리뷰 400개 이상</span>
                            <span class="m_tdItem">리뷰 300개 이상</span>
                        </div>
                    </td>
                </tr>
                <tr class="m_tr">
                    <th class="m_th">평점</th>
                    <td class="m_td">
                        <div class="m_tdList">
                            <span class="m_tdItem">5점이상</span>
                            <span class="m_tdItem">4점이상</span>
                            <span class="m_tdItem">3점이상</span>
                        </div>
                    </td>
                </tr>
            </table>

            <div class="m_tagBox">
                <!-- chk:: javascript에서 값 불러올 예정 -->
                <!-- <div class="m_tagList"><span class="m_tagItem"></span></div> -->
                <div class="m_tagList"><span class="m_tagItem" data-key="genr/액션">#액션</span><span class="m_tagItem" data-key="review/500">#리뷰 500개 이상</span></div>
            </div>
            
            <div class="m_mvBox">
                <!-- chk:: javascript에서 값 불러올 예정 -->
                
                
                
            </div>
            
        </main>
    </div>
    <script src="<c:url value='/js/keyword.js'/> "></script>
</body>
</html>
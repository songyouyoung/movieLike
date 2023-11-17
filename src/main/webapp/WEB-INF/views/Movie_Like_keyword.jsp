<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>

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

    <main class="container" onselectstart="return false">
        <div class="m_head">취향 <span class="m_headKey">#키워드</span> 골라보기</div>
        <!-- <div class="m_tagList"><span class="m_tagItem" data-key="genr/액션">#액션</span></div> -->

        <!-- 장르 선택 -->
        <input type="checkbox" id="adventure_chk">
        <input type="checkbox" id="fantasy_chk">
        <input type="checkbox" id="animation_chk">
        <input type="checkbox" id="drama_chk">
        <input type="checkbox" id="horror_chk">
        <input type="checkbox" id="action_chk">
        <input type="checkbox" id="comedy_chk">
        <input type="checkbox" id="history_chk">
        <input type="checkbox" id="western_chk">
        <input type="checkbox" id="thriller_chk">
        <input type="checkbox" id="crime_chk">
        <input type="checkbox" id="documentary_chk">
        <input type="checkbox" id="sf_chk">
        <input type="checkbox" id="mystery_chk">
        <input type="checkbox" id="music_chk">
        <input type="checkbox" id="romance_chk">
        <input type="checkbox" id="family_chk">
        <input type="checkbox" id="war_chk">

        <!-- OTT 선택 -->
        <input type="checkbox" id="netflex_chk">
        <input type="checkbox" id="watcha_chk">
        <input type="checkbox" id="disnep_chk">
        <input type="checkbox" id="wavve_chk">
        <input type="checkbox" id="appletv_chk">
        <input type="checkbox" id="naverseries_chk">
        <input type="checkbox" id="googleplay_chk">

        <!-- 리뷰 선택 -->
        <input type="radio" name="review_rd" id="review_500_chk">
        <input type="radio" name="review_rd" id="review_400_chk">
        <input type="radio" name="review_rd" id="review_300_chk">

        <!-- 평점 선택 -->
        <input type="radio" name="score_rd" id="score5_chk">
        <input type="radio" name="score_rd" id="score4_chk">
        <input type="radio" name="score_rd" id="score3_chk">

        <table class="m_table">
            <tr class="m_tr">
                <th class="m_th">장르</th>
                <td class="m_td">
                    <div class="m_tdList genre_list">
                        <label for="adventure_chk"><span class="m_tdItem">모험</span></label>
                        <label for="fantasy_chk"><span class="m_tdItem">판타지</span></label>
                        <label for="animation_chk"><span class="m_tdItem">애니메이션</span></label>
                        <label for="drama_chk"><span class="m_tdItem">드라마</span></label>
                        <label for="horror_chk"><span class="m_tdItem">공포</span></label>
                        <label for="action_chk"><span class="m_tdItem">액션</span></label>
                        <label for="comedy_chk"><span class="m_tdItem">코미디</span></label>
                        <label for="history_chk"><span class="m_tdItem">역사</span></label>
                        <label for="western_chk"><span class="m_tdItem">서부</span></label>
                        <label for="thriller_chk"><span class="m_tdItem">스릴러</span></label>
                        <label for="crime_chk"><span class="m_tdItem">범죄</span></label>
                        <label for="documentary_chk"><span class="m_tdItem">다큐멘터리</span></label>
                        <label for="sf_chk"><span class="m_tdItem">SF</span></label>
                        <label for="mystery_chk"><span class="m_tdItem">미스터리</span></label>
                        <label for="music_chk"><span class="m_tdItem">음악</span></label>
                        <label for="romance_chk"><span class="m_tdItem">로맨스</span></label>
                        <label for="family_chk"><span class="m_tdItem">가족</span></label>
                        <label for="war_chk"><span class="m_tdItem">전쟁</span></label>
                    </div>
                </td>
            </tr>
            <tr class="m_tr">
                <th class="m_th">OTT</th>
                <td class="m_td">
                    <div class="m_tdList">
                        <label for="netflex_chk"><span class="m_tdItem">넷플릭스</span></label>
                        <label for="watcha_chk"><span class="m_tdItem">왓챠</span></label>
                        <label for="disnep_chk"><span class="m_tdItem">디즈니+</span></label>
                        <label for="wavve_chk"><span class="m_tdItem">웨이브</span></label>
                        <label for="appletv_chk"><span class="m_tdItem">Apple TV+</span></label>
                        <label for="naverseries_chk"><span class="m_tdItem">네이버 시리즈온</span></label>
                        <label for="googleplay_chk"><span class="m_tdItem">Google Play Movies</span></label>
                    </div>
                </td>
            </tr>
            <tr class="m_tr">
                <th class="m_th">리뷰수</th>
                <td class="m_td">
                    <div class="m_tdList">
                        <label for="review_500_chk"><span class="m_tdItem">리뷰 500개 이상</span></label>
                        <label for="review_400_chk"><span class="m_tdItem">리뷰 400개
                                <label for="review_300_chk"></label>이상</span></label>
                        <label for="review_300_chk"><span class="m_tdItem">리뷰 300개 이상</span></label>
                    </div>
                </td>
            </tr>
            <tr class="m_tr">
                <th class="m_th">평점</th>
                <td class="m_td">
                    <div class="m_tdList">
                        <label for="score5_chk"><span class="m_tdItem">5점이상</span></label>
                        <label for="score4_chk"><span class="m_tdItem">4점이상</span></label>
                        <label for="score3_chk"><span class="m_tdItem">3점이상</span></label>
                    </div>
                </td>
            </tr>
        </table>

        <div class="m_tagBox">
            <!-- chk:: javascript에서 값 불러올 예정 -->
            <!-- <div class="m_tagList"><span class="m_tagItem"></span></div> -->
            <div class="m_tagList">
                <!-- 장르 check -->
                <label for="adventure_chk"><span class="m_tagItem" id="adventure">#모험</span></label>
                <label for="fantasy_chk"><span class="m_tagItem" id="fantasy">#판타지</span></label>
                <label for="animation_chk"><span class="m_tagItem" id="animation">#애니메이션</span></label>
                <label for="drama_chk"><span class="m_tagItem" id="drama">#드라마</span></label>
                <label for="horror_chk"><span class="m_tagItem" id="horror">#공포</span></label>
                <label for="action_chk"><span class="m_tagItem" id="action">#액션</span></label>
                <label for="comedy_chk"><span class="m_tagItem" id="comedy">#코미디</span></label>
                <label for="history_chk"><span class="m_tagItem" id="history">#역사</span></label>
                <label for="western_chk"><span class="m_tagItem" id="western">#서부</span></label>
                <label for="thriller_chk"><span class="m_tagItem" id="thriller">#스릴러</span></label>
                <label for="crime_chk"><span class="m_tagItem" id="crime">#범죄</span></label>
                <label for="documentary_chk"><span class="m_tagItem" id="documentary">#다큐멘터리</span></label>
                <label for="sf_chk"><span class="m_tagItem" id="sf">#SF</span></label>
                <label for="mystery_chk"><span class="m_tagItem" id="mystery">#미스터리</span></label>
                <label for="music_chk"><span class="m_tagItem" id="music">#음악</span></label>
                <label for="romance_chk"><span class="m_tagItem" id="romance">#로맨스</span></label>
                <label for="family_chk"><span class="m_tagItem" id="family">#가족</span></label>
                <label for="war_chk"><span class="m_tagItem" id="war">#전쟁</span></label>

                <!-- OTT check -->
                <label for="netflex_chk"><span class="m_tagItem" id="netflex">#넷플릭스</span></label>
                <label for="watcha_chk"><span class="m_tagItem" id="watcha">#왓챠</span></label>
                <label for="disnep_chk"><span class="m_tagItem" id="disnep">#디즈니+</span></label>
                <label for="wavve_chk"><span class="m_tagItem" id="wavve">#웨이브</span></label>
                <label for="appletv_chk"><span class="m_tagItem" id="appletv">#Apple TV+</span></label>
                <label for="naverseries_chk"><span class="m_tagItem" id="naverseries">#네이버 시리즈온</span></label>
                <label for="googleplay_chk"><span class="m_tagItem" id="googleplay">#Google Play Movies</span></label>

                <!-- 리뷰 check -->
                <label for="review_500_chk"><span class="m_tagItem" id="review_500">리뷰 500개 이상</span></label>
                <label for="review_400_chk"><span class="m_tagItem" id="review_400">리뷰 400개 이상</span></label>
                <label for="review_300_chk"><span class="m_tagItem" id="review_300">리뷰 300개 이상</span></label>

                <!-- 평점 check -->
                <label for="score5_chk"><span class="m_tagItem" id="score5">평점 5개 이상</span></label>
                <label for="score4_chk"><span class="m_tagItem" id="score4">평점 4개 이상</span></label>
                <label for="score3_chk"><span class="m_tagItem" id="score3">평점 300개 이상</span></label>
                <span class="m_tagItem">#평점 5개 이상</span>
            </div>
        </div>

        <div class="m_mvBox">
            <!-- chk:: javascript에서 값 불러올 예정 -->
            <div class="nodata_txt">키워드를 골라 원하는 영화를 찾아보세요</div>



        </div>

    </main>
</div>
<script src="<c:url value='/js/keyword.js'/> "></script>
</body>
</html>
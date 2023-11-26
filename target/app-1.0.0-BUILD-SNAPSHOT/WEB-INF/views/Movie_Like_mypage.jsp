<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
    <link rel="stylesheet" href="<c:url value='/css/join_page.css'/> ">
    <link rel="stylesheet" href="<c:url value='/css/my_page.css'/> ">


    <script src="https://cdn.jsdelivr.net/npm/sweetalert2@10"></script>
</head>
<body>
    <div id="wrap">
        <header class="header">
            <div class="main_logo"><a href="<c:url value='/' />"><img src="<c:url value='/img/logo.png'/>" alt="로고 이미지"></a></div>
            <div class="h_left">
                <div><a href="<c:url value='/list/chart?title=all'/>">영화 전체보기</a></div>
                <div><a href="<c:url value='/find/chart'/>">차트</a></div>
                <div><a href="<c:url value='/find/keyword'/>">키워드 찾기</a></div>
            </div>
            <div class="h_right">
                <div class="login"><a href="">로그인</a></div>
                <div class="line"></div>
                <div class="join"><a href="">회원가입</a></div>
            </div>
        </header>
        <main class="container">
            <div class="content">
                <div class="my_genre">
                    <c:forEach var="genre" items="${genre_list}">
                        <input type="button" class="genre" value="#${genre.genrName}" onclick="genreClick(${genre.genrId})">
                    </c:forEach>
                </div>
                <div class="nickname_txt">닉네임</div>
                <div class="user_id">아이디(이메일)</div>
                <div class="update_icon">
                    <img src="./img/set.png" alt="" class="icon_hover">
                    <div class="update_hover_box">
                        <div class="my_change_btn" onclick="updateCheck()">개인정보변경</div>
                        <div id="popup" class="popup">
                          <div class="popup_content">
                            <div class="title">회원정보수정</div>
                            <table>
                                <tr>
                                    <th class="th1">아이디</th>
                                    <th>
                                        <input type="email" class="login_input" id="email" name="email" placeholder="이메일 형식으로 입력해주세요" readonly value="aaa@naver.com">
                                    </th>
                                </tr>
                                <tr>
                                    <th class="th1">비밀번호</th>
                                    <th>
                                        <input type="password" name="password" id="password" class="login_input" minlength="6" placeholder="비밀번호 - 6자 이상">
                                    </th>
                                </tr>
                                <tr>
                                    <th class="th1">비밀번호 확인</th>
                                    <th>
                                        <input type="password" name="password_chk" id="password_chk" class="login_input" placeholder="비밀번호 - 6자 이상">
                                    </th>
                                </tr>
                                <tr>
                                    <th class="th1">이름</th>
                                    <th><input type="text" name="name" class="login_input"></th>
                                </tr>
                                <tr>
                                    <th class="th1">생년월일</th>
                                    <th>
                                        <select class="birthday" name="birth_year" id="birth_year">
                                            <option selected>연도</option>
                                        </select>
                                        <select class="birthday" name="birth_month" id="birth_month">
                                            <option value="월" selected disabled>월</option>
                                        </select>
                                        <select class="birthday" name="birth_date" id="birth_date">
                                            <option value="일" selected>일</option>
                                        </select>
                                    </th>
                                </tr>
                                <tr>
                                    <th class="th1">전화번호</th>
                                    <th>
                                        <input type="text" name="phone" class="phone_input" maxlength="3"  oninput="this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\..*)\./g, '$1');">
                                        <input type="text" class="phone_input" maxlength="4" oninput="this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\..*)\./g, '$1');">
                                        <input type="text" class="phone_input" maxlength="4" oninput="this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\..*)\./g, '$1');">
                                    </th>
                                </tr>
                                <tr>
                                    <th class="th1">닉네임</th>
                                    <th><input type="text" name="nickname" class="login_input"></th>
                                </tr>
                                <tr>
                                    <th class="th1">나의 영화 취향<br>(선택)</th>
                                    <th>
                                        <input type="checkbox" id="genre1" class="genre_checkbox">
                                        <span class="genre_label_chk"><label for="genre1"><span class="genre">로맨스</span></label></span>
                                        <input type="checkbox" id="genre2" class="genre_checkbox">
                                        <span class="genre_label_chk"><label for="genre2"><span class="genre">액션</span></label></span>
                                        <input type="checkbox" id="genre3" class="genre_checkbox">
                                        <span class="genre_label_chk"><label for="genre3"><span class="genre">애니메이션</span></label></span>
                                        <input type="checkbox" id="genre4" class="genre_checkbox">
                                        <span class="genre_label_chk"><label for="genre4"><span class="genre">공포</span></label></span>
                                        <input type="checkbox" id="genre5" class="genre_checkbox">
                                        <span class="genre_label_chk"><label for="genre5"><span class="genre">코미디</span></label></span>
                                        <input type="checkbox" id="genre6" class="genre_checkbox">
                                        <span class="genre_label_chk"><label for="genre6"><span class="genre">판타지</span></label></span>
                                        <input type="checkbox" id="genre7" class="genre_checkbox">
                                        <span class="genre_label_chk"><label for="genre7"><span class="genre">모험</span></label></span>
                                        <input type="checkbox" id="genre8" class="genre_checkbox">
                                        <span class="genre_label_chk"><label for="genre8"><span class="genre">미스터리</span></label></span>
                                        <input type="checkbox" id="genre9" class="genre_checkbox">
                                        <span class="genre_label_chk"><label for="genre9"><span class="genre">스릴러</span></label></span>
                                        <input type="checkbox" id="genre10" class="genre_checkbox">
                                        <span class="genre_label_chk"><label for="genre10"><span class="genre">드라마</span></label></span>
                                        <input type="checkbox" id="genre11" class="genre_checkbox">
                                        <span class="genre_label_chk"><label for="genre11"><span class="genre">다큐멘터리</span></label></span>
                                        <input type="checkbox" id="genre12" class="genre_checkbox">
                                        <span class="genre_label_chk"><label for="genre12"><span class="genre">서부</span></label></span>
                                        <input type="checkbox" id="genre13" class="genre_checkbox">
                                        <span class="genre_label_chk"><label for="genre13"><span class="genre">SF</span></label></span>
                                        <input type="checkbox" id="genre14" class="genre_checkbox">
                                        <span class="genre_label_chk"><label for="genre14"><span class="genre">범죄</span></label></span>
                                        <input type="checkbox" id="genre15" class="genre_checkbox">
                                        <span class="genre_label_chk"><label for="genre15"><span class="genre">역사</span></label></span>
                                        <input type="checkbox" id="genre16" class="genre_checkbox">
                                        <span class="genre_label_chk"><label for="genre16"><span class="genre">음악</span></label></span>
                                        <input type="checkbox" id="genre17" class="genre_checkbox">
                                        <span class="genre_label_chk"><label for="genre17"><span class="genre">가족</span></label></span>
                                        <input type="checkbox" id="genre18" class="genre_checkbox">
                                        <span class="genre_label_chk"><label for="genre18"><span class="genre">전쟁</span></label></span>
                                        <input type="checkbox" id="genre19" class="genre_checkbox">
                                        <span class="genre_label_chk"><label for="genre19"><span class="genre">TV 영화</span></label></span>
                                    </th>
                                </tr>


                                <tr>
                                    <th colspan="2">
                                      <input type="button" class="user_update_btn" value="수정" onclick="updatePopup()">
                                      <input type="button" class="user_update_btn" value="취소" onclick="closePopup()">
                                    </th>
                                </tr>
                            </table>
                          </div>
                        </div>
                        <div class="my_end_btn" onclick="unregister()">회원탈퇴</div>
                    </div>
                </div>
                <div class="btn_box">
                    <div class="btn_each_box btn_myreview">
                        <a href="#my_review">
                            <div class="my_review_cnt">${reviews_count}</div>
                            <div class="my_txt">리뷰</div>
                        </a>
                    </div>
                    <div class="btn_each_box">
                        <a href="#" onClick="moveList('myView', ${watched_count})">
                            <div class="my_watched_cnt">${watched_count}</div>
                            <div class="my_txt">봤어요</div>
                        </a>
                    </div>
                    <div class="btn_each_box">
                        <a href="#" onClick="moveList('myLike', ${list_count})">
                            <div class="my_like_cnt">${list_count}</div>
                            <div class="my_txt">찜</div>
                        </a>
                    </div>
                </div>

                <div class="chart_box">
                    <div class="chart_title">나의 평점 차트</div>
                    <canvas id="myChart"></canvas>
                </div>

                <div class="review_box" id="my_review">
                    <div class="myreview_title_txt">내가 쓴 리뷰</div>
                    <select class="select_r" onchange="changeOrder(this)">
                        <option value="new" ${orderType == 'new' ? 'selected' : ''}>최신순</option>
                        <option value="like" ${orderType == 'like' ? 'selected' : ''}>좋아요순</option>
                    </select>
                    <div class="my_review_list">
                        <c:forEach var="data" items="${review_list}">
                            <div class="review_list_box">
                                <div class="list_line"></div>
                                <div class="review_title_box">
                                    <div class="review_movie_name">
                                        ${data.movName}</div>
                                    <div class="write_date"><fmt:formatDate value="${data.rvRegDate}" pattern="yyyy-MM-dd" /></div>
                                </div>
                                <textarea rows="1" class="review_content" readonly onchange="handleResizeHeight()">
                                        ${data.rvContent}
                                </textarea>
                                <div class="star_icon1"><img src="./img/star.png" alt=""></div>
                                <div class="movie_avg1">${data.rvScore}</div>
                                <div class="like_box">
                                    <div class="like_icon"><img src="./img/heart_cnt.png" alt=""></div>
                                    <div class="like_cnt">${data.rvLike}</div>
                                </div>
                                <div class="update_box">
                                    <div class="update_btn review_update">수정</div>
                                    <div class="update_btn" onclick="content_delete()">삭제</div>
                                </div>
                            </div>
                        </c:forEach>

                        <div class="page_box">
                            <c:if test="${currentPage > 1}">
                                <div class="prev_btn"><a href="?page=${currentPage - 1}&pageSize=${pageSize}&orderType=${orderType}">&lt;</a></div>
                            </c:if>

                            <c:forEach var="i"
                                       begin="${startPage}"
                                       end="${(startPage + 9<= totalPages) ? (startPage + 9) : totalPages}"
                                       step="1">
                                <c:if test="${i <= totalPages}">
                                    <div class="num">
                                        <a href="?page=${i}&pageSize=${pageSize}&orderType=${orderType}"
                                           style="${i eq currentPage ? 'color: red;' : ''}">
                                                ${i}
                                        </a>
                                    </div>
                                </c:if>
                            </c:forEach>

                            <c:if test="${currentPage < totalPages}">
                                <div class="next_btn"><a href="?page=${currentPage + 1}&pageSize=${pageSize}&orderType=${orderType}">&gt;</a></div>
                            </c:if>
                        </div>


                    </div>
                </div>
            </div>
            <div class="img_box"><img src="./img/move_gif.gif" alt=""></div>
        </main>
        <footer class="footer">
            <div class="footer_content">
                <div class="f_box">
                    <div class="f_logo"><img src="./img/logo.png" alt=""></div>
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

        <c:forEach var="data" items="${review_score}">
            <input type="hidden" name="review_score" value="${data.rvScore}/${data.scoreCount}">
        </c:forEach>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
    <script src="<c:url value='/js/mypage.js'/>"></script>
    <script>
        $(window).load(function(){
            /*
            score점수를 input hidden으로 추가하고 해당데이터를 가져와서 차트 데이터를 만들어준다.
            ajax로 api를 따로 뺴서 하면 더 간단하게 처리할수 있다.
             */
            scores = document.getElementsByName("review_score")
            scores_data = {}
            for (var i = 0; i < scores.length; i++) {
                data = scores[i].value.split("/")
                scores_data[data[0]] = data[1]
            }
            /*
            점수/갯수 이렇게 되어있는걸 javascript object로 바꿔준다.
            {점수: 갯수, ....} 이런식으로
             */

            data = []
            for(var i=1; i<=5; i++) {
                /*
                차트를 위한 데이터를 만든다. 총5개의 데이터가 필요하며
                위에 갯수가 있으면 해당 점수의 갯수를 가져와 넣어주고
                없으면 0을 입력한다.
                 */
                if (scores_data[i] != null) {
                    data.push(scores_data[i])
                } else {
                    data.push(0)
                }
            }
            // 차트 생성 함수 호출
            chartInit(data)
        })
        let dateFormat = (sqlDt) => {
            let dt = new Date(review.rvRegDate);
            let year=dt.getFullYear();
            let mon=dt.getMonth()+1;
            let date=dt.getDate();
            let fullDate = year + "-" + mon + "-" + date;
            return fullDate;
        }
    </script>
</body>
</html>
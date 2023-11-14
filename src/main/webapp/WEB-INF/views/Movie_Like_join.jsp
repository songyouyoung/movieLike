<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
    <link rel="stylesheet" href="./css/common.css">
    <link rel="stylesheet" href="./css/header.css">
    <link rel="stylesheet" href="./css/join_page.css">
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
            <form action="" class="join_form">
                <div class="title">회원가입</div>
                <table>
                    <tr>
                        <th>아이디</th>
                        <th><input type="text" class="login_input"></th>
                    </tr>
                    <tr>
                        <th>비밀번호</th>
                        <th><input type="text" class="login_input"></th>
                    </tr>
                    <tr>
                        <th>비밀번호 확인</th>
                        <th><input type="text" class="login_input"></th>
                    </tr>
                    <tr>
                        <th>이름</th>
                        <th><input type="text" class="login_input"></th>
                    </tr>
                    <tr>
                        <th>생년월일</th>
                        <th><input type="text" class="login_input"></th>
                    </tr>
                    <tr>
                        <th>전화번호</th>
                        <th><input type="text" class="login_input"></th>
                    </tr>
                    <tr>
                        <th>닉네임</th>
                        <th><input type="text" class="login_input"></th>
                    </tr>
                    <tr>
                        <th>나의 영화 취향<br>(선택)</th>
                        <th>
                            <input type="button" class="genre" value="로맨스">
                            <input type="button" class="genre" value="액션">
                            <input type="button" class="genre" value="스릴러">
                            <input type="button" class="genre" value="공포">
                            <input type="button" class="genre" value="코미디">
                            <br>
                            <input type="button" class="genre" value="판타지">
                            <input type="button" class="genre" value="멜로">
                            <input type="button" class="genre" value="범죄">
                        </th>
                    </tr>
                    

                    <tr>
                        <th colspan="2"><input type="button" class="login_btn" value="회원가입"></th>
                    </tr>
                </table>
            </form>
        </main>
    </div>
</body>
</html>
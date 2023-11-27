// 아이디, 비밀번호, 전화번호, 생년월일, 닉네임 체크 함수
function sendit() {
    const email = document.getElementById('email'); // 아이디 입력란
    const nickname = document.getElementById('nickname'); // 닉네임 입력란
    const password = document.getElementById('password'); // 비밀번호 입력란
    const password_chk = document.getElementById('password_chk'); // 비밀번호 확인 입력란
    const name = document.getElementById('name'); // 이름 입력란
    const hp = document.getElementById('hp'); // 전화번호 앞자리 입력란
    const hp2 = document.getElementById('hp2'); // 전화번호 중간자리 입력란
    const hp3 = document.getElementById('hp3'); // 전화번호 뒷자리 입력란
    const birth_year = document.getElementById('birth_year'); // 출생 연도 선택란
    const birth_month = document.getElementById('birth_month'); // 출생 월 선택란
    const birth_date = document.getElementById('birth_date'); // 출생 일 선택란
    const jangenre_chk = document.getElementsByName('genre_chk'); // 장르 체크박스

    // 정규 표현식
    const expPwText = /^(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&*])[A-Za-z\d!@#$%^&*]{8,}$/; // 비밀번호 정규 표현식
    const expNameText = /^[가-힣]+$/; // 이름 정규 표현식 (한글만 허용)
    const expHpText = /^\d{3}-\d{3,4}-\d{4}$/; // 전화번호 정규 표현식
    // const expEmailText = /^[A-Za-z-0-9\-\.]+@[A-Ja-z-0-9\-\.]+\.[A-Ja-z-0-9]+$/; // 이메일 정규 표현식
    const expEmailText = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/
    const expNicknameText = /^(?=.*[a-z0-9가-힣])[a-z0-9가-힣]{2,16}$/; // 닉네임 정규 표현식

    // 이메일 체크
    if (email.value == '' || !validateEmail(email.value)) {
        alert('유효한 이메일을 입력하세요');
        email.focus();
        return false;
    }
    function validateEmail(email) {
        // 이메일 정규 표현식
        const expEmailText = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;

        // 입력된 이메일 주소가 유효한지 검사
        if (!expEmailText.test(String(email).toLowerCase())) {
            alert('유효한 이메일을 입력하세요');
            return false;
        }

        // 도메인 부분 가져오기
        const domain = email.split('@')[1];

        // 허용된 도메인인지 확인
        if (!(domain.endsWith('.com') || domain.endsWith('.net'))) {
            alert('지원되지 않는 도메인입니다. 유효한 이메일 도메인을 사용하세요.');
            return false;
        }

        return true;
    }

// 테스트
    const emailToValidate = "test@example.com";
    if (validateEmail(emailToValidate)) {
        console.log(`${emailToValidate}은(는) 유효한 이메일 주소입니다.`);
    } else {
        console.log(`${emailToValidate}은(는) 유효하지 않은 이메일 주소입니다.`);
    }

    // 비밀번호 체크
    if (password.value == '') {
        alert('비밀번호를 입력하세요');
        password.focus();
        return false;
    }

    // 비밀번호 형식 체크
    if (!expPwText.test(password.value)) {
        alert('비밀번호 형식을 확인하세요\n소문자, 대문자, 특수문자, 숫자를 각각 1개 이상 포함하고, 총 8자 이상으로 입력해야 합니다.');
        password.focus();
        return false;
    }

    // 이름 체크
    if (!expNameText.test(name.value)) {
        alert('이름을 입력하세요 (한글만 가능합니다)');
        name.focus();
        return false;
    }

    // 출생 연도 체크
    if (birth_year.value == '출생 연도') {
        alert('출생 연도를 선택하세요');
        birth_year.focus();
        return false;
    }

    // 출생 월 체크
    if (birth_month.value == '월') {
        alert('출생 월을 선택하세요');
        birth_month.focus();
        return false;
    }

    // 출생 일 체크
    if (birth_date.value == '일') {
        alert('출생 일을 선택하세요');
        birth_date.focus();
        return false;
    }

    // 전화번호 체크
    if (hp.value == '' || hp2.value == '' || hp3.value == '') {
        alert('전화번호를 입력하세요');
        hp.focus();
        return false;
    }

    // 닉네임 체크
    if (nickname.value == '') {
        alert('닉네임을 입력하세요');
        nickname.focus();
        return false;
    }

    // 닉네임 형식 체크
    if (!expNicknameText.test(nickname.value)) {
        alert('닉네임이 올바르지 않습니다.\n\n(한글 초성 및 모음 제외한 2자 이상 16자 이하, 영어 또는 숫자 또는 한글로 구성 가능합니다)');
        nickname.focus();
        return false;
    }

    // 선택된 장르 개수 체크
    let count = 0;
    for (let i in jangenre_chk) {
        if (jangenre_chk[i].checked) { // checked가 되어있으면 true, 아니면 false
            count++;
        }
    }
    if (count > 3) {
        alert('장르는 최대 3개까지 선택 가능합니다.');
        return false;
    }
}

// 출생 연도, 월, 일 선택란 변수 선언
const birthYearEl = document.querySelector('#birth_year');
const birthMonthEl = document.querySelector('#birth_month');
const birthDateEl = document.querySelector('#birth_date');

// 출생 연도 옵션 생성 함수
function createYearOptions() {
    let today = new Date();
    let year = today.getFullYear();
    for (let i = 1940; i <= year; i++) {
        const YearOption = document.createElement('option');
        YearOption.setAttribute('value', i);
        YearOption.innerText = i;
        birthYearEl.appendChild(YearOption);
    }
}

// 출생 월 옵션 생성 함수
function createMonthOptions() {
    for (let i = 1; i <= 12; i++) {
        const MonthOption = document.createElement('option');
        MonthOption.setAttribute('value', i);
        MonthOption.innerText = i;
        birthMonthEl.appendChild(MonthOption);
    }
}

// 출생 일 옵션 생성 함수
function createDateOptions(maxDate) {
    birthDateEl.innerHTML = '<option value="">일</option>';
    for (let i = 1; i <= maxDate; i++) {
        const DateOption = document.createElement('option');
        DateOption.setAttribute('value', i);
        DateOption.innerText = i;
        birthDateEl.appendChild(DateOption);
    }
}

// 출생 연도 선택 변경 시
birthYearEl.addEventListener('change', function () {
    // 출생 월 옵션 초기화
    birthMonthEl.innerHTML = '<option value="">월</option>';
    createMonthOptions();

    // 출생 일 옵션 초기화
    birthDateEl.innerHTML = '<option value="">일</option>';
    createDateOptions(31); // 출생 일 옵션은 기본적으로 31일까지 생성
});

// 출생 월 선택 변경 시
birthMonthEl.addEventListener('change', function () {
    const selectedMonth = parseInt(birthMonthEl.value, 10);
    if (selectedMonth === 2) {
        createDateOptions(28);
    } else if ([4, 6, 9, 11].includes(selectedMonth)) {
        createDateOptions(30);
    } else {
        createDateOptions(31);
    }
});

// 초기화
createYearOptions();
createMonthOptions();
createDateOptions(31); // 초기에는 출생 일 옵션은 기본적으로 31일까지 생성

// 비밀번호 확인 함수
function check_pw() {
    var pw = $('input#password').val();
    var checkPw = $('input#password_chk').val();

    if (pw !== "" || pw !== null) {
        $(".pw-text").css("margin-bottom", "16px");
        $(".pw-text").css("color", "rgb(255, 120, 203)");
        $(".pw-text").css("text-align", "center");
    }
    if (pw === checkPw) {
        $("input[name=userPw]").css("background-color", "#B0F6AC");
        $(".ok-text").css("color", "#34aadc");
        $(".ok-text").css("text-align", "center");
        $(".ok-text").text("사용 가능한 비밀번호입니다.");
        $("input#joinSubmit").removeAttr("disabled");
    } else if (pw !== checkPw) {
        $("input[name=userPw]").css("background-color", "#FFCECE");
        $(".ok-text").css("color", "rgb(255, 120, 203)");
        $(".ok-text").css("text-align", "center");
        $(".ok-text").text("비밀번호를 확인해주세요.");
        $("input#joinSubmit").attr("disabled", "true");
    }
}

// AJAX를 이용한 아이디 중복 체크
function checkId() {
    let email = $('#email').val();

    $.ajax({
        url: "/app/checkId",
        type: 'post',
        data: {userEmail: email},
        success: function (cnt) {
            handleDuplicateCheck(cnt, '.id_ok', '.id_already', '#email');
            checkSignUpButton(); // 중복 체크 후 버튼 상태 업데이트
        },
        error: function () {
            alert("에러입니다");
        }
    });
}

// AJAX를 이용한 닉네임 중복 체크
function checkNick() {
    let nickname = $('#nickname').val();

    $.ajax({
        url: "/app/checkNick",
        type: 'post',
        data: {userNickname: nickname},
        success: function (cnt) {
            handleDuplicateCheck(cnt, '.nick_ok', '.nick_already', '#nickname');
            checkSignUpButton(); // 중복 체크 후 버튼 상태 업데이트
        },
        error: function () {
            alert("에러입니다");
        }
    });
}

// AJAX를 이용한 전화번호 중복 체크
function checkph() {
    let hp1 = $('#hp1').val();
    let hp2 = $('#hp2').val();
    let hp3 = $('#hp3').val();
    let phoneNum = hp1 + "-" + hp2 + "-" + hp3;

    $.ajax({
        url: "/app/checkPhone",
        type: 'post',
        data: {userPhone: phoneNum},
        success: function (cnt) {
            handleDuplicateCheck(cnt, '.ph_ok', '.ph_already', '.phone_input');
            checkSignUpButton(); // 중복 체크 후 버튼 상태 업데이트
        },
        error: function () {
            alert("에러입니다");
        }
    });
}

// 회원가입 버튼 상태 업데이트
function checkSignUpButton() {
    let isSignUpEnabled = $('.id_ok').is(":visible") && $('.nick_ok').is(":visible") && $('.ph_ok').is(":visible");
    let joinSubmitButton = $("#joinSubmit");

    if (isSignUpEnabled) {
        joinSubmitButton.removeAttr("disabled");
        joinSubmitButton.css("background-color", ""); // 기본 배경색으로 설정
    } else {
        joinSubmitButton.attr("disabled", "true");
        joinSubmitButton.css("background-color", "#808080"); // 회색 배경색으로 설정
    }
}

//장르 선택
$(document).on('click', 'input:checkbox[name=genre_chk]', function () {
    genr_arr = [];
    // 체크된 박스인지 확인
    $('input:checkbox[name=genre_chk]').each(function () {
        if($(this).is(":checked")==true){
            if($('input:checkbox[name=genre_chk]:checked').length > 3) {
                alert("장르는 최대 3개까지 선택할 수 있습니다.");
                $(this).prop("checked", false);
            } else {
                genr_arr.push($(this).data('genr'));
            }
        }
    })
    $('input[name=genr_arr]').val(genr_arr);
});
let genr_arr = [];

//아이디,비밀번호,전화번호,생년월일,닉네임 체크
function sendit() {
    const email = document.getElementById('email');
    const nickname = document.getElementById('nickname');
    const password = document.getElementById('password');
    const password_chk = document.getElementById('password_chk');
    const name = document.getElementById('name');
    const hp = document.getElementById('hp1');
    const hp2 = document.getElementById('hp2');
    const hp3 = document.getElementById('hp3');
    const birth_year = document.getElementById('birth_year');
    const birth_month = document.getElementById('birth_month');
    const birth_date = document.getElementById('birth_date');
    const jangenre_chk = document.getElementsByName('genre_chk');

    // 정규 표현식
    const expPwText = /^(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&*])[A-Za-z\d!@#$%^&*]{8,}$/;
    const expNameText = /^[가-힣]+$/;
    const expHpText = /^\d{3}-\d{3,4}-\d{4}$/;
    const expEmailText = /^[A-Za-z-0-9\-\.]+@[A-Ja-z-0-9\-\.]+\.[A-Ja-z-0-9]+$/;
    const expNicknameText= /^(?=.*[a-z0-9가-힣])[a-z0-9가-힣]{2,16}$/;

    if (email.value == '') {
        Swal.fire('알림', '아이디를 입력하세요', 'warning');
        email.focus();
        return false;
    }

    if (password.value == '') {
        Swal.fire('알림', '비밀번호를 입력하세요', 'warning');
        password.focus();
        return false;
    }

    if (!expPwText.test(password.value)) {
        Swal.fire('알림', '비밀번호 형식 확인\n소문자, 대문자, 특수문자, 숫자 1개씩 꼭 입력 및 8자 이상 입력', 'warning');
        password.focus();
        return false;
    }

    if (!expNameText.test(name.value)) {
        Swal.fire('알림', '이름을 입력해주세요 (한글만 가능)', 'warning');
        name.focus();
        return false;
    }

    if (birth_year.value == '출생 연도') {
        Swal.fire('알림', '출생연도를 선택하세요', 'warning');
        birth_year.focus();
        return false;
    }

    if (birth_month.value == '월') {
        Swal.fire('알림', '출생월을 선택하세요', 'warning');
        birth_month.focus();
        return false;
    }

    if (birth_date.value == '일') {
        Swal.fire('알림', '출생일을 선택하세요', 'warning');
        birth_date.focus();
        return false;
    }

    if (hp.value == '') {
        Swal.fire('알림', '전화번호를 입력하세요', 'warning');
        hp.focus();
        return false;
    }

    if (hp2.value == '') {
        Swal.fire('알림', '전화번호를 입력하세요', 'warning');
        hp2.focus();
        return false;
    }

    if (hp3.value == '') {
        Swal.fire('알림', '전화번호를 입력하세요', 'warning');
        hp3.focus();
        return false;
    }

    if (nickname.value == '') {
        Swal.fire('알림', '닉네임을 입력하세요', 'warning');
        nickname.focus();
        return false;
    }

    if (!expNicknameText.test(nickname.value)) {
        Swal.fire('알림', '닉네임이 올바르지 않습니다.\n(한글 초성 및 모음 제외한 2자 이상 16자 이하, 영어 또는 숫자 또는 한글로 구성으로만 가능합니다)', 'warning');
        nickname.focus();
        return false;
    }
    return true;
}

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

$('.phone_input').on('keyup', function() {
    if(this.value.length == this.maxLength) {
        $(this).next('.phone_input').focus();
    }
})

const birthYearEl = document.querySelector('#birth_year');
const birthMonthEl = document.querySelector('#birth_month');
const birthDateEl = document.querySelector('#birth_date');

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

function createMonthOptions() {
    for (let i = 1; i <= 12; i++) {
        const MonthOption = document.createElement('option');
        MonthOption.setAttribute('value', i);
        MonthOption.innerText = i;
        birthMonthEl.appendChild(MonthOption);
    }
}

function createDateOptions(maxDate) {
    birthDateEl.innerHTML = '<option value="">일</option>';
    for (let i = 1; i <= maxDate; i++) {
        const DateOption = document.createElement('option');
        DateOption.setAttribute('value', i);
        DateOption.innerText = i;
        birthDateEl.appendChild(DateOption);
    }
}

// 년도 선택 변경 시
birthYearEl.addEventListener('change', function () {
    // 월 옵션 초기화
    birthMonthEl.innerHTML = '<option value="">월</option>';
    createMonthOptions();

    // 일 옵션 초기화
    birthDateEl.innerHTML = '<option value="">일</option>';
    createDateOptions(31); // 일 옵션은 기본적으로 31일까지 생성
});

// 월 선택 변경 시
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
createDateOptions(31); // 초기에는 일 옵션은 기본적으로 31일까지 생성
function check_pw() {

    var pw = $('input#password').val();
    var checkPw = $('input#password_chk').val();

    if (pw !== "" || pw !== null) {
        $(".pw-text").css("margin-bottom", "16px");
        $(".pw-text").css("color", "rgb(255, 120, 203)");
        $(".pw-text").css("text-align", "center");
        // $(".pw-text").text("비밀번호를 확인해주세요");

    }
    if (pw === checkPw) {
        $("input[name=userPw]").css("background-color", "#B0F6AC");
        // $(".ok-text").css("margin-bottom", "16px");
        $(".ok-text").css("color", "#34aadc");
        $(".ok-text").css("text-align", "center");
        $(".ok-text").text("사용 가능한 비밀번호입니다.");
        $("input#joinSubmit").removeAttr("disabled");
    } else if (pw !== checkPw) {
        $("input[name=userPw]").css("background-color", "#FFCECE");
        // $(".ok-text").css("margin-bottom", "16px");
        $(".ok-text").css("color", "rgb(255, 120, 203)");
        $(".ok-text").css("text-align", "center");
        $(".ok-text").text("비밀번호를 확인해주세요.");
        $("input#joinSubmit").attr("disabled", "true" );

    }
}


function handleDuplicateCheck(result, successSelector, failureSelector, inputSelector) {
    if (result === 0) {
        $(successSelector).css("display", "inline-block");
        $(failureSelector).css("display", "none");
    } else {
        $(failureSelector).css("display", "inline-block");
        $(successSelector).css("display", "none");
        $(inputSelector).val(''); // 입력란 초기화
    }
}

// AJAX를 이용한 아이디 중복체크
function checkId() {
    let email = $('#email').val().trim();
    if(email !== "" ) {
        $.ajax({
            url: "/app/checkId",
            type: 'post',
            data: {userEmail: email},
            success: function (cnt) {
                handleDuplicateCheck(cnt, '.id_ok', '.id_already', '#email');
                checkSignUpButton(); // 중복체크 후 버튼 상태 업데이트
            },
            error: function () {
                alert("에러입니다");
            }
        });
    }
}

// AJAX를 이용한 닉네임 중복체크
function checkNick() {
    let nickname = $('#nickname').val().trim();
    if(nickname !== "") {
        $.ajax({
            url: "/app/checkNick",
            type: 'post',
            data: {userNickname: nickname},
            success: function (cnt) {
                handleDuplicateCheck(cnt, '.nick_ok', '.nick_already', '#nickname');
                checkSignUpButton(); // 중복체크 후 버튼 상태 업데이트
            },
            error: function () {
                alert("에러입니다");
            }
        });
    }
}

// AJAX를 이용한 전화번호 중복체크
function checkph() {
    let hp1 = $('#hp1').val().trim();
    let hp2 = $('#hp2').val().trim();
    let hp3 = $('#hp3').val().trim();
    let phoneNum = hp1 + "-" + hp2 + "-" + hp3;
    if(phoneNum.length === 13) {
        $.ajax({
            url: "/app/checkPhone",
            type: 'post',
            data: {userPhone: phoneNum},
            success: function (cnt) {
                handleDuplicateCheck(cnt, '.ph_ok', '.ph_already', '.phone_input');
                checkSignUpButton(); // 중복체크 후 버튼 상태 업데이트
            },
            error: function () {
                alert("에러입니다");
            }
        });
    }
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
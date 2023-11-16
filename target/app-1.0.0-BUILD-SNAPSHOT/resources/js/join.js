function joinCheck() {
    theForm = document.form1;

    if(theForm.email.value=="") {

        alert("이메일을 입력해주세요.");
    } 

}


// 생년월일 선택 부분 
const birthYearEl = document.querySelector('#birth_year')
let today = new Date();
let year = today.getFullYear();

isYearOptionExisted = false;
birthYearEl.addEventListener('focus', function() {
    if(!isYearOptionExisted) {
        isYearOptionExisted = true;
        for(var i = 1940; i<=year; i++) {
            const YearOption = document.createElement('option')
            YearOption.setAttribute('value', i)
            YearOption.innerText = i

            this.appendChild(YearOption);
        }
    }
});

const birthMonthEl = document.querySelector('#birth_month') 

isMonthOptionExisted = false;
birthMonthEl.addEventListener('focus', function() {
    if(!isMonthOptionExisted) {
        isMonthOptionExisted = true;
        for(i=1; i<=12;i++) {
            const MonthOption = document.createElement('option')
            MonthOption.setAttribute('value', i)
            MonthOption.innerText = i

            this.appendChild(MonthOption);
        }
    }
});

const birthDateEl = document.querySelector('#birth_date') 

isDateOptionExisted = false;
birthDateEl.addEventListener('focus', function() {
    if(!isDateOptionExisted) {
        isDateOptionExisted = true;
        for(i=1; i<=31;i++) {
            const DateOption = document.createElement('option')
            DateOption.setAttribute('value', i)
            DateOption.innerText = i

            this.appendChild(DateOption);
        }
    }
});




// 전화번호 자동 탭 이동 
$('.phone_input').on('keyup', function() {
    if(this.value.length == this.maxLength) {
        $(this).next('.phone_input').focus();
    }
})
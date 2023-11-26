function genreClick(id) {
    location.href = "./list/chart?title=genr&val=" + id
}
function changeOrder(obj) {
    // 최신순, 좋아요순이 바뀌면 아래 url을 호출한다.
    location.href = "./myPage?orderType=" + obj.value
}
function moveList(type, count) {
    // count가 0이면 이동하지 않는다.
    if (count == 0) {
        return;
    }

    location.href =  "./list/chart?title=" + type;
}

$('.btn_myreview a').click(function() {
    event.preventDefault();
    let href = $(this).attr('href')
    $('html, body').animate({
        scrollTop: $(href).offset().top
    }, 1000)    
})

function updateCheck() {
    // var user_password = prompt('비밀번호를 입력해주세요');
    (async () => {
        const { value: user_password } = await Swal.fire({
            title: '비밀번호를 입력해주세요',
            input: 'text',
            confirmButtonColor: "#a785efb8"
        });
        $.ajax({
            type:'POST',
            url: '/app/myPage/modifyInfo',
            headers: {"content-type": "application/json"},
            success : function(data) {
                if(data == user_password) {
                var popup = document.getElementById("popup");
                popup.style.visibility = "visible";
                popup.style.opacity = "1";
                popup.style.zIndex = "9"
                } else {
                    Swal.fire({
                        title: "비밀번호가 일치하지 않습니다.",
                    });
                }
            },
            error : function(e) {
                Swal.fire({
                    title: "개인정보 수정 ERROR. \n 관리자에게 전달해주세요.",
                });
            }})
    })()

    // 비밀번호 확인하고 회원정보 폼 뜨기
}

function closePopup() {
  var popup = document.getElementById("popup");
  popup.style.visibility = "hidden";
  popup.style.opacity = "0";
}

// 외부영역 클릭 시 팝업 닫기
$(document).mouseup(function (e){
  var Popup = $(".popup");
  if(Popup.has(e.target).length === 0){
    closePopup();
  }
});

function updatePopup() {
  Swal.fire({
    position: "center",
    zIndex: 99999,
    icon: "success",
    title: "회원정보가 수정되었습니다.",
    showConfirmButton: false,
    timer: 1500
  });
}

function unregister() {
  Swal.fire({
    title: "정말 탈퇴하시겠습니까?",
    text: "탈퇴시 모든 개인정보가 삭제됩니다.",
    icon: "warning",
    showCancelButton: true,
    confirmButtonColor: "#AD8B73",
    cancelButtonColor: "#BEBCBA",
    confirmButtonText: "네",
    cancelButtonText: "아니요"
  }).then((result) => {
    if (result.isConfirmed) {
      Swal.fire({
        title: "회원 탈퇴",
        text: "탈퇴되었습니다.",
        icon: "success"
      });
    }
  });
}

   


// 생년월일 선택 부분 
// 년
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

// 월
var birthMonthEl = document.querySelector('#birth_month') 

// 일
var birthDateEl = document.querySelector('#birth_date') 

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


birth_month.addEventListener('change', function() {

    var chk_month = birth_month.options[birth_month.selectedIndex].value;
    console.log(chk_month);


    isDateOptionExisted = false;
    if(chk_month == 2) {
        birthDateEl.addEventListener('focus', function() {
            if(!isDateOptionExisted) {
                $('#birth_date').empty(); // .empty() : 지정한 요소의 하위 요소를 제거
                isDateOptionExisted = true;
                for(i=1; i<=28;i++) {
                    const DateOption = document.createElement('option')
                    DateOption.setAttribute('value', i)
                    DateOption.innerText = i

                    this.appendChild(DateOption);
                }
                isDateOptionExisted = false;
            }
        });
    }
    else if(chk_month == 4 || chk_month == 6 || chk_month == 9 || chk_month == 11) {
        isDateOptionExisted = false;
        birthDateEl.addEventListener('focus', function() {
            if(!isDateOptionExisted) {
                $('#birth_date').empty();
                isDateOptionExisted = true;
                for(i=1; i<=30;i++) {

                    var DateOption = document.createElement('option')
                    
                    DateOption.setAttribute('value', i)
                    DateOption.innerText = i

                    this.appendChild(DateOption);
                }
                isDateOptionExisted = false;
            }
        });
    }
    else {
        isDateOptionExisted = false;
        birthDateEl.addEventListener('focus', function() {
            if(!isDateOptionExisted) {
                $('#birth_date').empty();
                isDateOptionExisted = true;
                for(i=1; i<=31;i++) {
                    const DateOption = document.createElement('option')
                    DateOption.setAttribute('value', i)
                    DateOption.innerText = i

                    this.appendChild(DateOption);
                }
                isDateOptionExisted = false;
            }
        });
    }
})

// 차트 

function chartInit(data) {
    const ctx = document.getElementById('myChart');
    const chart = new Chart(ctx, {
        type: 'bar',
        data: {
            labels: ['1', '2', '3', '4', '5'],
            datasets: [{
                data: data,
                backgroundColor: [
                    'rgba(255, 99, 132, 0.5)',
                    'rgba(54, 162, 235, 0.5)',
                    'rgba(255, 206, 86, 0.5)',
                    'rgba(75, 192, 192, 0.5)',
                    'rgba(153, 102, 255, 0.5)'
                ],
                borderWidth: 2,
                borderColor: [
                    'rgba(255, 99, 132, 1)',
                    'rgba(54, 162, 235, 1)',
                    'rgba(255, 206, 86, 1)',
                    'rgba(75, 192, 192, 1)',
                    'rgba(153, 102, 255, 1)'
                ],
                fill: false
            }]
        },
        options: {
            onClick: (e) => {
                // label값을 가져와서 링크이동시켜준다.
                const canvasPosition = Chart.helpers.getRelativePosition(e, chart);
                const dataX = chart.scales.x.getValueForPixel(canvasPosition.x);
                location.href = "./list/chart?title=myScore&val=" + (dataX + 1)
            },
            maxBarThickness: 50,
            scales: { // 눈금선 없애기
                x: {
                    grid: {
                        display: false
                    },
                    ticks: {
                        color: "rgba(255, 255, 255, 1)", // 글자 색
                        font: {
                            size: 20
                        }
                    },
                    border: {
                        color: "rgba(255, 255, 255, 1)" // 축 색
                    },
                    barPercentage: 1,
                    categoryPercentage: 1,
                    barThickness : 45
                },
                y: {
                    grid: {
                        display: false
                    },
                    ticks: {
                        color: "rgba(255, 255, 255, 1)",
                        font: {
                            size: 0
                        }
                    },
                    border: {
                        display: false
                    }
                },
            },

            scaleShowLabels : false,
            plugins: {
                legend: {
                    display: false,
                }
            }
        }
    });
}


let updateButtons = document.querySelectorAll('.review_update');
updateButtons.forEach(function(button) {
    button.addEventListener('click', function(event) {
        let parentElement = event.target.closest('.review_list_box');

        let reviewContentElement = parentElement.querySelector('.review_content');

        reviewContentElement.readOnly = false;
        reviewContentElement.style.color = "black";
        reviewContentElement.style.padding = "10px";
        reviewContentElement.style.background = "white";
    });
});

var txtArea = $(".review_content");
    if (txtArea) {
        txtArea.each(function(){
            $(this).height(this.scrollHeight);
        });
    }

const DEFAULT_HEIGHT = 30; // textarea 기본 height
const $textarea = document.querySelector('.review_content');

$textarea.oninput = (event) => {
  const $target = event.target;

  $target.style.height = 0;
  $target.style.height = DEFAULT_HEIGHT + $target.scrollHeight + 'px';
};
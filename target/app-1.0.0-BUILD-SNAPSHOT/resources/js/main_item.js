function poster_content6() {
    for(let i=0; i<6; i++) {

        let poster_item = `<div class="poster">
                                <img src="./img/poster.jpg" alt="">
                            </div>`

        $(poster_item).appendTo('.poster_box')
    }
}
poster_content6();

function review_content() {
    let review_item = `<div class="review_movie_name">영화제목</div>
                        <div class="review_txt">리뷰 작성</div>
                        <div class="review_title">닉네임</div>
                        <div class="star_icon"><img src="./img/star.png" alt=""></div>
                        <div class="movie_star">4.2</div>
                        <div class="like_box">
                            <div class="like_icon"><img src="./img/heart_cnt.png" alt=""></div>
                            <div class="like_cnt">256</div>
                        </div>`
    $(review_item).appendTo('.review')
}
review_content();

// 순위(스와이퍼) 
var swiper = new Swiper(".mySwiper", {
    slidesPerView: 5, // 칸 수
    spaceBetween: 70,
    // freeMode: true,
    pagination: {
        el: ".swiper-pagination",
        clickable: true,
    },
     // Navigation arrows
    navigation: {
        nextEl: '.swiper-button-next',
        prevEl: '.swiper-button-prev',
    },
    loop: false,
    direction: 'horizontal', //horizontal,vertical 배치 방향
    effect: 'slide' // 'slide', 'fade', 'cube', 'coverflow', 'flip' or 'creative'
});


// 메인베너
var idx_lgth = $(".main_banner>div").length;
var srt = 1;
var idx = 0;

$("section>a").click(function(){
    idx = $(this).index();
    srt = idx;
    $(this).addClass('on').siblings().removeClass('on');
    $(".main_banner>div").eq(idx).addClass('on').siblings().removeClass('on');
});

var AutoSlide = setInterval(AutoRun, 2000);

function AutoRun(){
  
    if(srt == idx_lgth){
        srt = 0;  
    }
    $("section>a").eq(srt).addClass('on').siblings().removeClass('on');
    $(".main_banner>div").eq(srt).addClass('on').siblings().removeClass('on');
    srt++;  
}

$(".main_banner").mouseover(function(){
    clearInterval(AutoSlide);
    $(".right_btn").css({opacity : '1'});
    $(".left_btn").css({opacity : '1'});
});
$(".main_banner").mouseleave(function(){
    AutoSlide = setInterval(AutoRun, 2000);
    $(".right_btn").css({opacity : '0'});
    $(".left_btn").css({opacity : '0'});
});

$(".right_btn").click(function(){
    srt++;
    if(srt == idx_lgth){
        srt = 0;   
    } 
    $(".main_banner>div").eq(srt).addClass('on').siblings().removeClass('on'); $("section>a").eq(srt).addClass('on').siblings().removeClass('on');
});

$(".left_btn").click(function(){
    srt--;
    if(srt == -1){
        srt = idx_lgth-1; 
    }
    $(".main_banner>div").eq(srt).addClass('on').siblings().removeClass('on');
    $("section>a").eq(srt).addClass('on').siblings().removeClass('on'); 
});

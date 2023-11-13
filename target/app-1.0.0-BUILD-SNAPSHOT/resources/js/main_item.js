function poster_content_best() {
    for(let i=0; i<5; i++) {

        let best_poster_item = `<div class="ranking_poster">
                                    <img src="./img/poster.jpg" alt="">
                                    <div class="ranking">${i+1}</div>
                                </div>`

        $(best_poster_item).appendTo('.ranking_poster_box')
    }
}

poster_content_best();

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
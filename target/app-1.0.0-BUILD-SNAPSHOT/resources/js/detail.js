function review_data() {
    let review = `<div class="review_list_box">
                    <div class="list_line"></div>
                    <div class="review_title_box">
                        <div class="nickname">닉네임</div>
                        <div class="star_icon1"><img src="./img/star.png" alt=""></div>
                        <div class="movie_avg1">4</div>
                        <div class="write_date">4달 전</div>
                    </div>
                    <div class="review_content">리뷰입력</div>
                    <div class="like_box">
                        <div class="like_icon"><img src="./img/heart_cnt.png" alt=""></div>
                        <div class="like_cnt">256</div>
                    </div>
                </div>`

    $(review).appendTo('.all_review')
}

review_data();
function my_watched_data() {
    for(let i=0; i<5; i++) {

        let my_watched_item = `<div class="content">
                                <div class="poster"><img src="./img/poster.jpg" alt="영화 포스터"></div>
                                <div class="movie_name">영화명</div>
                                <div class="avg_box">
                                    <div class="star_icon"><img src="./img/star.png" alt=""></div>
                                    <div class="movie_avg">4.2</div>
                                </div>
                            </div>`

        $(my_watched_item).appendTo('.content_box')
    }
}

my_watched_data();
my_watched_data();
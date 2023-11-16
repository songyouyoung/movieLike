function group_data() {
    for(let i=0; i<4;i++) {
        for(let i=0; i<5; i++) {

            let group_item = `<div class="content">
                                    <div class="poster"><img src="./img/poster.jpg" alt="영화 포스터"></div>
                                    <div class="movie_name">영화명${i+1}</div>
                                    <div class="avg_box">
                                        <div class="star_icon"><img src="./img/star.png" alt=""></div>
                                        <div class="movie_avg">4.2</div>
                                    </div>
                                </div>`

            $(group_item).appendTo('.content_box')
        }
    }
}
group_data();

$(document).ready(function() {
    let d_height = $(document).height();
    $(window).scroll(function() {
        let s_bot = $(window).scrollTop() + $(window).height();

        if (s_bot >= d_height) { 
            for(let i=0; i<20; i++) {
                let list = `<div class="content">
                                <div class="poster"><img src="./img/poster.jpg" alt="영화 포스터"></div>
                                <div class="movie_name">영화명${i+1}</div>
                                <div class="avg_box">
                                    <div class="star_icon"><img src="./img/star.png" alt=""></div>
                                    <div class="movie_avg">4.2</div>
                                </div>
                            </div>`;
                $(list).appendTo('.content_box')
            }

            d_height = $(document).height(); 
        } 
    });
})

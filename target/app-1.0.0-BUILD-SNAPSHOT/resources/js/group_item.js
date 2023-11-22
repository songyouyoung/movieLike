$(document).ready(function() {
// 들어온 위치에 따른 title설정.
    let select_r = `<select class="select_r">
                                <option value="latest" selected>최신순</option>
                                <option value="popularity">인기순</option>
                            </select>`;
    $(".title_box").html("");
    if (s_path == "search"){
        let searchBar = `<div class="search_bar">
                                    <input type="text" class="search" placeholder="영화 제목, 감독 배우를 검색해주세요">
                                    <div class="s_icon"><img src="../img/search.png" alt="search"></div>
                                </div>`;
        $(searchBar + select_r).appendTo(".title_box");
    }

// 검색버튼 눌렀을 때, 엔터쳤을 때 리스트 페이지로 이동
    $(".search_bar").on('click', '.s_icon', function(){
        location.href = "/" + c_path + "/list/search?search="+$(".search").val();
    });
    $(".search").keydown(function(){
        if(event.keyCode == 13){
            location.href = "/" + c_path + "/list/search?search="+$(".search").val();
        }
    });

// 영화 리스트 출력
//     function group_data() {
//         for(let i=0; i<4;i++) {
//             for(let i=0; i<5; i++) {
//                 let group_item = `<div class="content">
//                                     <div class="poster"><img src="../img/poster.jpg" alt="영화 포스터"></div>
//                                     <div class="movie_name">영화명</div>
//                                     <div class="avg_box">
//                                         <div class="star_icon"><img src="../img/star.png" alt="★"></div>
//                                         <div class="movie_avg">4.2</div>
//                                     </div>
//                                 </div>`
//                 $(group_item).appendTo('.content_box')
//             }
//         }
//     }
    //group_data();

//무한 스크롤 영화 리스트 출력
    let d_height = $(document).height();
    let scrollChk = 1;
    $(window).scroll(function() {
        let s_bot = $(window).scrollTop() + $(window).height();
        if (s_bot + 100 >= d_height) { 
            // for(let i=0; i<20; i++) {
            //     let list = `<div class="content">
            //                     <div class="poster"><img src="../img/poster.jpg" alt="영화 포스터"></div>
            //                     <div class="movie_name">영화명</div>
            //                     <div class="avg_box">
            //                         <div class="star_icon"><img src="../img/star.png" alt="★"></div>
            //                         <div class="movie_avg">4.2</div>
            //                     </div>
            //                 </div>`;
            //     $(list).appendTo('.content_box')
            // }

            d_height = $(document).height(); 
        } 
    });
})
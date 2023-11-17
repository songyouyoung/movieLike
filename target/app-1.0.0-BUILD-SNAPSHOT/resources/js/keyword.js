$(document).ready(function(){
    var nowPage = 0;
    var endPage = 0;
    var pageSize = 20;
    $(".m_tdItem, .m_tagItem").click(function (){
        $(".m_mvBox").html("");
        showMovieList();
    });

    function showMovieList(){
        let genr="";
        let ott="";
        let review= 0;
        let score= 0.0;
        let tag = $(".m_tagList").children();
        let j = tag.length; //val()
        for (let i = 0; i < j; i++){
            let value = tag.eq(i).data("key").split("/");
            switch (value[0]){
                case "genr":
                    genr += value[1] + "|";
                    break;
                case "ott":
                    ott += value[1] + "|";
                    break;
                case "review":
                    review = review == 0 ? value[1] : (review > value[1] ? value[1] : review);
                    break;
                case "score":
                    score = score == 0 ? value[1] : (score > value[1] ? value[1] : score);
                    break;
            }
        }
        console.log("genr : " + genr);
        console.log("review : " + review);
        let keyword = {movScore: score, movScoreCnt: review, ottName: ott, genrName: genr, nowPage: nowPage, pageSize: pageSize};
        let keyword2 = {};
        $.ajax({
            type:'POST',       // 요청 메서드
            url: '/app/findKeyword',  // 요청 URI
            headers : { "content-type": "application/json"}, // 요청 헤더
            dataType : 'text', // 전송받을 데이터의 타입
            data : JSON.stringify(keyword),  // 서버로 전송할 데이터. stringify()로 직렬화 필요.
            success : function(result){
                console.log("received="+result);       // result는 서버가 전송한 데이터
                $(".m_mvBox").append(toHtml(result));
                showPage();
            },
            error : function(){
                alert("error");
                $(".m_mvBox").html("");
                $(".m_moreBox").html("");
            } // 에러가 발생했을 때, 호출될 함수
        }); // $.ajax()
    }

    var c_path = (location.pathname).split("/")[1];
    console.log("c_path : " + c_path);
    let toHtml = function(movieList) {
        let keywordList = "";
        let ottList = "";
        movieList = JSON.parse(movieList);
        endPage += movieList.length;

        movieList.forEach(function(movie) {
            let dt = new Date(movie.movDate);
            let year = dt.getFullYear();
            let month = dt.getMonth()+1 < 10 ? "0" + dt.getMonth()+1 : dt.getMonth()+1;
            let date = dt.getDate() < 10 ? "0" + dt.getDate() : dt.getDate();
            let ottId = movie.ottId;
            let ottName = movie.ottName;
            if(ottId != "" && ottId != null) {
                let ottIdList = ottId.split(",");
                let ottNameList = ottName.split(",");
                for (let j = 0; j < ottIdList.length; j++) {
                    ottList += `<div class="m_mvOttBox">
                                <span class="m_mvOtt"><img src= "../img/ott/${ottIdList[j]}.png" alt="${ottNameList[j]}">${ottNameList[j]}</span>
                            </div>`;
                }
            }
            keywordList += `<div class="m_mvList" data-movId=${movie.movId}>
                                <div class="m_mvPoster"><img src="https://image.tmdb.org/t/p/w500/${movie.movPoster}" alt=""></div>
                                <div class="m_mvDesc">
                                    <div class="m_mvTitle">${movie.movName}</div>
                                    <div class="m_mvTitleEng">${movie.movNameEng}</div>
    <!--                                    <div class="m_mvDate">${movie.movDate}</div>-->
                                    <div class="m_mvDate">${year}-${month}-${date}</div>
                                    <div class="m_mvDescBox">
                                        <span class="m_mvDir">${movie.dirName}</span><span class="m_mvCountry">${movie.cname}</span>
                                    </div>
                                    <div class="m_mvDescBox">
                                        <span class="m_mvGen">${movie.genrName}</span><span class="m_mvTime">${movie.movTime}분</span>
                                    </div>`
                                    + ottList +
                                    `<div class="avg_box">
                                        <div class="star_icon"><img src= "../img/star.png" alt="★"></div>
                                        <div class="movie_avg">${movie.movScore}</div>
                                        <div class="movie_avg_cnt">( ${(movie.movScoreCnt).toLocaleString("ko")} )</div>
                                    </div>
                                </div>
                            </div>`;
        });
        return keywordList;
    };

    // 페이징 작업
    function showPage(){
        console.log("endPage : " + endPage);
        console.log("pageSize : " + pageSize);
        console.log("endPage % pageSize : " + endPage % pageSize);
        if(endPage % pageSize == 0) {
            $(".m_moreBox").html("<span>더보기▽</span>");
        }else{
            $(".m_moreBox").html("");
        }
        nowPage = endPage;
        console.log("nowPage : " + nowPage);
    }
    $(".m_moreBox").click(function (){
        showMovieList();
    });

});
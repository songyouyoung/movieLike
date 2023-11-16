$(document).ready(function(){
    $(".m_tdItem, .m_tagItem").click(function(){
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
        // let keyword = {movScore: score, movScoreCount: review, ottName: encodeURIComponent(ott), genrName: encodeURIComponent(genr)};
        let keyword = {movScore: score, movScoreCnt: review, ottName: ott, genrName: genr};
        let keyword2 = {};
        $.ajax({
            type:'POST',       // 요청 메서드
            url: '/app/findKeyword',  // 요청 URI
            headers : { "content-type": "application/json"}, // 요청 헤더
            dataType : 'text', // 전송받을 데이터의 타입
            data : JSON.stringify(keyword),  // 서버로 전송할 데이터. stringify()로 직렬화 필요.
            success : function(result){
                keyword2 = JSON.parse(result);    // 서버로부터 응답이 도착하면 호출될 함수
                console.log("received="+result);       // result는 서버가 전송한 데이터
                $(".m_mvBox").html(toHtml(result));
            },
            error : function(){ alert("error") } // 에러가 발생했을 때, 호출될 함수
        }); // $.ajax()
    });
    var c_path = (location.pathname).split("/")[1];
    console.log("c_path : " + c_path);
    let toHtml = function(movieList) {
        let keywordList ="";
        movieList = JSON.parse(movieList);

        movieList.forEach(function(movie) {
            let dt = new Date(movie.movDate);
            let year = dt.getFullYear();
            let month = dt.getMonth()+1 < 10 ? "0" + dt.getMonth()+1 : dt.getMonth()+1;
            let date = dt.getDate() < 10 ? "0" + dt.getDate() : dt.getDate();

            keywordList += `<div class="m_mvList">
                                <div class="m_mvPoster"><img src=${movie.movPoster} alt=""></div>
                                <div class="m_mvDesc">
                                    <div class="m_mvTitle">${movie.movName}</div>
                                    <div class="m_mvTitleEng">${movie.movNameEng}</div>
<!--                                    <div class="m_mvDate">${movie.movDate}</div>-->
                                    <div class="m_mvDate">${year}-${month}-${date}</div>
                                    <div class="m_mvDescBox">
                                        <span class="m_mvDir">${movie.dirName}</span><span class="m_mvCountry">${movie.cName}</span>
                                    </div>
                                    <div class="m_mvDescBox">
                                        <span class="m_mvGen">${movie.genrName}</span><span class="m_mvTime">${movie.movTime}분</span>
                                    </div>
                                    <div class="m_mvOttBox">
                                        <span class="m_mvOtt"><img src= "/${c_path}/img/nficon2023.ico" alt="${movie.ottName}">${movie.ottName}</span>
                                    </div>
                                    <div class="avg_box">
                                        <div class="star_icon"><img src= "/${c_path}/img/star.png" alt="★"></div>
                                        <div class="movie_avg">${movie.movScore}</div>
                                        <div class="movie_avg_cnt">( ${(movie.movScoreCnt).toLocaleString("ko")} )</div>
                                    </div>
                                </div>
                            </div>`;
        });
        return keywordList;
    };
});
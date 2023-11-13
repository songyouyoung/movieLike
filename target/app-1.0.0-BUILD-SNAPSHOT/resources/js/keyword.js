function keyword_find() {
    for(let i=0; i<6; i++) {

        let keyword_find_list = `<div class="m_mvList">
                                    <div class="m_mvPoster"><img src="./img/poster.jpg" alt=""></div>
                                    <div class="m_mvDesc">
                                        <div class="m_mvTitle">더 마블스</div>
                                        <div class="m_mvDate">2023.11.08</div>
                                        <div class="m_mvTitleEng">The Marvels</div>
                                        <div class="m_mvDescBox">
                                            <span class="m_mvDir">니아 다코스타</span><span class="m_mvCountry">미국</span>
                                        </div>
                                        <div class="m_mvDescBox">
                                            <span class="m_mvGen">액션, SF</span><span class="m_mvTime">105분</span>
                                        </div>
                                        <div class="avg_box">
                                            <div class="star_icon"><img src="./img/star.png" alt=""></div>
                                            <div class="movie_avg">4.2</div>
                                        </div>
                                    </div>
                                </div>`

        $(keyword_find_list).appendTo('.m_mvBox')
    }
}
keyword_find();
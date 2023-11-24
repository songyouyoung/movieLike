$('.review_write_move a').click(function() {

    event.preventDefault();

    let href = $(this).attr('href')

    $('html, body').animate({
        scrollTop: $(href).offset().top
    }, 1000)
})

$('.review_write_move a').click(function() {

    event.preventDefault();

    let href = $(this).attr('href')

    $('html, body').animate({
        scrollTop: $(href).offset().top
    }, 1000)

    $('.review_write').focus();
})

function writeBtnChk() {
    var starChk = $('input[name=star_rd]:checked').val();
    var contentChk = $('.review_write').val();
    if (!starChk) {
        Swal.fire({
            icon: "warning",
            title: "별점을 체크해주세요"
        });
        return null;
    }
    else if (!contentChk) {
        Swal.fire({
            icon: "warning",
            title: "리뷰 내용을 입력해주세요"
        });
        return null;
    }
    return {"starChk": starChk, "contentChk": contentChk};
}
let idChkNone = document.getElementById('login_move_popup')
function idChkPopup() {
    idChkNone.style.display = "block";
}

function closeLoginPopup() {
    idChkNone.style.display = "none";
}

let jjim = document.getElementById('jjim_img')

let jjimClick = () => {
    jjim.classList.toggle('jjim_color');
};

let watched = document.getElementById('watched_img')

let watchedClick = () => {
    watched.classList.toggle('watched_color');
}

let like = document.getElementById('like_img')
let likeClick = () => {
    like.classList.toggle('like_color');
};




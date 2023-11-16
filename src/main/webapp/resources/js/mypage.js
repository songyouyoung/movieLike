$('.btn_box a').click(function() {

    event.preventDefault();

    let href = $(this).attr('href')

    $('html, body').animate({
        scrollTop: $(href).offset().top
    }, 1000)    
})


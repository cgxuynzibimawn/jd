$(function () {
    // 配送省份
    $('#province').mouseenter(function () {
        $(this).addClass('province_hover');
    }).mouseleave(function () {
        $(this).removeClass('province_hover');
    });
});

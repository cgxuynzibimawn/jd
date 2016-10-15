$(function () {
    // 配送省份
    $('#province').mouseenter(function () {
        $(this).addClass('province_hover');
        $(this).find('#list').css('display','block');
    }).mouseleave(function () {
        $(this).removeClass('province_hover');
        $(this).find('#list').css('display','none');
    });
    //绑定省份数据
    $.ajax({
        method:'post',
        url:'ProvinceServlet',
        dataType:'json',
        success:function (listProv) {
            $.each(listProv,function (index) {
                $('#list ul').append('<li class="fz12"><a href="">'+listProv[index].name+'</a></li>');
            });
        }
    });
});

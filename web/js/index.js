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
    //异步
    $.ajax({
        //get  post
        method:'post',
        url:'ProvinceServlet',
        dataType:'json',
        success:function (listProv) {
            $.each(listProv,function (index) {
                $('#list ul').append('<li class="fz12"><a href="">'+listProv[index].name+'</a></li>');
            });
        }
    });

    //绑定一级菜单
    $.ajax({
        method:'post',
        url:'LargeMenuServlet',
        dataType:'json',
        success:function (lm) {
            $.each(lm,function (i) {
                var aList = '';
                var levelId = 0;
                $.each(lm[i],function (j,l) {
                    aList+='<a href="">'+l.name+'</a>、';
                    levelId = l.level;
                })
                aList = aList.substring(0,aList.length-1);
                $('.menu').append('<div data="'+levelId+'" class="item fz12 pl20">'+aList+'</div>');
            });
        }
    });

    $('.menu').delegate('.item',{'mouseenter':function () {
        $(this).css({'background':'#FFFFFF','border-left':'1px solid #C61A2A'});
        $(this).find('a').css('color','#C61A2A');
    },'mouseleave':function () {
        $(this).css('background','#C61A2A');
        $(this).find('a').css('color','#FFFFFF');
    }});

});

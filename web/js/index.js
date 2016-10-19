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
        data:'menu=large',
        dataType:'json',
        success:function (lm) {
            $.each(lm,function (i) {
                var aList = '';
                var levelId = 0;
                var data = 0;
                $.each(lm[i],function (j,l) {
                    aList+='<a href="">'+l.name+'</a>、';
                    levelId = l.level;
                })
                aList = aList.substring(0,aList.length-1);
                $('.menu').append('<div levelid="'+levelId+'" class="item fz12 pl20">'+aList+'</div>');
                //创建dropdown_layer div节点
                var down_div = '<div class="dropdown_layer" levelid="'+levelId+'"></div>';
                $('.menu').append(down_div);
            });
        }
    });

    $('.menu').delegate('.item',{'mouseenter':function () {
        $(this).css({'background':'#FFFFFF','border-left':'1px solid #C61A2A'});
        $(this).find('a').css('color','#C61A2A');
        //判断当前哪个SmallMenu显示
        var levelid = parseInt($(this).attr('levelid'));
        $.each($('.dropdown_layer'),function (i) {
            if($(this).attr('levelId')==levelid){
                $(this).css('display','block').siblings('.dropdown_layer').css('display','none');
            }
        });
        //获取当前item的levelid数据
        var levelid = parseInt($(this).attr('levelid'));
        //读取MiddleMenu 和 SmallMenu 显示项
        //console.log(mmList(levelid));
        var ml = mmList(levelid);
        $('.dropdown_layer').html('');
        $.each(ml,function (i) {
            //mmList[i] 二级菜单
            $('.dropdown_layer[levelid='+ml[i].level+']').append('<dl><dt><span>'+ml[i].name+'</span></dt><dd data="'+ml[i].id+'"></dd></dl>');
            var $dl = $('.dropdown_layer[levelid='+ml[i].level+']').find('dl');
            //console.log(smList(levelid));
            var sl = smList(levelid,ml[i].id);
            console.log(sl);
            $.each(sl,function (j) {
                //smList[j] 三级菜单
                $('.dropdown_layer dl [data="'+ml[i].id+'"]').append('<a href="">'+sl[j].name+'</a>');
                //$dl.find('dd').append('<a href="">'+sl[j].name+'</a>');
            });
        });

    },'mouseleave':function () {
        $(this).css('background','#C61A2A');
        $(this).find('a').css('color','#FFFFFF');
        //$('.dropdown_layer').css('display','none');
    }});

    $('.menu').delegate('.dropdown_layer','mouseleave',function () {
        $(this).fadeOut(0);
    })
    // $('.dropdown_layer').mouseleave(function () {
    //     $(this).fadeOut(0);
    // });

    // 焦点图轮换效果
    $.ajax({
        method:'post',
        url:'BannerServlet',
        dataType:'json',
        success:function (bannerList) {
            $.each(bannerList,function (i) {
                $('.banner').prepend('<div class="list" style="background-image: url(images/banner/'+bannerList[i].name+')"></div>');

            });
        }
    });


    var i = 0;
    var stop = false;
    var bannerTimer = setInterval(function () {
        if(stop) return;
        $('.banner .list').stop(true,true).eq(i).fadeIn(1000).siblings('.list').fadeOut(500);
        $('.slider_item').eq(i).addClass('list_focus').siblings().removeClass('list_focus');
        i++;
        if(i==$('.banner .list').length){
            i=0;
        }
    },2000);

    $('.slider_item').mouseenter(function () {
        stop = true;
        var index = $(this).index('.slider_item');
        $(this).addClass('list_focus').siblings().removeClass('list_focus');
        $('.banner .list').stop(true,true).eq(index).fadeIn(1000).siblings('.list').fadeOut(500);
        i = index;
    }).mouseleave(function () {
        stop = false;
    });



});
function mmList(levelid) {
    var list;
    $.ajax({
        method:'post',
        url:'MiddleMenuServlet',
        data:'level_id='+levelid+'&menu=middle',
        dataType:'json',
        async:false,
        //mmList middlemenuList
        success:function (ml) {
            list = ml;
        }
    });
    return list;
}

function smList(levelid,middleid) {
    var list;
    $.ajax({
        method:'post',
        url:'SmallMenuServlet',
        data:'middle_id='+middleid+'&level_id='+levelid+'&menu=small',
        dataType:'json',
        async:false,
        success:function (sl) {
            list = sl;
        }
    });
    return list;
}



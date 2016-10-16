<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="css/login.css">
</head>
<body>
    <div class="container">
        <div id="header" class="ovh">
            <div class="pt20 pl20">
                <img src="images/logo.png" alt="">
                <b class="fz20 ml20"><img src="images/l-icon.png" alt=""></b>
            </div>
        </div>
        <div id="login">
            <div id="login_form">
                <div class="login-tab login-tab-l">
                    <a href="javascript:void(0)">
                        扫码登录
                    </a>
                </div>
                <div class="login-tab login-tab-r">
                    <a href="javascript:void(0)" class="checked">
                        账户登录
                    </a>
                </div>

                <div class="tip posr fz12">
                    <b></b>
                    <span style="color: #6F6D6A">公共场所不建议自动登录，以防账号丢失</span>
                </div>
                <%--表单开始--%>
                <form action="control/login_ctrl.jsp" method="post" name="login">
                    <div class="item">
                        <b style="background: #fff url('images/pwd-icons-new.png') no-repeat 0px 0px;"></b>
                        <input type="text" placeholder="邮箱/用户名/已验证手机" name="username" />
                        <b class="close"></b>
                    </div>
                    <div class="item">
                        <b style="background: #fff url('images/pwd-icons-new.png') no-repeat -48px 0px;"></b>
                        <input type="password" placeholder="密码" name="password" />
                        <b class="close"></b>
                    </div>

                    <div class="item remeber_pwd">
                        <input type="checkbox" name="pwd" class="vam" id="pwd" /><label class="fz12" for="pwd">自动登录</label>
                        <label class="forget_pwd fz12" for="pwd"><a href="">忘记密码</a></label>
                    </div>

                    <div class="login_btn">
                        <a href="javascript:void(0)" onclick="subForm()" class="btn-img btn-entry" id="loginsubmit" tabindex="6">登&nbsp;&nbsp;&nbsp;&nbsp;录</a>
                    </div>
                </form>
                <%--表单结束--%>
            </div>
        </div>
        <div class="w">
            <div id="footer-2013">
                <div class="links">
                    <a rel="nofollow" target="_blank" href="//www.jd.com/intro/about.aspx">
                        关于我们
                    </a>
                    |
                    <a rel="nofollow" target="_blank" href="//www.jd.com/contact/">
                        联系我们
                    </a>
                    |
                    <a rel="nofollow" target="_blank" href="//zhaopin.jd.com/">
                        人才招聘
                    </a>
                    |
                    <a rel="nofollow" target="_blank" href="//www.jd.com/contact/joinin.aspx">
                        商家入驻
                    </a>
                    |
                    <a rel="nofollow" target="_blank" href="//www.jd.com/intro/service.aspx">
                        广告服务
                    </a>
                    |
                    <a rel="nofollow" target="_blank" href="//app.jd.com/">
                        手机京东
                    </a>
                    |
                    <a target="_blank" href="/links.vm/club.jd.com/links.aspx">
                        友情链接
                    </a>
                    |
                    <a target="_blank" href="//media.jd.com/">
                        销售联盟
                    </a>
                    |
                    <a href="//club.jd.com/" target="_blank">
                        京东社区
                    </a>
                    |
                    <a href="//gongyi.jd.com" target="_blank">
                        京东公益
                    </a>
                    |
                    <a target="_blank" href="//en.jd.com/" clstag="pageclick|keycount|20150112ABD|9">English Site</a>
                </div>
                <div class="copyright">
                    Copyright&nbsp;©&nbsp;2004-2016&nbsp;&nbsp;京东JD.com&nbsp;版权所有
                </div>
            </div>
        </div>
    </div>
</body>
<script src="js/jquery-2.2.4.js"></script>
<script src="js/login.js"></script>
</html>

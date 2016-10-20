<%@ page import="entity.Users" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <title>京东(JD.COM)-综合网购首选-正品低价、品质保障、配送及时、轻松购物！</title>
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="css/index.css">
    <link rel="icon" href="localhost:8080/jd.com/images/favicon.ico" type="image/x-icon">
  </head>
  <body>
    <div class="container">
        <%--头部开始--%>
      <div class="header">
        <div id="province" class="fl pt10 pb10 pl20 ml20 posr">
          <p class="fz12">送至:北京</p>
          <div id="list" class="posa" style="display: none;">
            <ul></ul>
          </div>
        </div>
        <div id="login" class="fz12 fr mt10 mb10">
          <ul>
            <li>
              <%--JSTL--%>
              <%--自定义标签--%>
              <%--$()jQuery   ${}EL表达式 JSP--%>
              <c:choose>
                <c:when test="${sessionScope.users!=null}">
                  <a href="login.jsp">你好，${sessionScope.users.username}</a>
                </c:when>
                <c:otherwise>
                  <a href="login.jsp">你好，请登录</a>
                </c:otherwise>
              </c:choose>
            </li>
            <li>
              <c:choose>
                <c:when test="${sessionScope.users!=null}">
                  <a style="color:#C81623" href="">退出</a>
                </c:when>
                <c:otherwise>
                  <a style="color:#C81623" href="">免费注册</a>
                </c:otherwise>
              </c:choose>
              </li>
            <li><a href="">我的订单</a></li>
            <li><a href="">我的京东</a></li>
            <li><a href="">京东会员</a></li>
            <li><a href="">企业采购</a></li>
            <li><a href="">手机京东</a></li>
            <li><a href="">关注京东</a></li>
            <li><a href="">客户服务</a></li>
            <li><a href="">网站导航</a></li>
          </ul>
        </div>
      </div>
      <%--头部结束--%>
      <%--搜索部分开始--%>
      <div id="search" class="m0 mt10 ovh">
          <div class="logo mt10"><img src="images/logo.png" alt=""></div>
          <div class="find mt20">
              <input class="fz14 pl20" style="border:none;width:456px;height: 36px; color: #717171;" placeholder="显示器" type="text" name="findGoods" />
              <button class="fz14">搜&nbsp;&nbsp;索</button>
          </div>
          <div class="cartshop mt20 posr">
              <div class="cs_btn">
                  <i class="icon mt10 ml10"></i>
                  <span><a href="">我的购物车</a></span>
                  <i class="ci-count" id="shopping-amount">0</i>
              </div>
          </div>
      </div>
      <%--搜索部分结束--%>
      <%--导航部分开始--%>
      <div id="nav" class="mt10">
        <div class="dt fl">
            <a target="_blank" href="#">全部商品分类</a>
        </div>
        <div class="nav_list ovh">
            <ul class="ovh ml20">
                <li><a href="">服装城</a></li>
                <li><a href="">美妆馆</a></li>
                <li><a href="">京东超市</a></li>
                <li><a href="">生鲜</a></li>
                <li><a href="">全球购</a></li>
                <li><a href="">闪购</a></li>
                <li><a href="">团购</a></li>
                <li><a href="">拍卖</a></li>
                <li><a href="">金融</a></li>
            </ul>
        </div>
      </div>
      <%--导航部分结束--%>
      <%--菜单,二级菜单,焦点图,京东快报--%>
      <div id="banner_list" class="posr">
          <div class="menu ml20 fl posr">
          </div>

          <div class="banner fl ovh ml10 posr">
              <div class="slider_nav posa">
                  <ul>
                      <li class="slider_item list_focus">1</li>
                      <li class="slider_item">2</li>
                      <li class="slider_item">3</li>
                      <li class="slider_item">4</li>
                      <li class="slider_item">5</li>
                      <li class="slider_item">6</li>
                  </ul>
              </div>
          </div>
      </div>
      <%--菜单,二级菜单,焦点图,京东快报--%>
     </div>
  </body>
  <script src="js/jquery-2.2.4.js"></script>
  <script src="js/index.js"></script>
</html>

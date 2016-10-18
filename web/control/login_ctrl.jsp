<%@ page import="entity.Users" %>
<%@ page import="dao.impl.UsersDaoImpl" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    //获取用户名和密码
    String username = request.getParameter("username");
    String password = request.getParameter("password");
    Users u = new UsersDaoImpl().login(username,password);
    if(u!=null){
        session.setAttribute("users",u);
        session.setMaxInactiveInterval(60 * 10);//设置会话有效期为10分钟
        //重定向
        response.sendRedirect("../index.jsp");
    }
%>

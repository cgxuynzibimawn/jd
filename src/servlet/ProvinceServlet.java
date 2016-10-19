package servlet;

import com.alibaba.fastjson.JSON;
import dao.impl.ProvinceDaoImpl;
import entity.Province;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "ProvinceServlet",urlPatterns = "/ProvinceServlet")
public class ProvinceServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        List<Province> list = new ProvinceDaoImpl().getAll();
        //fastJSON alibaba
        String jsonStr = JSON.toJSONString(list);
        PrintWriter out = response.getWriter();
        out.print(jsonStr);
        out.flush();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}

package servlet;

import com.alibaba.fastjson.JSON;
import dao.LargeMenuDao;
import dao.impl.LargeMenuDaoImpl;
import entity.LargeMenu;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

/**
 * Created by guoyisha on 2016/10/17.
 */
@WebServlet(name = "LargeMenuServlet", urlPatterns = "/LargeMenuServlet")
public class LargeMenuServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        LargeMenuDao mldao = new LargeMenuDaoImpl();
        Map<String, List<LargeMenu>> maps = mldao.getAllLargeMenu();
        String str = JSON.toJSONString(maps);
        out.print(str);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}

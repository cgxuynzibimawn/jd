package servlet;

import com.alibaba.fastjson.JSON;
import dao.LargeMenuDao;
import dao.MiddleMenuDao;
import dao.impl.LargeMenuDaoImpl;
import dao.impl.MiddleMenuDaoImpl;
import dao.SmallMenuDao;
import dao.impl.SmallMenuDaoImpl;
import entity.LargeMenu;
import entity.MiddleMenu;
import entity.SmallMenu;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

@WebServlet(name = "MenuServlet", urlPatterns = {"/LargeMenuServlet","/MiddleMenuServlet","/SmallMenuServlet"})
public class MenuServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        String menu = request.getParameter("menu");
        String outStr = "";
        if(menu==null || menu.equals("")){

        }else if(menu.equals("large")){
            LargeMenuDao ldao = new LargeMenuDaoImpl();
            Map<String, List<LargeMenu>> maps = ldao.getAllLargeMenu();
            outStr = JSON.toJSONString(maps);
        }else if(menu.equals("middle")){
            Integer levelid = Integer.parseInt(request.getParameter("level_id"));
            MiddleMenuDao mdao = new MiddleMenuDaoImpl();
            List<MiddleMenu> list = mdao.getByLevelId(levelid);
            outStr = JSON.toJSONString(list);
        }else if(menu.equals("small")){
            Integer levelid = Integer.parseInt(request.getParameter("level_id"));
            Integer middleid = Integer.parseInt(request.getParameter("middle_id"));
            SmallMenuDao sdao = new SmallMenuDaoImpl();
            List<SmallMenu> list = sdao.getSmallMenu(levelid,middleid);
            outStr = JSON.toJSONString(list);
        }
        out.print(outStr);
        out.flush();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}

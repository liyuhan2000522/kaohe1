package hengzhi.servlet.main;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import hengzhi.entity.DaoHang;
import hengzhi.service.DaoHangService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/initDaohang")
public class daohangServlet  extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        //初始化查询
       /* DaoHang daoHang = new DaoHang("首页","index.html");
        DaoHang daoHang2 = new DaoHang("新闻展示页","list.html?type=1");
        DaoHang daoHang3 = new DaoHang("公告展示页","list.html?type=2");
        DaoHang daoHang4 = new DaoHang("学校主页","http://www.nenu.edu.cn/");
        List<DaoHang>  list = new ArrayList<DaoHang>();
        list.add(daoHang);
        list.add(daoHang2);
        list.add(daoHang3);
        list.add(daoHang4);*/

        DaoHangService daoHangService = new DaoHangService();
        List<DaoHang>  list =daoHangService.getDaoHangList(1);
        PrintWriter printWriter = response.getWriter();
        JSONObject json = new JSONObject();
        json.put("list",list);
        printWriter.print(json);//返给ajax请求
        printWriter.flush();
        printWriter.close();
    }


}

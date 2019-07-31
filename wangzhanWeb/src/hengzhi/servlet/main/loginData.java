package hengzhi.servlet.main;

import com.alibaba.fastjson.JSONObject;
import hengzhi.entity.DaoHang;
import hengzhi.entity.UserInfo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/loginData")
public class loginData  extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter printWriter = response.getWriter();
        JSONObject json = new JSONObject();
        Object obj = request.getSession().getAttribute("userLogin");
        UserInfo userInfo = (UserInfo)obj;
        json.put("obj",userInfo);
        printWriter.print(json);//返给ajax请求
        printWriter.flush();
        printWriter.close();
    }



}

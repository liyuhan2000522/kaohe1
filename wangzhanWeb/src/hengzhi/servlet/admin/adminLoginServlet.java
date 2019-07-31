package hengzhi.servlet.admin;


import hengzhi.entity.UserInfo;
import hengzhi.service.UserService;
import hengzhi.util.MD5util;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/adminLogin")
public class adminLoginServlet extends HttpServlet {

    UserService userService = new UserService();

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 响应和请求都设置成utf-8的编码
        request.setCharacterEncoding("utf-8");
        String method = request.getParameter("method");
        if(method.equals("1")){
            request.getRequestDispatcher("/html/admin/common/Login.jsp").forward(request, response);
        }
        //登陆
        if(method.equals("2")){
            //获取账号密码验证码
            String userName = (String) request.getParameter("username");
            String passWd = (String) request.getParameter("password");
            String code = request.getParameter("validateCode");
            response.setContentType("text/html;charset=utf-8");
            //session的验证码
            String  checkcode = request.getSession().getAttribute("checkcode")==null?"":(String)request.getSession().getAttribute("checkcode");
            //验证码验证通过
            if (checkcode.equalsIgnoreCase(code)) {
                UserInfo user = userService.getUserInfoByUserName(userName,1);
                if (MD5util.MD5Encode(passWd, "UTF-8").equals(user.getPassword())) {
                    request.getSession().setAttribute("user",user);
                    request.setAttribute("info", "登录完成");
                    request.getRequestDispatcher("/html/admin/Index.jsp").forward(request, response);
                } else {
                    request.setAttribute("info", "密码不一致");
                    request.getRequestDispatcher("/html/admin/common/Login.jsp").forward(request, response);
                }
            }else{
                request.setAttribute("info", "验证码失败");
                request.getRequestDispatcher("/html/admin/common/Login.jsp").forward(request, response);
            }
        }
        //注销
        if(method.equals("3")){
            request.getRequestDispatcher("/html/admin/common/Login.jsp").forward(request, response);
        }
    }

}

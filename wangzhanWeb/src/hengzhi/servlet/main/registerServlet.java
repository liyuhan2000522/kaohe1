package hengzhi.servlet.main;

import com.alibaba.fastjson.JSONObject;

import hengzhi.entity.UserInfo;
import hengzhi.service.UserService;
import hengzhi.util.DateUtil;
import hengzhi.util.MD5util;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@WebServlet("/register")
@MultipartConfig
public class registerServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
            req.setCharacterEncoding("utf-8");
            resp.setContentType("text/html;charset=utf-8");
            JSONObject json = new JSONObject();
            //获取账号
            String userName = req.getParameter("username");
            //密码
            String password = req.getParameter("password");
            //年龄
            String age = req.getParameter("age");
            //新增用户
            UserService userService = new UserService();
            //查询用户是否存在
            UserInfo userInfo = userService.getUserInfoByUserName(userName,0);
            if(userInfo.getUsername() != null && !userInfo.equals("") && userInfo.getUsername() != "null"){
                req.setAttribute("info", "账号已存在");
                req.getRequestDispatcher("/html/loginRegister/register.jsp").forward(req, resp);
            }else{
                UserInfo user = new UserInfo();
                user = new UserInfo(userName, MD5util.MD5Encode(password,"UTF-8"),initImgUrl(req),Integer.parseInt(age), DateUtil.dateFormat(new Date(),DateUtil.HOUR_PATTERN),0);
                userService.addUserInfo(user);
                req.setAttribute("info", "注册成功，请登录");
                req.getRequestDispatcher("/html/loginRegister/register.jsp").forward(req, resp);
            }
    }

    //处理文件上传
    public String  initImgUrl(HttpServletRequest request) throws IOException, ServletException {
        //获取上传的文件
        Part part=request.getPart("image");
        
        //获取请求的信息
        String name=part.getHeader("content-disposition");
        //获取上传文件的目录
        String root=request.getServletContext().getRealPath("/upload");
        //获取文件的后缀
        String str=name.substring(name.lastIndexOf("."), name.length()-1);
        //生成一个新的文件名，不重复，数据库存储的就是这个文件名，不重复的
        String fname= UUID.randomUUID().toString()+str;
        String filename=root+"\\"+fname;
        File file  = new File(root);
        if(!file.exists()){
            file.mkdir();
        }
        //上传文件到指定目录，不想上传文件就不调用这个
        part.write(filename);
        return "upload/"+fname;
    }
}

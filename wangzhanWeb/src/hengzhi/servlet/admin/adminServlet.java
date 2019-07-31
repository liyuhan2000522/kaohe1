package hengzhi.servlet.admin;

import hengzhi.entity.DaoHang;
import hengzhi.entity.UserInfo;
import hengzhi.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/admin")
public class adminServlet extends HttpServlet {
	UserService service = new UserService();
	
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	UserInfo user = (UserInfo) req.getSession().getAttribute("user");
    	if(user != null){
    		doPost(req, resp);
    	}else{
    		resp.sendRedirect("/wangzhanWeb/main");
    	}
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	//查询管理员审核
    	String type = req.getParameter("type");
    	String pageNo = req.getParameter("pageNo")==null?"1":req.getParameter("pageNo");
    	if(type != null && type.equals("1")){
    	        //搜索条件
    	        List<UserInfo> list = new ArrayList<UserInfo>();
    	        list = service.getUserInfoList(Integer.parseInt(pageNo));
    	        if(list != null && !list.isEmpty() && list.size() > 0){
    	        	req.setAttribute("list",list);
    	        }
    		req.getRequestDispatcher("/html/admin/AdminManager.jsp").forward(req, resp);
    	}
    	//修改状态
    	String edit = req.getParameter("edit");
    	if(edit != null && !edit.equals("")){
    		String id = req.getParameter("id");
    		UserInfo userinfo = new UserInfo();
    		userinfo.setId(Integer.valueOf(id));
    		userinfo.setState(Integer.valueOf(edit));
    		service.upState(userinfo);
    		req.getRequestDispatcher("/html/admin/AdminManager.jsp").forward(req, resp);
    	}
    	
    }
}

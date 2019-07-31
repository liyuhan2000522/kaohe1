package hengzhi.servlet.admin;

import hengzhi.entity.DaoHang;
import hengzhi.entity.News;
import hengzhi.entity.UserInfo;
import hengzhi.service.DaoHangService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/daoHang")
public class daoHangServlet extends HttpServlet {
	DaoHangService service = new DaoHangService();
	
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
    	
    	//当前页
        String pageNo = req.getParameter("pageNo")==null?"1":req.getParameter("pageNo");
        String dh = req.getParameter("dh");
        if(dh != null && !dh.equals("")){
	        //搜索条件
	        String  SearchRow = req.getParameter("SearchRow");
	        String SearchKey = req.getParameter("SearchKey");
	        List<DaoHang> list = new ArrayList<DaoHang>();
	        list = service.getDaoHangList(Integer.parseInt(pageNo));
	        if(list != null && !list.isEmpty() && list.size() > 0){
	        	req.setAttribute("list",list);
	        }
	        req.getRequestDispatcher("/html/admin/DaoHangManager.jsp").forward(req, resp);
        }
        
        //修改
        String update = req.getParameter("update");
        if(update != null && update.equals("update")){
        	update(req, resp);
        }
        
        //编辑
        String edit = req.getParameter("edit");
        if(edit != null && edit.equals("edit")){
        	edit(req, resp);
        }
        
        //新增
        String add = req.getParameter("add");
        if(add != null && add.equals("add")){
        	add(req, resp);
        }
        
        //删除
        String del = req.getParameter("del");
        if(del != null && del.equals("del")){
        	del(req, resp);
        }
        
        
        
    }
    
    //修改
    public String update(HttpServletRequest req, HttpServletResponse resp){
    	String title = req.getParameter("daoHangTitle");
    	String url = req.getParameter("daoHangUrl");
    	String id = req.getParameter("id");
    	try {
			title = new String(title.getBytes("iso-8859-1"),"UTF-8");
			url = new String(url.getBytes("iso-8859-1"),"UTF-8");
			DaoHang daohang = new DaoHang(Integer.valueOf(id),title,url);
			service.upDaoHang(daohang);
    	
    	
    	} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	return "";
    }
    
  //编辑新闻
    public String edit(HttpServletRequest req, HttpServletResponse resp){
    	String id = req.getParameter("id");
    	try {
    		DaoHang daohang = service.getDaoHang(Integer.valueOf(id));
    		req.setAttribute("daohang", daohang);
    		req.getRequestDispatcher("/html/admin/DaoHang/editDaoHang.jsp").forward(req, resp);
    	} catch (Exception e) {
    		// TODO Auto-generated catch block
    		e.printStackTrace();
    	}
    	
    	return "";
    }
    
    //删除
    public String del(HttpServletRequest req, HttpServletResponse resp){
    	
    	String id = req.getParameter("id");
    	System.out.println(id);
    	try {
        	service.delete(Integer.valueOf(id));
        	resp.sendRedirect("/wangzhanWeb/daoHang?dh=1");
        	
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    	
    	return "";
    }
    
    //新增
    public String add(HttpServletRequest req, HttpServletResponse resp){
    	String title = req.getParameter("daoHangTitle");
    	String url = req.getParameter("daoHangUrl");
    	try {
			title = new String(title.getBytes("iso-8859-1"),"UTF-8");
			url = new String(url.getBytes("iso-8859-1"),"UTF-8");
			DaoHang daohang = new DaoHang(title,url);
			service.addDaoHang(daohang);
    	
    	
    	} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	return "";
    }
    


}

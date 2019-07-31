package hengzhi.servlet.admin;

import hengzhi.entity.News;
import hengzhi.entity.SortInfo;
import hengzhi.entity.UserInfo;
import hengzhi.service.NewsService;
import hengzhi.service.SortInfoService;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/sort")
public class sortServlet extends HttpServlet {
	
	SortInfoService service = new SortInfoService();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserInfo user = (UserInfo) request.getSession().getAttribute("user");
    	if(user != null){
    		doPost(request, response);
    	}else{
    		response.sendRedirect("/wangzhanWeb/main");
    	}
	}
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		String sy = req.getParameter("sy");
		if(sy != null && !sy.equals("")){
			//当前页
			String pageNo = req.getParameter("pageNo")==null?"1":req.getParameter("pageNo");
			//搜索条件
			String  SearchRow = req.getParameter("SearchRow");
			String SearchKey = req.getParameter("SearchKey");
			
			req.setAttribute("sortInfo", service.getSortList(Integer.valueOf(pageNo)));
			req.getRequestDispatcher("/html/admin/SortInfoManager.jsp").forward(req, resp);
		}
		
		//新增
		String add = req.getParameter("add");
		if(add != null && add.equals("add")){
			addSort(req, resp);
		}
	
		//删除
		String del = req.getParameter("del");
		if(del != null && del.equals("del")){
			del(req, resp);
		}
		
		//编辑
		String edit = req.getParameter("edit");
		if(edit != null && edit.equals("edit")){
			edit(req, resp);
		}
		
		//修改
		String update = req.getParameter("update");
		if(update != null && update.equals("update")){
			update(req, resp);
		}
		
	}
	
	public String update(HttpServletRequest req, HttpServletResponse resp){
		try {
			String id = req.getParameter("id");
			String sortName = req.getParameter("sortName");
			sortName = new String(sortName.getBytes("iso-8859-1"),"UTF-8");
			SortInfo sortInfo = new SortInfo();
			sortInfo.setId(Integer.valueOf(id));
			sortInfo.setSortName(sortName);
			service.upSortInfo(sortInfo);
			req.getRequestDispatcher("/html/admin/Sort/editSort.jsp").forward(req, resp);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return "";
	}
	
	public String edit(HttpServletRequest req, HttpServletResponse resp){
		
		try {
		String id = req.getParameter("id");
		SortInfo sortinfo = service.getSortInfo(Integer.valueOf(id));
		req.setAttribute("sortinfo", sortinfo);
//		System.out.println(sortinfo.getSortName());
			req.getRequestDispatcher("/html/admin/Sort/editSort.jsp").forward(req, resp);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "";
	}
	
	//删除
	public String del(HttpServletRequest req, HttpServletResponse resp){
		String sortid = req.getParameter("sortid");
		try {
		service.deleteSortInfo(Integer.valueOf(sortid));
			req.getRequestDispatcher("/sort?sy=1").forward(req, resp);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "";
	}
	
	//新增
	public String addSort(HttpServletRequest req, HttpServletResponse resp){
		
		String sortName = req.getParameter("sortName");
		try {
			sortName = new String(sortName.getBytes("iso-8859-1"),"UTF-8");
		SortInfo sortInfo = new SortInfo();
		sortInfo.setSortName(sortName);
		service.addSortInfo(sortInfo);
		req.getRequestDispatcher("/html/admin/SortInfoManager.jsp").forward(req, resp);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}

}

package hengzhi.servlet.admin;

import hengzhi.entity.News;
import hengzhi.entity.UserInfo;
import hengzhi.service.NewsService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@WebServlet("/news")
public class newsServlet extends HttpServlet {

    NewsService service = new NewsService();
    String title;

    public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	UserInfo user = (UserInfo) req.getSession().getAttribute("user");
    	if(user != null){
    		doPost(req, resp);
    	}else{
    		resp.sendRedirect("/wangzhanWeb/adminLogin?method=1");
    	}
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
  
    		//获取类型
            String type = req.getParameter("type");
			String sortId = req.getParameter("sortid")==null?"":req.getParameter("sortid");
            if(type != null && !type.equals("")){
            	//当前页
                String pageNo = req.getParameter("pageNo")==null?"1":req.getParameter("pageNo");
                //搜索条件
                String  SearchRow = req.getParameter("SearchRow");
                String SearchKey = req.getParameter("SearchKey");
                //新闻
                if(type.equals("1") || sortId.equals("1")){
                    req.setAttribute("totalPage",service.getTotalPage(1));
                    List<News> list = new ArrayList<News>();
                    list = service.getNewsList(Integer.parseInt(pageNo),1);
                    if(list != null && !list.isEmpty() && list.size() > 0){
                    	req.setAttribute("list",list);
                    }
                    req.getRequestDispatcher("/html/admin/NewsManager.jsp").forward(req, resp);
                 }
                //公告
                if(type.equals("2") || sortId.equals("2")){
                    req.setAttribute("totalPage",service.getTotalPage(2));
                    req.setAttribute("list",service.getNewsList(Integer.parseInt(pageNo),2));
                    req.getRequestDispatcher("/html/admin/NoticeManager.jsp").forward(req, resp);
                }
            }
            //新增
            String add = req.getParameter("add");
            if(add != null && !add.equals("")){
            	addNews(req, resp);
				resp.sendRedirect("news?sortid="+sortId);
            }
            
            //删除
            String del = req.getParameter("del");
            if(del != null && del.equals("del")){
            	delNews(req, resp);
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
    
    //添加新闻/公告
    public String addNews(HttpServletRequest req, HttpServletResponse resp){
	    	String rescode = "";
    	try {
			req.setCharacterEncoding("UTF-8");
			resp.setCharacterEncoding("UTF-8");
	    	String title = req.getParameter("title");
	    	String content = req.getParameter("content");
	    	title = new String(title.getBytes("iso-8859-1"),"UTF-8");
	    	content = new String(content.getBytes("iso-8859-1"),"UTF-8");
	    	DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	    	String sortid = req.getParameter("sortid");
			String newsType = req.getParameter("newsType");
	    	NewsService newsService = new NewsService();
	    	UserInfo user = (UserInfo) req.getSession().getAttribute("user");
	    	
	    	//查询最大ID
	    	News news = new News();
	    	news.setTitle(title);
	    	news.setContent(content);
	    	news.setSortId(Integer.valueOf(sortid));
	    	news.setAuthor(user.getUsername());
	    	newsService.addNews(news);
	    	rescode = "保存成功";
	    	req.setAttribute("rescode", rescode);
    	} catch (Exception e) {
    		rescode = "保存失败";
    		req.setAttribute("rescode", rescode);
    		e.printStackTrace();
    	}
    	
    	return rescode;
    }
    
    //删除新闻
    public String delNews(HttpServletRequest req, HttpServletResponse resp){
    	
    	String rescode = "";
	try {
    	String title = req.getParameter("title");
    	title = new String(title.getBytes("iso-8859-1"),"UTF-8");
    	service.deleteNewsByTit(title);
    	String sortid = req.getParameter("sortid");
    	if(sortid.equals("1")){
    		resp.sendRedirect("/wangzhanWeb/news?type=1");
    	}else if(sortid.equals("2")){
    		resp.sendRedirect("/wangzhanWeb/news?type=2");
    	}
    	
    	rescode = "0000";
	} catch (Exception e) {
		rescode = "9999";
		e.printStackTrace();
	}
	
	return rescode;
}


    //编辑新闻
    public String edit(HttpServletRequest req, HttpServletResponse resp){
    	String id = req.getParameter("id");
    	try {
    		News news = service.getNewsInfo(Integer.valueOf(id));
    		req.setAttribute("news", news);
    		req.getRequestDispatcher("/html/admin/News/editNews.jsp").forward(req, resp);
    	} catch (Exception e) {
    		// TODO Auto-generated catch block
    		e.printStackTrace();
    	}
    	
    	return "";
    }

    
    //修改内容
    public String update(HttpServletRequest req, HttpServletResponse resp){
    	
    	String title = req.getParameter("title");
    	String id = req.getParameter("id");
    	String content = req.getParameter("content");
    	try {
			title = new String(title.getBytes("iso-8859-1"),"UTF-8");
	    	content = new String(content.getBytes("iso-8859-1"),"UTF-8");
	    	
	    	UserInfo user = (UserInfo) req.getSession().getAttribute("user");
	    	
	    	News news = new News();
	    	news.setTitle(title);
	    	news.setContent(content);
	    	news.setAuthor(user.getUsername());
	    	news.setId(Integer.valueOf(id));
	    	service.upNews(news);
	    	
    	} catch (Exception e) {
			e.printStackTrace();
		}
	    	
    	return "";
    }
    
    
    

}

package hengzhi.servlet.main;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import hengzhi.entity.News;
import hengzhi.service.NewsService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


/**
 * 新闻
 */
@WebServlet("/initNews")
public class newsServlet  extends HttpServlet {


    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String type = request.getParameter("type");
        String page = request.getParameter("pageNo");
        if (page == null || page.equals("")) {
            page = "1";
        }
        //新闻列表 type 1 type2 公告列表
        NewsService news = new NewsService();
        List<News> newsList = news.getNewsList(Integer.parseInt(page), Integer.parseInt(type));
        PrintWriter printWriter = response.getWriter();
        JSONArray array= JSONArray.parseArray(JSON.toJSONString(newsList));
        //总数
        int totalPage = news.getTotalPage(Integer.parseInt(type));
        JSONObject json = new JSONObject();
        json.put("totalPage",totalPage);
        json.put("pageNo",Integer.parseInt(page));
        json.put("list",newsList);
        printWriter.print(json);//返给ajax请求
        printWriter.flush();
        printWriter.close();
    }

}

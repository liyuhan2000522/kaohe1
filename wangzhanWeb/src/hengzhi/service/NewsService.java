package hengzhi.service;

import hengzhi.dao.NewsDao;
import hengzhi.entity.News;

import java.util.List;

public class NewsService {

  static  NewsDao dao = new NewsDao();

    //分页查询列表
    public List<News> getNewsList(int pageNo, int sortId){
        return dao.getNewsList(pageNo,sortId);
    }
    //查询总数
    public static int getTotalPage(int sortId) {
        return dao.getTotalPage(sortId);
    }

    //查询单条最大id
    public News getMaxNews(){
        return dao.getMaxNews();
    }
    
    //查询单条详情
    public News getNewsInfo(int id){
        return dao.getNewsInfo(id);
    }
    //新增单条
    public static int addNews(News news) {
       return dao.addNews(news);
    }
    //修改单条
    public static int upNews(News news) {
        return dao.upNews(news);
    }
    //删除单条
    public int deleteNews(int id) {
        return dao.deleteNews(id);
    }
  //通过名字删除单条
    public int deleteNewsByTit(String title) {
        return dao.deleteNewsByTit(title);
    }

}

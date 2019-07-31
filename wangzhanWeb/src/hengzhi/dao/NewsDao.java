package hengzhi.dao;

import hengzhi.entity.News;
import hengzhi.util.DateUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//新闻相关
public class NewsDao {

    //每页条数
    private static int pagesize = 10;

    //分页查询列表
    public List<News> getNewsList(int pageNo,int sortId){
        List<News> list = new ArrayList<News>();
        int begin = (pageNo-1)*pagesize;
        int end = pagesize;
        DBUtil db = new DBUtil();
        Connection conn = null;
        ResultSet rs = null;
        try {
            conn = db.getConnection();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String sql = "SELECT * FROM t_news where 1=1 and sort_id="+sortId+" limit "+begin+","+end;
        try {
            PreparedStatement statement = conn.prepareStatement(sql);
            rs = statement.executeQuery();
            while (rs.next()) {
                News news = new News();
                // 将数据库的数据转换成POJO实例
                news.setId(rs.getInt("id"));
                news.setAlterTime(rs.getString("alter_time"));
                news.setAuthor(rs.getString("author"));
                news.setContent(rs.getString("content"));
                news.setSortId(rs.getInt("sort_id"));
                news.setTitle(rs.getString("title"));
                news.setWriteTime(rs.getString("write_time"));
                list.add(news);
            }
        } catch (Exception ex){
            ex.printStackTrace();
        }finally {
            //关闭
            DBUtil.closeConnection(conn);
        }
        return list;

    }
    //查询总数
    public static int getTotalPage(int sortId) {
        int totalCount = 0;
        int totalPage = 0;
        Connection conn = null;
        DBUtil db = new DBUtil();
        ResultSet rs = null;
        try {
            conn = db.getConnection();
            String sql = "SELECT count(id) FROM t_news where 1=1 and sort_id="+sortId;
            PreparedStatement statement = conn.prepareStatement(sql);
            rs = statement.executeQuery();
            if(rs.next()){
                totalCount = rs.getInt(1);
                totalPage = (totalCount-1)/pagesize+1;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            //关闭
            DBUtil.closeConnection(conn);
        }
        return totalPage;
    }

    //查询最大用户id
    public News getMaxNews(){
        News news = new News();
        DBUtil db = new DBUtil();
        Connection conn = null;
        ResultSet rs = null;
        try {
            conn = db.getConnection();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String sql = "SELECT max(id) FROM t_news ";
        try {
            PreparedStatement statement = conn.prepareStatement(sql);
            rs = statement.executeQuery();
            while (rs.next()) {
                // 将数据库的数据转换成POJO实例
                news.setId(rs.getInt("id") + 1);
            }
        } catch (Exception ex){
            ex.printStackTrace();
        }finally {
            //关闭
            DBUtil.closeConnection(conn);
        }
        return news;

    }
    
    //查询单条详情
    public News getNewsInfo(int id){
        News news = new News();
        DBUtil db = new DBUtil();
        Connection conn = null;
        ResultSet rs = null;
        try {
            conn = db.getConnection();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String sql = "SELECT * FROM t_news where 1=1 and id="+id;
        try {
            PreparedStatement statement = conn.prepareStatement(sql);
            rs = statement.executeQuery();
            while (rs.next()) {
                // 将数据库的数据转换成POJO实例
                news.setId(rs.getInt("id"));
                news.setAlterTime(rs.getString("alter_time"));
                news.setAuthor(rs.getString("author"));
                news.setContent(rs.getString("content"));
                news.setSortId(rs.getInt("sort_id"));
                news.setTitle(rs.getString("title"));
                news.setWriteTime(rs.getString("write_time"));
            }
        } catch (Exception ex){
            ex.printStackTrace();
        }finally {
            //关闭
            DBUtil.closeConnection(conn);
        }
        return news;

    }
    //新增单条
    public static int addNews(News news) {
        int i = 0;
        DBUtil db = new DBUtil();
        Connection conn = null;
        PreparedStatement pstmt;
        try {
            conn = db.getConnection();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            String sql = "insert into t_news (title,author,content,sort_id,write_time,alter_time) values(?,?,?,?,?,?)";
            pstmt = (PreparedStatement) conn.prepareStatement(sql);
            pstmt.setString(1, news.getTitle());
            pstmt.setString(2, news.getAuthor());
            pstmt.setString(3, news.getContent());
            pstmt.setInt(4, news.getSortId());
            pstmt.setString(5, DateUtil.dateFormat(new Date(),DateUtil.HOUR_PATTERN));
            pstmt.setString(6, DateUtil.dateFormat(new Date(),DateUtil.HOUR_PATTERN));
            System.out.println(sql);
            i = pstmt.executeUpdate();
            pstmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            //关闭
            DBUtil.closeConnection(conn);
        }
        return i;
    }
   //修改单条
   public static int upNews(News news) {
       int i = 0;
       DBUtil db = new DBUtil();
       Connection conn = null;
       PreparedStatement pstmt;
       try {
           conn = db.getConnection();
       } catch (ClassNotFoundException e) {
           e.printStackTrace();
       } catch (SQLException e) {
           e.printStackTrace();
       }
       try {
           String sql = "update t_news set title='" + news.getTitle() + "',author='"+news.getAuthor()+"',content='"+news.getContent()+"',alter_time='"+DateUtil.dateFormat(new Date(),DateUtil.HOUR_PATTERN)+"' where id='" + news.getId() + "'";
           pstmt = (PreparedStatement) conn.prepareStatement(sql);
           i = pstmt.executeUpdate();
           pstmt.close();
           conn.close();
       } catch (Exception e) {
           e.printStackTrace();
       }finally {
           //关闭
           DBUtil.closeConnection(conn);
       }
       return i;
   }
   //删除单条
    public int deleteNews(int id) {
        int count = 0;
        DBUtil db = new DBUtil();
        Connection conn = null;
        ResultSet rs = null;
        try {
            conn = db.getConnection();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String sql = "delete from t_news where id=?";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            count = pstmt.executeUpdate();
        } catch (Exception ex){
            ex.printStackTrace();
        }finally {
            //关闭
            DBUtil.closeConnection(conn);
        }
        return count;
    }
    
  //通过名字删除单条
    public int deleteNewsByTit(String title) {
        int count = 0;
        DBUtil db = new DBUtil();
        Connection conn = null;
        ResultSet rs = null;
        try {
            conn = db.getConnection();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String sql = "delete from t_news where title=?";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, title);
            count = pstmt.executeUpdate();
        } catch (Exception ex){
            ex.printStackTrace();
        }finally {
            //关闭
            DBUtil.closeConnection(conn);
        }
        return count;
    }

}

package hengzhi.dao;

import hengzhi.entity.SortInfo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SortInfoDao {

    //每页条数
    private static int pagesize = 10;

    //分页查询列表
    public List<SortInfo> getSortList(int pageNo){
        List<SortInfo> list = new ArrayList<SortInfo>();
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
        String sql = "SELECT * FROM t_sort where 1=1  limit "+begin+","+end;
        try {
            PreparedStatement statement = conn.prepareStatement(sql);
            rs = statement.executeQuery();
            while (rs.next()) {
                SortInfo sortInfo = new SortInfo();
                // 将数据库的数据转换成POJO实例
                sortInfo.setId(rs.getInt("id"));
                sortInfo.setSortName(rs.getString("sort_name"));
                list.add(sortInfo);
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
    public static int getTotalPage() {
        int totalCount = 0;
        int totalPage = 0;
        Connection conn = null;
        DBUtil db = new DBUtil();
        ResultSet rs = null;
        try {
            conn = db.getConnection();
            String sql = "SELECT count(id) FROM t_sort where 1=1";
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

    //查询单条详情
    public SortInfo getSortInfo(int id){
        SortInfo sortInfo = new SortInfo();
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
        String sql = "SELECT * FROM t_sort where 1=1 and id="+id;
        try {
            PreparedStatement statement = conn.prepareStatement(sql);
            rs = statement.executeQuery();
            while (rs.next()) {
                // 将数据库的数据转换成POJO实例
                sortInfo.setId(rs.getInt("id"));
                sortInfo.setSortName(rs.getString("sort_name"));
            }
        } catch (Exception ex){
            ex.printStackTrace();
        }finally {
            //关闭
            DBUtil.closeConnection(conn);
        }
        return sortInfo;

    }
    //新增单条
    public static int addSortInfo(SortInfo sortInfo) {
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
            String sql = "insert into t_sort (sort_name) values(?)";
            pstmt = (PreparedStatement) conn.prepareStatement(sql);
            pstmt.setString(1, sortInfo.getSortName());
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
    public static int upSortInfo(SortInfo sortInfo) {
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
            String sql = "update t_sort set sort_name='" +sortInfo.getSortName()+"' where id='" + sortInfo.getId() + "'";
            System.out.println(sql);
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
    public int deleteSortInfo(int id) {
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
        String sql = "delete from t_sort where id=?";
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
}


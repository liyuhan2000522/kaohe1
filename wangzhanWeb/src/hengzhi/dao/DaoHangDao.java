package hengzhi.dao;

import hengzhi.entity.DaoHang;
import hengzhi.entity.News;
import hengzhi.entity.SortInfo;
import hengzhi.entity.UserInfo;
import hengzhi.util.DateUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DaoHangDao {

    //每页条数
    private static int pagesize = 10;

    
    //修改单条
    public static int upDaoHang(DaoHang daohang) {
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
            String sql = "update t_daohang set daohang_title='" + daohang.getDaoHangTitle() + "',daohang_url='"+daohang.getDaoHangUrl()+"' where id='" + daohang.getId() + "'";
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
    
    //分页查询列表
    public List<DaoHang> getDaoHangList(int pageNo){
        List<DaoHang> list = new ArrayList<DaoHang>();
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
        String sql = "SELECT * FROM t_daohang where 1=1  limit "+begin+","+end;
        try {
            PreparedStatement statement = conn.prepareStatement(sql);
            rs = statement.executeQuery();
            while (rs.next()) {
            	DaoHang daoHangInfo = new DaoHang(rs.getInt("id"),rs.getString("daohang_title"), rs.getString("daohang_url"));
                // 将数据库的数据转换成POJO实例
//            	daoHangInfo.setId(rs.getInt("id"));
//            	daoHangInfo.setDaoHangTitle(rs.getString("daohang_title"));
//            	daoHangInfo.setDaoHangUrl(rs.getString("daohang_url"));
                list.add(daoHangInfo);
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
            String sql = "SELECT count(id) FROM  where 1=1";
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

    //新增单条
    public static int addUserInfo(UserInfo userInfo) {
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
            String sql = "insert into t_daohang (username,password,image,age,create_time) values(?,?,?,?,?)";
            pstmt = (PreparedStatement) conn.prepareStatement(sql);
            pstmt.setString(1, userInfo.getUsername());
            pstmt.setString(2, userInfo.getPassword());
            pstmt.setString(3, userInfo.getImage());
            pstmt.setInt(4, userInfo.getAge());
            pstmt.setString(5, userInfo.getCreateTime());
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
    public static int upUserInfo(UserInfo userInfo) {
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
            String sql = "update t_daohang set image='" +userInfo.getImage()+"',age="+userInfo.getAge()+" where id='" + userInfo.getId() + "'";
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

    //修改单条密码
    private static int upUserPass(UserInfo userInfo) {
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
            String sql = "update t_daohang set password='" +userInfo.getPassword()+" where id='" + userInfo.getId() + "'";
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
    public int deleteUserInfo(int id) {
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
        String sql = "delete from t_daohang where id=?";
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



    //查询单条详情
    public UserInfo getUserInfoByUserName(String userName){
        UserInfo userInfo = new UserInfo();
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
        String sql = "SELECT * FROM t_daohang where 1=1 and username='"+userName+"'";
        try {
            PreparedStatement statement = conn.prepareStatement(sql);
            rs = statement.executeQuery();
            while (rs.next()) {
                // 将数据库的数据转换成POJO实例
                userInfo.setId(rs.getInt("id"));
                userInfo.setUsername(rs.getString("username"));
                userInfo.setPassword(rs.getString("password"));
                userInfo.setImage(rs.getString("image"));
                userInfo.setAge(rs.getInt("age"));
                userInfo.setCreateTime(rs.getString("create_time"));
            }
        } catch (Exception ex){
            ex.printStackTrace();
        }finally {
            //关闭
            DBUtil.closeConnection(conn);
        }
        return userInfo;

    }
    
  //查询单条详情
    public DaoHang getDaoHang(int id){
    	DaoHang daohang = new DaoHang(1, "", "");
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
        String sql = "SELECT * FROM t_daohang where 1=1 and id="+id;
        try {
            PreparedStatement statement = conn.prepareStatement(sql);
            rs = statement.executeQuery();
            while (rs.next()) {
                // 将数据库的数据转换成POJO实例
            	daohang.setId(rs.getInt("id"));
            	daohang.setDaoHangTitle(rs.getString("daohang_title"));
            	daohang.setDaoHangUrl(rs.getString("daohang_url"));
            }
        } catch (Exception ex){
            ex.printStackTrace();
        }finally {
            //关闭
            DBUtil.closeConnection(conn);
        }
        return daohang;

    }
    
    
  //删除单条
    public int delete(int id) {
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
        String sql = "delete from t_daohang where id=?";
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
    
	public int addDaoHang(DaoHang daohang) {
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
            String sql = "insert into t_daohang (daohang_title,daohang_url) values(?,?)";
            pstmt = (PreparedStatement) conn.prepareStatement(sql);
            pstmt.setString(1, daohang.getDaoHangTitle());
            pstmt.setString(2, daohang.getDaoHangUrl());
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
}

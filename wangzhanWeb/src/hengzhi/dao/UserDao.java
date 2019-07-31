package hengzhi.dao;

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

public class UserDao {

    //每页条数
    private static int pagesize = 10;

    //分页查询列表
    public List<UserInfo> getUserInfoList(int pageNo){
        List<UserInfo> list = new ArrayList<UserInfo>();
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
        String sql = "SELECT * FROM t_user where 1=1 and state='1' limit "+begin+","+end;
        try {
            PreparedStatement statement = conn.prepareStatement(sql);
            rs = statement.executeQuery();
            while (rs.next()) {
                UserInfo userInfo = new UserInfo();
                // 将数据库的数据转换成POJO实例
                userInfo.setId(rs.getInt("id"));
                userInfo.setUsername(rs.getString("username"));
                userInfo.setPassword(rs.getString("password"));
                userInfo.setImage(rs.getString("image"));
                userInfo.setAge(rs.getInt("age"));
                userInfo.setState(rs.getInt("state"));
                userInfo.setCreateTime(DateUtil.dateFormat(new Date(),DateUtil.HOUR_PATTERN));
                list.add(userInfo);
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
            String sql = "SELECT count(id) FROM t_user where 1=1";
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
    public UserInfo getUserInfo(int id){
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
        String sql = "SELECT * FROM t_user where 1=1 and id="+id;
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
        	String sql = "insert into t_user (username,password,image,age,create_time,state) values(?,?,?,?,?,?)";
            pstmt = (PreparedStatement) conn.prepareStatement(sql);
            pstmt.setString(1, userInfo.getUsername());
            pstmt.setString(2, userInfo.getPassword());
            pstmt.setString(3, userInfo.getImage());
            pstmt.setInt(4, userInfo.getAge());
            pstmt.setString(5, userInfo.getCreateTime());
            pstmt.setInt(6, userInfo.getState());
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

  //修改状态
    public static int upState(UserInfo userInfo) {
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
            String sql = "update t_user set state='" +userInfo.getState()+"' where id='" + userInfo.getId() + "'";
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
            String sql = "update t_user set image='" +userInfo.getImage()+"',age="+userInfo.getAge()+" where id='" + userInfo.getId() + "'";
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
            String sql = "update t_user set password='" +userInfo.getPassword()+" where id=" + userInfo.getId();
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
        String sql = "delete from t_user where id=?";
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
    public UserInfo getUserInfoByUserName(String userName,int state){
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
        String sql = "SELECT * FROM t_user where 1=1 and username='"+userName+"' and state="+state;
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
}

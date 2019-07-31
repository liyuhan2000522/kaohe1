package hengzhi.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;

public class DBUtil {
//    private final static String DRIVER = "com.mysql.cj.jdbc.Driver";
//    private final static String URL = "jdbc:mysql://localhost:3306/test?useSSL=false&useUnicode=true&characterEncoding=utf8&characterSetResults=utf8&serverTimezone=UTC";
    private final static String DRIVER = "com.mysql.jdbc.Driver";   //mysql8.0以下版本
    private final static String URL = "jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf-8";
    private final static String USERNAME = "root";
    private final static String PASSWORD = "";
    private static Connection conn=null;
    public Connection getConnection() throws ClassNotFoundException, SQLException {
        try {
            Class.forName(DRIVER).newInstance();//加载驱动
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        conn = (Connection) DriverManager.getConnection(URL, USERNAME, PASSWORD);//获取与数据库的连接
        return conn;
    }


    /**
     * 释放资源
     * @param conn
     * @param st
     * @param rs
     */
    public static void colseResource(Connection conn, Statement st, ResultSet rs) {
        closeResultSet(rs);
        closeStatement(st);
        closeConnection(conn);
    }

    /**
     * 释放连接 Connection
     * @param conn
     */
    public static void closeConnection(Connection conn) {
        if(conn !=null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        //等待垃圾回收
        conn = null;
    }

    /**
     * 释放语句执行者 Statement
     * @param st
     */
    public static void closeStatement(Statement st) {
        if(st !=null) {
            try {
                st.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        //等待垃圾回收
        st = null;
    }

    /**
     * 释放结果集 ResultSet
     * @param rs
     */
    public static void closeResultSet(ResultSet rs) {
        if(rs !=null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        //等待垃圾回收
        rs = null;
    }

}

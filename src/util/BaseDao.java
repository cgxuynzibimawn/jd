package util;

import java.sql.*;

public class BaseDao {
    private final static String DRIVER = "com.mysql.jdbc.Driver";
    private final static String URL = "jdbc:mysql://localhost:3306/jd?useUnicode=true&characterEncoding=UTF8&useSSL=true";
    private final static String USERNAME = "root";
    private final static String PASSWORD = "Root890626";

    private Connection getConn(){
        Connection conn = null;
        try {
            Class.forName(DRIVER);
            conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    protected ResultSet executeQuery(String sql,Object... objes){
        Connection conn = getConn();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            pstmt = conn.prepareStatement(sql);
            if(objes!=null && objes.length>0){
                for(int i = 0 ;i < objes.length;i++){
                    pstmt.setObject((i+1),objes[i]);
                }
            }
            rs = pstmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

    protected int executeUpdate(String sql,Object... objes){
        Connection conn = getConn();
        PreparedStatement pstmt = null;
        int result = 0;
        try {
            pstmt = conn.prepareStatement(sql);
            if(objes!=null && objes.length>0){
                for(int i = 0 ;i < objes.length;i++){
                    pstmt.setObject((i+1),objes[i]);
                }
            }
            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            closeAll(conn,pstmt,null);
        }

        return result;
    }

    protected void closeAll(Connection conn, Statement stmt, ResultSet rs){
        try {
            if(rs!=null) rs.close();
            if(stmt!=null) stmt.close();
            if(conn!=null) conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
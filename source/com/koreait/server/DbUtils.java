package com.koreait.server;

import java.sql.*;

public class DbUtils {
    public static Connection getCon() throws SQLException {
        final String URL = "jdbc:mysql://localhost:3308/test";
        final String USERNAME = "root";
        final String PASSWORD = "koreait";
        Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        System.out.println("접속 성공 !");
        return con;
    }

    public static void close(Connection con, PreparedStatement ps){
        close(con,ps,null);
    }

    public static void close(Connection con, PreparedStatement ps, ResultSet rs){

        if(con != null) {
            try{con.close();}
            catch (Exception e){e.printStackTrace();}
        }
        if(ps != null) {
            try{con.close();}
            catch(Exception e) {e.printStackTrace();}
        }
        if(rs !=null) {
            try{rs.close();}
            catch( Exception e){e.printStackTrace();}
        }
    }
}
package com.koreait.server;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class BoardDAO {
    public static void main(String[] args){
        BoardVO param = new BoardVO();
        param.setTitle("www");
        param.setCtnt("fjfj");
        param.setWriter("ekfj");
        insBoard(param);

        System.out.printf("타이틀 : "+ param.getTitle());
        System.out.printf("ctnt : "+ param.getCtnt());
        System.out.printf("작성 : "+ param.getWriter());

    }
    public static int insBoard(BoardVO param) {
        Connection con = null;
        PreparedStatement ps = null;
        String sql = "INSERT INTO t_board " +
                "(title, ctnt, writer) "+
                "VAlUES " +
                "(?,?,?)";
        try{
            con = DbUtils.getCon();
            ps = con.prepareStatement(sql);

            ps.setString(1, param.getTitle());
            ps.setString(2, param.getCtnt());
            ps.setString(3, param.getWriter());

            return ps.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            DbUtils.close(con, ps);
        }
        return 0;
    }
}

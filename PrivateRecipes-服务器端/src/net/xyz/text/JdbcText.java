package net.xyz.text;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import net.xyz.utils.JdbcUtils;

public class JdbcText {
	public static void main(String[] args) throws SQLException {
		/*
		 * Connection con=JdbcUtils.getConnection(); String sql="select * from user";
		 * PreparedStatement pstmt=con.prepareStatement(sql); ResultSet
		 * rs=pstmt.executeQuery(); if(rs.next()) { System.out.println("гаЪ§Он"); }
		 */
		String s[] = "aaa,bbb".split(",");
		System.out.println(s[0]);
	}

}

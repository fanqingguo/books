package com.rain.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBUtil {
	/**
	 * 
	 */
	public static String username = "root";
	public static String password = "18949635362";
	public static String url = "jdbc:mysql://127.0.0.1:3306/books";
	//����jdbcjar��
	static{
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch(ClassNotFoundException e){
			e.printStackTrace();
		}
	}
	//���ݿ����Ӳ���
	public static Connection getConnectDb(){
		Connection conn = null;
		try{
			conn = DriverManager.getConnection(url,username,password);
			System.out.println("���ݿ����ӳɹ�!");

		
		} catch (SQLException e){
			System.out.println("���ݿ�����ʧ��!");
			e.printStackTrace();
		}
		return conn;
	}
	//�ر����ݿ����
	public static void CloseDB(ResultSet rs, PreparedStatement stm, Connection conn){
		if(rs!=null)
		{
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(stm!=null)
		{
			try {
				stm.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(conn!=null)
		{
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

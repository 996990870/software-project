package com.huachuan;

import java.sql.Connection;
import java.sql.DriverManager;

public class mysqlconnection { //�����������ݿ�Ķ���
    private static String driver = "com.mysql.cj.jdbc.Driver";
    private static String url = "jdbc:MYSQL://localhost:3306/softwareproject?serverTimezone=UTC&&CharacterEncoding=utf-8";
    private static String username = "root";
    private static String password = "184512aa";
    private static Connection conn =null;


    public static Connection getconnection()  //�෽�������ڷ���һ��Connection����
    {


        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, username, password);
            return conn;




        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return conn;
    }



}

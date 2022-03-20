package com.woniuxueyuan.model;

import java.sql.*;

//在进行这些操作之前需要在MySQL中提前创建数据
public class ConnectMySQL {
    // MySQL 8.0 以下版本 - JDBC 驱动名及数据库 URL
//    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
//    static final String DB_URL = "jdbc:mysql://localhost:3306/RUNOOB";
	 // MySQL 8.0 以上版本 - JDBC 驱动名及数据库 URL
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";  
    static final String DB_URL = "jdbc:mysql://localhost:3306/studentdb?serverTimezone=UTC";
 
 
    // 数据库的用户名与密码，需要根据自己的设置
    static final String USER = "root";
    static final String PASS = "1756336885";
   
 
    public static void main(String[] args) {
    	
    	
    	Connection conn = null;
        Statement stmt = null;
        try{
        
            // 注册 JDBC 驱动
            Class.forName(JDBC_DRIVER);
        
            // 打开链接
            System.out.println("连接数据库...");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
           
            
          //刷新的sql语句
			String sql = "insert into students values(1,'12345','小明','0',1,'12345','非洲','2022-01-19 22:43:49','1756336885@qq.com','447439')";
			//建立PreparedStatement对象 
			PreparedStatement pst = conn.prepareStatement(sql);
            pst.executeUpdate();
            //System.out.println(pst);
           
            
            
            
            stmt  = conn.createStatement();	
            String sql3 = "select * from students";//要执行的SQL
			
			/*在询数据表时，需要用到ResultSet接口，它类似于一个数据表，通过该接口的实例
			 * 可以获得检索结果集，以及对应数据表的接口信息。*/
			ResultSet rs = stmt.executeQuery(sql3);//创建数据对象
			
			System.out.println("学号"+"\t"+"登录密码"+"\t"+"姓名"+"\t"+"性别"+"\t"+"年级编号"+"\t"+"电话号码"+"\t"+"地址"+"\t"+"出生日期"+"\t"+"电子邮箱"+"\t"+"身份证号码");
			//遍历查询的结果集
			while (rs.next()) {
				System.out.print(rs.getInt(1)+"\t");
				System.out.print(rs.getString(2)+"\t");
				System.out.print(rs.getString(3)+"\t");
				System.out.print(rs.getString(4)+"\t");
				System.out.print(rs.getString(5)+"\t");
				System.out.print(rs.getString(6)+"\t");
				System.out.print(rs.getString(7)+"\t");
				System.out.print(rs.getString(8)+"\t");
				System.out.print(rs.getString(9)+"\t");
				System.out.print(rs.getString(10)+"\t");
				System.out.println();
			}
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
        
//            // 执行查询
//            System.out.println(" 实例化Statement对象...");
//            stmt = conn.createStatement();
//            String sql;
//            sql = "SELECT StudentNo, StudentName, Sex FROM students";
//            ResultSet rs = stmt.executeQuery(sql);
//        
//            // 展开结果集数据库
//            while(rs.next()){
//                // 通过字段检索
//                int StudentNo= rs.getInt("StudentNo");
//                String StudentName= rs.getString("StudentName");
//                String Sex= rs.getString("Sex");
//    
//                // 输出数据
//                System.out.print("StudentNo" + StudentNo);
//                System.out.print(", StudentName: " + StudentName);
//                System.out.print(", Sex: " + Sex);
//                System.out.print("\n");
//            }
            // 完成后关闭
            rs.close();
            stmt.close();
            conn.close();
        }catch(SQLException se){
            // 处理 JDBC 错误
            se.printStackTrace();
        }catch(Exception e){
            // 处理 Class.forName 错误
            e.printStackTrace();
        }finally{
            // 关闭资源
            try{
                if(stmt!=null) stmt.close();
            }catch(SQLException se2){
            }// 什么都不做
            try{
                if(conn!=null) conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }
        }
        System.out.println("Goodbye!");
    }



























}








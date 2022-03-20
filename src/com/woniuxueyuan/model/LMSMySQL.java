package com.woniuxueyuan.model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LMSMySQL{
	

	public static void main(String[] args) {
	
	}
	
	
	/**
	 * 
	 * 进行登录的操作
	 * 进行mysql的登录操作
	 * @return 返回Connection类型的数据以备其它方法使用
	 */
	public Connection longin() {
	 // MySQL 8.0 以上版本 - JDBC 驱动名及数据库 URL
	 String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";  
	 String DB_URL = "jdbc:mysql://localhost:3306/studentdb?serverTimezone=UTC";
	    
	 // 数据库的用户名与密码，需要根据自己的设置
	  String USER = "root";
	  String PASS = "1756336885";
		
	  Connection connetion= null;
      Statement stmt = null;
      
      // 注册 JDBC 驱动
      try {
		Class.forName(JDBC_DRIVER);
		 // 打开链接
	      System.out.println("连接数据库...");
	      connetion = DriverManager.getConnection(DB_URL,USER,PASS);
	} catch (ClassNotFoundException|SQLException e) {
		e.printStackTrace();
	}
      
      System.out.println("连接成功！");
      
    //返回Connection类型的数据以备其它方法调用  
	return connetion;
   }
	
	/**
	 * 进行图书分类展示或图书展示
	 * @param connetion进行连接时的对象
	 * @param firstChooseNum 用户进行一级菜单选择时的变量
	 * @return 返回一个从数据库检索的数据集合
	 */
	public ResultSet show(Connection connetion,int firstChooseNum) {
		//初始化变量
		Statement stmt = null;
		ResultSet rs = null;
		
		//用户在一级菜单选择1时连接LibraryCatergory表
		if(firstChooseNum==1) {
			 try {
				stmt  = connetion.createStatement();
				//sql语句选择这个表的全部数据
				String sql= "select * from LibraryCatergory";
				//执行查询操作并将其装入集合内
				rs = stmt.executeQuery(sql);
				
			  } catch (SQLException e) {
				e.printStackTrace();
			    }
		} 
		//用户在一级菜单选择2时连接bookrental表
		else if(firstChooseNum==2){
			 try {
				stmt  = connetion.createStatement();
				//sql语句选择这个表的全部数据
				String sql= "select * from bookrental";
				//执行查询操作并将其装入集合内
				rs = stmt.executeQuery(sql);
				
			  } catch (SQLException e) {
				e.printStackTrace();
			    }
		} 
		//输入其它数字系统自动报错
		else {
			System.out.println("参数错误");	
		}
		 

		 return rs;
	}
	
	
	
	/**
	 * 增加图书分类
	 * @param connetion进行连接时的对象
	 * @param id用户要增加的分类编号
	 * @param name用户要增加的分类名称
	 * @param status用户要增加的分类状态
	 */
	public void update(Connection connetion,int id,String name,String status) {
		
			//要执行的sql语句
			String sql = "insert into LibraryCatergory values(" +id+ ",'" +name+"','" +status+"')";
			//建立PreparedStatement对象 
			PreparedStatement pst = null;
			
			try {
				//把创建的PreparedStatement对象赋给pst
				pst = connetion.prepareStatement(sql);
				//执行更新的操作
				pst.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			  }

	}
	
	
	/**
	 * 增加图书
	 * @param connetion进行连接时的对象
	 * @param bookid图书的编号
	 * @param bookName图书的名称
	 * @param availableNum可借阅图书的数量
	 * @param CatergoryID图书分类编号
	 */
	public void update(Connection connetion,int bookid,String bookName,int availableNum,int CatergoryID) {
		
			//要执行的sql语句
			String sql = "insert into bookrental values(" +bookid+ ",'" +bookName+"'," +availableNum+","+CatergoryID+")";
			//建立PreparedStatement对象 
			PreparedStatement pst = null;
			
			try {
				//把创建的PreparedStatement对象赋给pst
				pst = connetion.prepareStatement(sql);
				//执行更新的操作
				pst.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			  }

	}
	
	

	/**
	 * 删除图书分类或图书
	 * @param connetion 进行连接时的对象
	 * @param id 用户进行删除操作时输入的编号
	 * @param firstChooseNum 用户进行一级菜单选择时的变量
	 */
	public void delete(Connection connetion,int id,int firstChooseNum) {
		//要执行的sql语句
		PreparedStatement pst = null;

		//用户在一级菜单选择1时连接LibraryCatergory表
		if(firstChooseNum==1) {
			//删除数据的代码
			String sql = "delete from LibraryCatergory WHERE CatergoryID="+id;
			
			try {
				pst = connetion.prepareStatement(sql);			
				//执行删除操作
				pst.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		//用户在一级菜单选择2时连接bookrental表
		else if(firstChooseNum==2){
			//删除数据的代码
			String sql = "delete from bookrental WHERE bookid="+id;
			
			try {
				pst = connetion.prepareStatement(sql);			
				//执行删除操作
				pst.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		} 
		//输入其它数字系统自动报错
		else {
			System.out.println("参数错误");	
		}
	
	}
	
	/**
	 * 检索用户需要的分类信息
	 * @param connetion 进行连接时的对象
	 * @param id用户进行分类检索时输入的编号
	 * @param firstChooseNum 用户进行一级菜单选择时的变量
	 * @return
	 */
	public ResultSet search(Connection connetion,int id) {
		//初始化变量
		Statement stmt = null;
		ResultSet rs = null;

		//从LibraryCatergory表中删除指定CatergoryID的数据
		String sql="SELECT * FROM LibraryCatergory WHERE CatergoryID="+id;
		try {
			stmt=connetion.createStatement();
			//执行查询操作并将其装入集合内
			rs = stmt.executeQuery(sql);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		 return rs;		
	}
	
	
	/**
	 * 重写检索用户需要的分类信息的方法
	 * @param connetion 进行连接时的对象
	 * @param id用户进行分类检索时输入的编号
	 * @param firstChooseNum 用户进行一级菜单选择时的变量
	 * @return
	 */
	public ResultSet search(Connection connetion,String bookName) {
		//初始化变量
		Statement stmt = null;
		ResultSet rs = null;

		//从LibraryCatergory表中删除指定CatergoryID的数据
		String sql="SELECT * FROM bookrental WHERE bookName="+bookName;
		try {
			stmt=connetion.createStatement();
			//执行查询操作并将其装入集合内
			rs = stmt.executeQuery(sql);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		 return rs;		
	}
	
	
	

}

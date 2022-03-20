package com.woniuxueyuan.ui;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import com.woniuxueyuan.dao.CatergoryDao;
import com.woniuxueyuan.dao.CatergoryImplement;
import com.woniuxueyuan.model.Catergory;
import com.woniuxueyuan.model.LMSMySQL;

public class UI {
	public static void main(String[] args) {
		//菜单选择的变量
		int firstChooseNum=0;//一级菜单的选择变量
		int secondChooseNum=0;//二级菜单的选择变量

		
		//打印菜单
		System.out.println("****************");	
		System.out.println(" 欢迎进入图书管理系统");
		System.out.println("1、图书分类管理");
		System.out.println("2、图书借阅管理");
		System.out.println("0、退出系统");
		//收集用户选择
		System.out.println("请选择你想要进行的操作：");
		Scanner input=new Scanner(System.in);
		firstChooseNum=input.nextInt();//一级菜单接收用户变量的变量
		//创建LMSMySQL对象
		LMSMySQL lMSMySQL=new LMSMySQL();
		//进行MySQL登录操作
		Connection connetion=lMSMySQL.longin();
		
		
		switch(firstChooseNum) {
		
		case 1:			
		for(;;) {	
			
			//打印图书分类管理菜单
			System.out.println("1、图书分类列表");
			System.out.println("2、删除图书分类");
			System.out.println("3、检索图书分类");
			System.out.println("4、添加图书分类");
			System.out.println("0、返回主菜单");
			System.out.println("请选择你想要进行的操作：");
			secondChooseNum=input.nextInt();//二级菜单接收用户变量的变量
			
			
			if(secondChooseNum==1) {//打印图书分类列表
				
				//接收lMSMySQL对象的show方法的返回值
				ResultSet rs=lMSMySQL.show(connetion,firstChooseNum);
				//调用打印的方法
				print(rs,firstChooseNum);
				
			}
			
			else if(secondChooseNum==2) {
				//删除图书分类
				//收集用户的输入信息
				System.out.println("请选择你要删除的图书分类编号：");
				int id=input.nextInt();
				//执行删除操作
				lMSMySQL.delete(connetion, id,firstChooseNum);
				
				
				//打印图书分类列表
				//接收lMSMySQL对象的show方法的返回值
				ResultSet rs=lMSMySQL.show(connetion,firstChooseNum);
				//调用打印的方法
				print(rs,firstChooseNum);
				
				
			}
			
			else if(secondChooseNum==3) {
				//检索图书分类图书分类
				//收集用户的输入信息
				System.out.println("请选择你要查询的图书分类编号：");
				int id=input.nextInt();
				//执行查询操作并接收结果
				ResultSet rs=lMSMySQL.search(connetion, id);
				//调用打印的方法
				print(rs,firstChooseNum);
				
			}
			
			else if(secondChooseNum==4) {
				//添加图书分类
				System.out.println("请选择你要添加的图书分类编号：");
				int id=input.nextInt();
				System.out.println("请选择你要添加的图书分类名称：");
				String name=input.next();
				System.out.println("请选择你要添加的图书分类状态：");
				String status=input.next();
				
				//进行添加操作
				lMSMySQL.update(connetion, id, name, status);
				
				//打印图书分类列表
				//接收lMSMySQL对象的show方法的返回值
				ResultSet rs=lMSMySQL.show(connetion,firstChooseNum);
				//调用打印的方法
				print(rs,firstChooseNum);
				
			}
			
			else if(secondChooseNum==0) {
				System.out.println("返回主菜单！");
				break;
			}
		}
		break;
		
		
		
		
		case 2:
		for(;;) {
			//打印图书借阅管理菜单
			System.out.println("1、图书列表");
			System.out.println("2、删除图书");
			System.out.println("3、检索图书");
			System.out.println("4、添加图书");
			System.out.println("0、返回主菜单");
			System.out.println("请选择你想要进行的操作：");
			secondChooseNum=input.nextInt();
			if(secondChooseNum==1) {
				//打印图书分类列表
				//接收lMSMySQL对象的show方法的返回值
				ResultSet rs=lMSMySQL.show(connetion,firstChooseNum);
				//调用打印的方法
				print(rs,firstChooseNum);
				
			}
			
			else if(secondChooseNum==2) {
				//删除图书
				//收集用户的输入信息
				System.out.println("请选择你要删除的图书编号：");
				int id=input.nextInt();
				//执行删除图书操作
				lMSMySQL.delete(connetion, id,firstChooseNum);
			}
			
			else if(secondChooseNum==3) {
				//检索图书
				//收集用户的输入信息
				System.out.println("请选择你要查询的图书名称：");
				String bookName=input.next();
				//执行查询操作并接收结果
				ResultSet rs=lMSMySQL.search(connetion, bookName);
				//调用打印的方法
				print(rs,firstChooseNum);
				
			}
			
			else if(secondChooseNum==4) {
				//添加图书分类
				System.out.println("请选择你要添加的图书编号：");
				int id=input.nextInt();
				System.out.println("请选择你要添加的图书名称：");
				String bookName=input.next();
				System.out.println("请输入要图书的可借阅数量：");
				int availableNum=input.nextInt();
				System.out.println("请输入图书分类编号：");
				int CatergoryID=input.nextInt();
				
				
				//进行添加操作
				lMSMySQL.update(connetion, id,bookName,availableNum,CatergoryID);
				
				//打印图书列表
				//接收lMSMySQL对象的show方法的返回值
				ResultSet rs=lMSMySQL.show(connetion,firstChooseNum);
				//调用打印的方法
				print(rs,firstChooseNum);
			}
			
			else if(secondChooseNum==0) {
				System.out.println("返回主菜单!");	
				break;
			}
		}
		
		break;
		

		case 0:
			System.out.println("退出系统!");	
		break;
		}
		

	}
	
	
	
	
	

	/**
	 * 将接收的ResultSet的参数循环打印输出
	 * @param rs MySQL驱动内部的参数
	 */
	public static void print(ResultSet rs,int firstChooseNum) {
		
		//如果一级菜单选择为1就打印分类列表
		if(firstChooseNum==1) {
			//循环打印接收到的集合
			
			try {
				System.out.println("分类编号"+"\t"+"分类名称"+"\t"+"分类状态");
				while (rs.next()) {
					System.out.print(rs.getInt(1)+"\t");
					System.out.print(rs.getString(2)+"\t");
					System.out.print(rs.getString(3)+"\t");
					System.out.println();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			   }
		}
		//如果一级菜单选择为2就打印图书列表
		else if(firstChooseNum==2) {
			//循环打印接收到的集合
			
			try {
				System.out.println("图书编号"+"\t"+"图书名称"+"\t"+"可借阅数量"+"\t"+"分类编号");
				while (rs.next()) {
					System.out.print(rs.getInt(1)+"\t");
					System.out.print(rs.getString(2)+"\t");
					System.out.print(rs.getInt(3)+"\t");
					System.out.print(rs.getInt(4)+"\t");
					System.out.println();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			   }
		}
		else {
			System.out.print("参数错误！");
			
		}
	
	}

	
	
	
	
	
}

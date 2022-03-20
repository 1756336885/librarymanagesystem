package com.woniuxueyuan.dao;
import java.util.ArrayList;
import java.util.List;

import com.woniuxueyuan.model.Catergory;


public class CatergoryImplement implements CatergoryDao{
	
	//声明列表用以储存catergory对象
	protected static List<Catergory> catergories=new ArrayList();
	
	//访问器
	public static List<Catergory> getCatergories() {
		return catergories;
	}


	public static void setCatergories(List<Catergory> catergories) {
		CatergoryImplement.catergories = catergories;
	}


	//返回键对象添加进入列表是否成功，当对象进入该方法，列表就会被修改
	@Override
	public boolean addCatergory(Catergory catergory) {

		return catergories.add(catergory);
	}
	
	
	//根据传入对象的状态判断能不能删除该对象
	@Override
	public boolean deleteCatergory(Catergory catergory) {
		boolean falg=false;
		if((catergory.getStatus()).equals("可用")==true) {
			return catergories.remove(catergory);
		}
		return false;
	}

	
	//如果传入的对象能在列表中找就返回该对象，如果找不到就返回空
	@Override
	public Catergory findCatergory(Catergory catergory) {
		if(catergories.indexOf(catergory)!=-1) {
				
			return	catergories.get(catergories.indexOf(catergory));
		}
		return null;
	}
	
	
	
	@Override
	public boolean updateCatergory(Catergory catergory,String name) {
		if((catergory.getStatus()).equals("可用")==true) {
			//根据输入的名称，修改系统中的名称
			catergory.setName(name);
			return true;
		}
		return false;
	}	
}

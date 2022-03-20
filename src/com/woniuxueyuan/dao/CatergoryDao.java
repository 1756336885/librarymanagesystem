package com.woniuxueyuan.dao;
import com.woniuxueyuan.model.Catergory;


public interface CatergoryDao {
	
	/**
	 * 添加图书分类
	 * @param catergory 分类对象
	 * @return 是否成功，true成功，false失败
	 */
	boolean addCatergory(Catergory catergory);
	/**
	 * 删除图书分类
	 * @param catergory 分类对象
	 * @return 是否成功，true：成功，false：失败
	 */
	boolean deleteCatergory(Catergory catergory);
	/**
	 * 图书分类
	 * @param catergory 分类对象
	 * @return true：成功 false：失败
	 */
	Catergory findCatergory(Catergory catergory);
	/**
	 * 更新图书
	 * @param int i 图书的编号,String name图书分类的新名称
	 * @return true:成功 false：失败
	 */
	boolean updateCatergory(Catergory catergory,String name);
	
	
}

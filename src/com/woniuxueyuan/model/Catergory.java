package com.woniuxueyuan.model;

public class Catergory {
	//声明属性
	private int id;
	private String name;
	private String status;
	
	//声明构造方法
	public Catergory(int id, String name, String status) {
		super();
		this.id = id;
		this.name = name;
		this.status = status;
	}
	public Catergory() {
		super();
	}
	
	//声明访问器
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	//重写toString方法
	@Override
	public String toString() {
		return "id=" + id + ", name=" + name + ", status=" + status;
	}
	
	
	
	
}

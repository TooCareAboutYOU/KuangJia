package com.kuangjia.main.gridviewpager;

import java.io.Serializable;

public class Caterory implements Serializable {
	
	private String name;
	private int img;

//	public Caterory(String name, int img) {
//		this.name = name;
//		this.img = img;
//	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getImg() {
		return img;
	}
	public void setImg(int img) {
		this.img = img;
	}


	@Override
	public String toString() {
		return "Caterory{" +
				"name='" + name + '\'' +
				", img=" + img +
				'}';
	}
}

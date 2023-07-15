package com.gaurav;

public class Number {
	private String type;
	private String no;
	
	public Number() {}
	
	public Number(String T,String N) {
		type=T;
		no=N;
	}
	public void setType(String T) {
		type=T;
	}
	public void setNo(String N) {
		no=N;
	}
	public String getType() {
		return type;
	}
	public String getNo() {
		return no;
	}
}

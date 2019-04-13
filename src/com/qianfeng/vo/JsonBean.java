package com.qianfeng.vo;

public class JsonBean {

	private int code; // 表示处理状态 1 正常 0异常
	private Object info;
	
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public Object getInfo() {
		return info;
	}
	public void setInfo(Object info) {
		this.info = info;
	}
}

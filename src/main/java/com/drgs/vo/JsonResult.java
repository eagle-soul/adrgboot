package com.drgs.vo;

import com.alibaba.fastjson.JSON;

/**
 * @author lenovo
 *
 * @param <T>
 */
public class JsonResult<T> {

	public static final int SUCCESS = 1;
	public static final int FAIL = 0;

	private int code;
//	private int resCode;
	private String msg;
	private T info;
	//private long total;

	public JsonResult() {
	}

	public JsonResult(int code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	public JsonResult(int code, int resCode, String msg, T info) {
		this.code = code;
		this.msg = msg;
		this.info = info;
//		this.resCode = resCode;
	}

	public JsonResult(int code, String msg, T info, long total) {
		this.code = code;
		this.msg = msg;
		this.info = info;
		//this.total = total;
	}

	public JsonResult(int code, String msg, T info) {
		this.code = code;
		this.msg = msg;
		this.info = info;
	}

	public JsonResult(int code, T info) {
		this.code = code;
		this.info = info;
	}

	public static JsonResult success(String msg) {
		final JsonResult code = new JsonResult(SUCCESS, msg);
		return code;
	}

	public static JsonResult fail(String msg) {
		final JsonResult code = new JsonResult(FAIL, msg);
		return code;
	}

	public JsonResult put(T t) {
		info = t;
		return this;
	}

	public int getResult() {
		return code;
	}

	public void setResult(int code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public T getInfo() {
		return info;
	}

	public void setInfo(T info) {
		this.info = info;
	}

//	public long getTotal() {
//		return total;
//	}
//
//	public void setTotal(long total) {
//		this.total = total;
//	}

//	public int getResCode() {
//		return resCode;
//	}

//	public void setResCode(int resCode) {
//		this.resCode = resCode;
//	}

	public String toJsonString() {
		return JSON.toJSONString(this);
	}
}

package com.flinkinfo.eplus.rong.models;

import com.alibaba.fastjson.annotation.JSONField;

//对server sdk返回的封装
public class SdkHttpResult {

	@JSONField(name = "code")
	private int code;

	@JSONField(name = "result")
	private String result;

	public SdkHttpResult(int code, String result) {
		this.code = code;
		this.result = result;
	}

	public int getHttpCode() {
		return code;
	}

	public String getResult() {
		return result;
	}

	@Override
	public String toString() {
		return String.format("{\"code\":\"%s\",\"result\":%s}", code,
				result);
	}
}

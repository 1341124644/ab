package com.qianfeng.utils;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.qianfeng.vo.JsonBean;

public class JsonUtils {

	public static void sendJsonData(int code, Object info, HttpServletResponse response){
		JsonBean bean = new JsonBean();
		bean.setCode(code);
		bean.setInfo(info);
		String jsonString = JSON.toJSONString(bean);
		try {
			response.getWriter().write(jsonString);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

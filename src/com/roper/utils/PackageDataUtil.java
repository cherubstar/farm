package com.roper.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

import net.sf.json.JSONObject;

public class PackageDataUtil {

	public static JSONObject packageData(Object obj){
		
		JSONObject json = new JSONObject();
		
		json.accumulate("code", 200);
		json.accumulate("msg", null);
		json.accumulate("data", JSON.toJSONStringWithDateFormat(obj, "",
				SerializerFeature.WriteDateUseDateFormat,
				SerializerFeature.DisableCircularReferenceDetect));
		
		return json;
	}
}

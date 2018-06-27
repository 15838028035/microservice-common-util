package com.zhongkexinli.micro.serv.common.util;

import java.util.HashMap;
import java.util.Map;

/**
 * 类EnumResult
 * @date 2015-10-30
 * @author renjinbao 
 */
public enum EnumResult {
    OK("1", "获取数据成功"),
    FAIL_TOKEN("0","token值无效"),
    NO_DATA( "-1", "未授权的访问!"),
    FAIL_SIGN("-2","验证sign失败");

	private EnumResult(String code, String desc) {
		this.code = code;
		this.desc = desc;
	}

	private String code;
	private String desc;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public static Map<String, String> toMap() {
		Map<String, String> map = new HashMap<String, String>();
		for (EnumResult msg : EnumResult.values()) {
			map.put(msg.getCode(), msg.getDesc());
		}
		return map;
	}
}

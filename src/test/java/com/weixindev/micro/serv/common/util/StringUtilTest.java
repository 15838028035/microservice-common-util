package com.weixindev.micro.serv.common.util;

public class StringUtilTest {

	public static void main(String []args) {
		String url="http://h5.dadicinema.com/wapportal/wechat/buy.do?cityid={cityid}&cinemaid={cinemaid}";
		url= url.replace("{cityid}", "200");
		System.out.println("----------------------------"+url);
	}

}

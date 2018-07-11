package com.reactlibrary.orvibo.util;

public interface Constants {
	public static final String CHAR_ENCODING = "UTF-8";

	public static String appId = "baianju";		//appId
	public static String appKey = "cc5a3f5c59124b6b997c232197c26185";	//appKey

	//账号信息
	public static String username = "bajzt1@126.com";
	public static String email = "bajzt1@126.com";
	public static String password = "baj123456";

	public static String host = "https://open.orvibo.com";

	public static final String ORDER_ON = "on";//on：开（灯光、开关、插座）
	public static final String ORDER_OFF = "off";//off：关（灯光、开关、插座）

	public static final String ORDER_OPEN = "open";//打开（窗帘、卷闸门、幕布），此时value1填写的是窗帘打开的百分比。0表示关，100表示开，其他值表示停；
	public static final String ORDER_CLOSE = "close";//关闭（窗帘、卷闸门、幕布），此时value1填写的是窗帘打开的百分比。0表示关，100表示开，其他值表示停；
	public static final String ORDER_STOP = "stop";//停止正在执行中的打开或者关闭的动作（窗帘、卷闸门、幕布），此时value1填写的是窗帘打开的百分比。0表示关，100表示开，其他值表示停；
}

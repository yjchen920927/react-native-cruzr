package com.reactlibrary.orvibo;

import android.util.Log;

import com.google.gson.Gson;
import com.reactlibrary.orvibo.util.Constants;
import com.reactlibrary.orvibo.util.EncryptUtil;
import com.reactlibrary.orvibo.util.Tools;

import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import okhttp3.MediaType;
import okhttp3.RequestBody;


public class APIMain {
	private static String appId = "baianju";		//appId
	private static String appKey = "cc5a3f5c59124b6b997c232197c26185";	//appKey

	private static String host = "https://open.orvibo.com";

	/**
	 * 注册
	 * @return
	 * @throws Exception
	 */
	public static String regist() throws Exception {
		String uri = "/api/regist";

		Map<String, String> paramsMap = new HashMap<String, String>();
		paramsMap.put("appId", appId);
		String time = String.valueOf(System.currentTimeMillis());
		paramsMap.put("time", time);						//�����
		String sn = UUID.randomUUID().toString().replaceAll("-", "");
		paramsMap.put("sn", sn);																//�����

		paramsMap.put("phone", "15867124063");													//�ֻ�����(�ֻ�������������һ��)	[ѡ��]
		paramsMap.put("email", "yjchen_study@163.com");											//����					[ѡ��]
		paramsMap.put("password", EncryptUtil.MD5("12345678").toUpperCase());			//md5('12345678')		�����
		paramsMap.put("name", "jason");
		String sign = Tools.calSign(uri, "post", paramsMap, appKey);
		paramsMap.put("sig", sign);																//�����

		String requst = Tools.paramsToString(paramsMap);
		Log.i("orvibo--requst",requst);
// 	String result = Tools.doPost(host + uri, requst);
		String result = Tools.doPostHttpURLConnection(host+uri,requst);
		Log.e("orvibo--result",result);
		return result;
	}

	/**
	 * 获取设备列表
	 * @return
	 * @throws Exception
	 */
	public static String getDeviceList() throws Exception{
		String uri = "/api/getDeviceList";
		Map<String, String> paramsMap = new HashMap<String, String>();
		paramsMap.put("appId", appId);
		String time = String.valueOf(System.currentTimeMillis());
		paramsMap.put("time", time);						//�����
		String sn = UUID.randomUUID().toString().replaceAll("-", "");
		paramsMap.put("sn", sn);

		paramsMap.put("userName", "15867124063");
//		paramsMap.put("email", "yjchen_study@163.com");
		paramsMap.put("password",EncryptUtil.MD5("12345678").toUpperCase());
		String sign = Tools.calSign(uri, "post", paramsMap, appKey);
		paramsMap.put("sig", sign);

		String requst = Tools.paramsToString(paramsMap);
		String result = Tools.doPostHttpURLConnection(host+uri,requst);
		Log.e("orvibo--getDeviceList",result);
		return result;
	}
	/**
	 * 绑定设备
	 */
	public static String bindhost() throws Exception{
		String uri = "/api/bindhost";
		Map<String, String> paramsMap = new HashMap<String, String>();
		paramsMap.put("appId", appId);
		String time = String.valueOf(System.currentTimeMillis());
		paramsMap.put("time", time);						//�����
		String sn = UUID.randomUUID().toString().replaceAll("-", "");
		paramsMap.put("sn", sn);

		paramsMap.put("userName", "15867124063");
//		paramsMap.put("email", "yjchen_study@163.com");
		paramsMap.put("password", EncryptUtil.MD5("12345678").toUpperCase());
		paramsMap.put("uid", "111");
		String sign = Tools.calSign(uri, "post", paramsMap, appKey);
		paramsMap.put("sig", sign);

		String requst = Tools.paramsToString(paramsMap);
		String result = Tools.doPostHttpURLConnection(host+uri,requst);
		Log.e("orvibo--bindhost",result);
		return result;
	}
	/**
	 * 控制设备
	 */
	public static String control() throws Exception{
		String uri = "/api/control";
		Map<String, String> paramsMap = new HashMap<String, String>();
		paramsMap.put("appId", appId);
		String time = String.valueOf(System.currentTimeMillis());
		paramsMap.put("time", time);						//�����
		String sn = UUID.randomUUID().toString().replaceAll("-", "");
		paramsMap.put("sn", sn);

		paramsMap.put("userName", "15867124063");
//		paramsMap.put("email", "yjchen_study@163.com");
		paramsMap.put("password", EncryptUtil.MD5("12345678").toUpperCase());

		paramsMap.put("uid", "111");
		paramsMap.put("deviceId", "111");
		paramsMap.put("order", Constants.ORDER_ON);

		paramsMap.put("value1", "0");
		paramsMap.put("value2", "0");
		paramsMap.put("value3", "0");
		paramsMap.put("value4", "0");
		paramsMap.put("delayTime", "10");//延迟的秒数

		String sign = Tools.calSign(uri, "post", paramsMap, appKey);
		paramsMap.put("sig", sign);

		String requst = Tools.paramsToString(paramsMap);
		String result = Tools.doPostHttpURLConnection(host+uri,requst);
		Log.e("orvibo--control",result);
		return result;
	}
	public static void main(String[] args) {
		try {
			//String result = testRegist();
			String result = testCheckRegPhone();
			System.out.println("result:" + result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * ????豸
	 */
	public static String deleteDevice() throws Exception{
		String uri = "/api/cmdRequest";
		Map<String, String> paramsMap = new HashMap<String, String>();
		paramsMap.put("appId", appId);
		paramsMap.put("time", String.valueOf(System.currentTimeMillis()));
		String sn = UUID.randomUUID().toString().replaceAll("-", "");
		paramsMap.put("sn", sn);
		paramsMap.put("userName", "xx");
		paramsMap.put("password", "xx");
		String sign = Tools.calSign(uri, "post", paramsMap, appKey);
		String sign_encode = URLEncoder.encode(sign, Constants.CHAR_ENCODING);
		paramsMap.put("sig", sign_encode);
		String requst = Tools.paramsToString(paramsMap);

		String data = "{\"cmd\":18,\"uid\":\"5cfff94b71\",\"deviceId\":\"16f729c935411871f3eab842c3ba6\",\"extAddr\":\"00124B0010035FA7\"}";

		String result = Tools.doPost(host + uri+"?"+requst, data);

		for(int i = 0; i < 5; i++){
			Thread.sleep(1000);
			System.out.println("hostResult:" + getResult("18",sn));
		}

		return result;
	}

	/**
	* ?????????????
	*/
	public static String getResult(String queryCmd, String querySn) throws Exception {
		String uri = "/api/getResult";

		Map<String, String> paramsMap = new HashMap<String, String>();
		paramsMap.put("appId", appId);
		paramsMap.put("time", String.valueOf(System.currentTimeMillis()));
		String sn = Tools.getUUID();
		paramsMap.put("sn", sn);
		paramsMap.put("queryCmd", queryCmd);
		paramsMap.put("querySn", querySn);

		String sign = Tools.calSign(uri, "post", paramsMap, appKey);
		paramsMap.put("sig", sign);

		String requst = Tools.paramsToString(paramsMap);

		return Tools.doPost(host + uri, requst);
	}

	/**
	 * ???
	 */
	public static void testRegist() throws Exception {
		String uri = "/api/regist";

		Map<String, String> paramsMap = new HashMap<String, String>();
		paramsMap.put("appId", appId);
		paramsMap.put("time", String.valueOf(System.currentTimeMillis()));						//??????
		String sn = UUID.randomUUID().toString().replaceAll("-", "");
		paramsMap.put("sn", sn);																//??????

//		paramsMap.put("phone", "15867124063");													//???????(??????????????????)	[???]
		paramsMap.put("email", "271071500@qq.com");											//????					[???]
		paramsMap.put("password", "25d55ad283aa400af464c76d713c07ad".toUpperCase());			//md5('12345678')		??????
		paramsMap.put("name", "jason");														//???					[???]

		String sign = Tools.calSign(uri, "post", paramsMap, appKey);
		paramsMap.put("sig", sign);																//??????

		String requst = Tools.paramsToString(paramsMap);
		Log.e("orvibo",requst);
//		return Tools.doPost(host + uri, requst);
		Gson gson = new Gson();
		String postInfoStr = gson.toJson(paramsMap);
		RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"),postInfoStr);

//		Call<RegistResponse> call = HttpClient.getOrviboAPI().regist(body);
//        call.enqueue(new Callback<RegistResponse>() {
//            @Override
//            public void onResponse(Call<RegistResponse> call, Response<RegistResponse> response) {
//                try {
//                    Log.i("orvibo--onresponse", response.body().toString());
//                }catch (Exception e){
//
//                }
//
//            }
//
//            @Override
//            public void onFailure(Call<RegistResponse> call, Throwable t) {
//				Log.i("onresponse", "onFailure");
//            }
//        });
	}

	/**
	 * ???phone????????
	 */
	public static String testCheckRegPhone() throws Exception{
		String uri = "/api/checkRegPhone";

		Map<String, String> paramsMap = new HashMap<String, String>();
		paramsMap.put("appId", appId);										//??????
		paramsMap.put("time", String.valueOf(System.currentTimeMillis()));	//??????
		String sn = UUID.randomUUID().toString().replaceAll("-", "");
		paramsMap.put("sn", sn);											//??????

		paramsMap.put("phone", "13912345001");								//??????

		String sign = Tools.calSign(uri, "post", paramsMap, appKey);
		paramsMap.put("sig", sign);											//??????

		String requst = Tools.paramsToString(paramsMap);
		return Tools.doPost(host + uri, requst);
	}
}

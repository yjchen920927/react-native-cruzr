package com.reactlibrary.orvibo.control;

import android.util.Log;

import com.reactlibrary.orvibo.util.Constants;
import com.reactlibrary.orvibo.util.EncryptUtil;
import com.reactlibrary.orvibo.util.Tools;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @Description
 * @Author yongjian.chen
 * @Date 2018/7/9
 * @Version
 */

public class OrviboApiModel {
    /**
     * 获取设备列表
     * @return
     * @throws Exception
     */
    public static String getDeviceList() throws Exception{
        String uri = "/api/getDeviceList";
        Map<String, String> paramsMap = new HashMap<String, String>();
        paramsMap.put("appId", Constants.appId);
        String time = String.valueOf(System.currentTimeMillis());
        paramsMap.put("time", time);						//�����
        String sn = UUID.randomUUID().toString().replaceAll("-", "");
        paramsMap.put("sn", sn);

        paramsMap.put("userName", Constants.username);
        paramsMap.put("password", EncryptUtil.MD5(Constants.password).toUpperCase());
        String sign = Tools.calSign(uri, "post", paramsMap, Constants.appKey);
        paramsMap.put("sig", sign);

        String requst = Tools.paramsToString(paramsMap);
        String result = Tools.doPostHttpURLConnection(Constants.host+uri,requst);
        Log.i("orvibo--getDeviceList",result);
        return result;
    }
    /**
     * 控制设备
     */
    public static String control(Map<String,String> extra) throws Exception{
        String uri = "/api/control";
        Map<String, String> paramsMap = new HashMap<String, String>();
        paramsMap.put("appId", Constants.appId);
        String time = String.valueOf(System.currentTimeMillis());
        paramsMap.put("time", time);						//�����
        String sn = UUID.randomUUID().toString().replaceAll("-", "");
        paramsMap.put("sn", sn);

        paramsMap.put("userName", Constants.username);
        paramsMap.put("password", EncryptUtil.MD5(Constants.password).toUpperCase());
        paramsMap.putAll(extra);

        paramsMap.put("delayTime", "1");//延迟的秒数

        String sign = Tools.calSign(uri, "post", paramsMap,Constants.appKey);
        paramsMap.put("sig", sign);

        String requst = Tools.paramsToString(paramsMap);
        String result = Tools.doPostHttpURLConnection(Constants.host+uri,requst);
        Log.i("orvibo--control",result);
        return result;
    }
    /**
     * 获取用户创建的默认家庭情景列表
     * @return
     * @throws Exception
     */
    public static String getSceneList()throws Exception{
        String uri = "/api/getSceneList";
        Map<String, String> paramsMap = new HashMap<String, String>();
        paramsMap.put("appId", Constants.appId);
        String time = String.valueOf(System.currentTimeMillis());
        paramsMap.put("time", time);						//�����
        String sn = UUID.randomUUID().toString().replaceAll("-", "");
        paramsMap.put("sn", sn);

        paramsMap.put("userName", Constants.username);
        paramsMap.put("password", EncryptUtil.MD5(Constants.password).toUpperCase());
        String sign = Tools.calSign(uri, "post", paramsMap, Constants.appKey);
        paramsMap.put("sig", sign);

        String requst = Tools.paramsToString(paramsMap);
        String result = Tools.doPostHttpURLConnection(Constants.host+uri,requst);
        Log.i("orvibo--getSceneList",result);
        return result;
    }
    /**
     * 情景控制
     */
    public static String sceneExecute(Map<String,String> extra) throws Exception{
        String uri = "/api/sceneExecute";
        Map<String, String> paramsMap = new HashMap<String, String>();
        paramsMap.put("appId", Constants.appId);
        String time = String.valueOf(System.currentTimeMillis());
        paramsMap.put("time", time);						//�����
        String sn = UUID.randomUUID().toString().replaceAll("-", "");
        paramsMap.put("sn", sn);

        paramsMap.put("userName", Constants.username);
        paramsMap.put("password", EncryptUtil.MD5(Constants.password).toUpperCase());
        paramsMap.putAll(extra);

        String sign = Tools.calSign(uri, "post", paramsMap,Constants.appKey);
        paramsMap.put("sig", sign);

        String requst = Tools.paramsToString(paramsMap);
        String result = Tools.doPostHttpURLConnection(Constants.host+uri,requst);
        Log.i("orvibo--sceneExecute",result);
        return result;
    }
}

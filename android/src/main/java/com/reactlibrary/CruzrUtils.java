package com.reactlibrary;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

import com.google.gson.Gson;
import com.reactlibrary.orvibo.bean.DeviceInfoResponse;
import com.reactlibrary.orvibo.bean.SceneListResponse;
import com.reactlibrary.orvibo.control.SemanticAnalysisManager;
import com.reactlibrary.orvibo.control.OrviboApiModel;
import com.reactlibrary.orvibo.util.ThreadPoolUtil;
import com.ubtechinc.cruzr.sdk.speech.ISpeechContext;
import com.ubtechinc.cruzr.sdk.speech.SpeechRobotApi;
import com.ubtechinc.cruzr.serverlibutil.interfaces.InitListener;

import org.json.JSONObject;

/**
 * @Description
 * @Author yongjian.chen
 * @Date 2018/6/27
 * @Version
 */

public class CruzrUtils {
    public static final int GetDeviceList = 1;
    public static final int GetSceneList = 2;
    public static DeviceInfoResponse deviceInfoBean;
    public static SceneListResponse sceneListResponse;
    public static Handler mHandler = new Handler() {

        @Override
        public void handleMessage(Message msg) {
            // TODO Auto-generated method stub

            super.handleMessage(msg);
            String result = msg.getData().getString("result");
            Gson gson = new Gson();
            switch (msg.what) {

                case GetDeviceList:

                    getSceneList();
                    deviceInfoBean = gson.fromJson(result, DeviceInfoResponse.class);
                    // Log.i("orvibo", "--size:"+deviceInfoBean.getDList().size()+"--"+deviceInfoBean.toString());

                    break;
                case GetSceneList:
                    sceneListResponse = gson.fromJson(result, SceneListResponse.class);
                    // Log.i("orvibo", "--size:"+sceneListResponse.getSceneList().size()+"--"+sceneListResponse.toString());
                    break;
            }
        }
    };

    /**
     * 语音引擎--初始化
     *
     * @param context
     * @param listener
     */
    public static void init(Context context, final CruzrListener listener) {
        getDeviceList();
        SpeechRobotApi.get().initializ(context, 1200, new InitListener() {
            @Override
            public void onInit() { //初始化成功 注册语音
                SpeechRobotApi.get().registerSpeech(new ISpeechContext() {
                    @Override
                    public void onStart() {

                    }

                    @Override
                    public void onStop() {

                    }

                    @Override
                    public void onPause() {

                    }

                    @Override
                    public void onResume() {

                    }

                    @Override
                    public void onResult(String s) {
                        Log.i("dan", "support onResult:" + s);
                        try {
                            JSONObject object = new JSONObject(s);
                            String intentStr = object.optString("intent");
                            if(intentStr.contains("退出购物")||intentStr.contains("退出导购")||intentStr.contains("退出导购屏")||intentStr.contains("退出app")) {
                                listener.exitApp();
                            }else if(intentStr.contains("购物")||intentStr.contains("导购")||intentStr.contains("导购屏")) {
                                listener.startApp();
                            }else{
                                SemanticAnalysisManager.getInstance().semanticAnalysis(intentStr);
                            }
                        }catch (Exception e){
                            e.printStackTrace();
                        }


                    }
                });
            }
        });
    }


    public static void getDeviceList() {
        Runnable runnable = new Runnable() {

            public void run() {
                try {
                    String result = "";
                    result = OrviboApiModel.getDeviceList();
                    Message msg = new Message();
                    msg.what = GetDeviceList;
                    Bundle bundle = new Bundle();
                    bundle.putString("result", result);
                    msg.setData(bundle);
                    mHandler.sendMessage(msg);
                } catch (Exception e) {
                    Log.i("orvibo", "error");
                }

            }

        };

        ThreadPoolUtil.getInstance().execute(runnable);
    }

    public static void getSceneList(){
        Runnable runnable = new Runnable() {

            public void run() {
                try {
                    String result = "";
                    result = OrviboApiModel.getSceneList();
                    Message msg = new Message();
                    msg.what = GetSceneList;
                    Bundle bundle = new Bundle();
                    bundle.putString("result", result);
                    msg.setData(bundle);
                    mHandler.sendMessage(msg);
                } catch (Exception e) {
                    Log.i("orvibo", "error");
                }

            }

        };

        ThreadPoolUtil.getInstance().execute(runnable);
    }

//    public static void regist() {
//        Runnable runnable = new Runnable() {
//
//            public void run() {
//                try {
//                    String result = "";
//                    result = APIMain.regist();
//
//                    Message msg = new Message();
//                    msg.what = 1;
//                    Bundle bundle = new Bundle();
//                    bundle.putString("result", result);
//                    bundle.putString("type", Regist + "");
//                    msg.setData(bundle);
//                    mHandler.sendMessage(msg);
//                } catch (Exception e) {
//                    Log.i("orvibo", "error");
//                }
//
//            }
//
//        };
//
//        cachedThreadPool.execute(runnable);
//    }
}

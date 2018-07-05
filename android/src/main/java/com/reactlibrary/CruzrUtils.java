package com.reactlibrary;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;

import com.reactlibrary.orvibo.APIMain;
import com.ubtechinc.cruzr.sdk.speech.ISpeechContext;
import com.ubtechinc.cruzr.sdk.speech.SpeechRobotApi;
import com.ubtechinc.cruzr.serverlibutil.interfaces.InitListener;

import org.json.JSONObject;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Description
 * @Author yongjian.chen
 * @Date 2018/6/27
 * @Version
 */

public class CruzrUtils {
    public static final int Regist = 0x00001;
    public static final int GetDeviceList = 0x00002;
    public static final int Bindhost = 0x00003;
    public static final int Control = 0x00004;
    static ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
    public static Handler mHandler = new Handler() {

        @Override
        public void handleMessage(Message msg) {
            // TODO Auto-generated method stub

            Log.d("SJQ", "handleMessage");
            super.handleMessage(msg);
            switch (msg.what) {
                case Regist:
                    String result = msg.getData().getString("result");
//                    Toast.makeText(, result, Toast.LENGTH_LONG).show();
                    Log.i("orvibo", result);
//                    reaultTv.setText(""+msg.getData().getString("type")+":"+ StringUtil.toJson(result));
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
                            if (intentStr.contains("购物") || intentStr.contains("导购") || intentStr.contains("导购屏") || intentStr.contains("")) {
//                                listener.startApp();
                                regist();
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }


                    }
                });
            }
        });
    }

    public static void regist() {
        Runnable runnable = new Runnable() {

            public void run() {
                try {
                    String result = "";
                    result = APIMain.regist();

                    Message msg = new Message();
                    msg.what = 1;
                    Bundle bundle = new Bundle();
                    bundle.putString("result", result);
                    bundle.putString("type", Regist + "");
                    msg.setData(bundle);
                    mHandler.sendMessage(msg);
                } catch (Exception e) {
                    Log.i("orvibo", "error");
                }

            }

        };

        cachedThreadPool.execute(runnable);
    }

    public static void getDeviceList() {
        Runnable runnable = new Runnable() {

            public void run() {
                try {
                    String result = "";
                    result = APIMain.getDeviceList();
                    Message msg = new Message();
                    msg.what = 1;
                    Bundle bundle = new Bundle();
                    bundle.putString("result", result);
                    bundle.putString("type", GetDeviceList + "");
                    msg.setData(bundle);
                    mHandler.sendMessage(msg);
                } catch (Exception e) {
                    Log.i("orvibo", "error");
                }

            }

        };

        cachedThreadPool.execute(runnable);
    }

    public static void bindhost() {
        Runnable runnable = new Runnable() {

            public void run() {
                try {
                    String result = "";
                    result = APIMain.bindhost();
                    Message msg = new Message();
                    msg.what = 1;
                    Bundle bundle = new Bundle();
                    bundle.putString("result", result);
                    bundle.putString("type", Bindhost + "");
                    msg.setData(bundle);
                    mHandler.sendMessage(msg);
                    Looper.loop();
                } catch (Exception e) {
                    Log.i("orvibo", "error");
                }

            }

        };

        cachedThreadPool.execute(runnable);
    }

    public static void control() {
        Runnable runnable = new Runnable() {

            public void run() {
                try {
                    String result = "";
                    result = APIMain.control();
                    Message msg = new Message();
                    msg.what = 1;
                    Bundle bundle = new Bundle();
                    bundle.putString("result", result);
                    bundle.putString("type", Control + "");
                    msg.setData(bundle);
                    mHandler.sendMessage(msg);
                } catch (Exception e) {
                    Log.i("orvibo", "error");
                }

            }

        };

        cachedThreadPool.execute(runnable);
    }
}

package com.reactlibrary;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

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
    /**
     * 语音引擎--初始化
     * @param context
     * @param listener
     */
    public static void init(Context context,final CruzrListener listener){
        SpeechRobotApi.get().initializ(context, 1200,new InitListener() { @Override
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
                        }
                    }catch (Exception e){
                        e.printStackTrace();
                    }


                }
            });
        } });
    }
}

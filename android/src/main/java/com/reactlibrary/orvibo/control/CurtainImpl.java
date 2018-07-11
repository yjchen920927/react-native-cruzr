package com.reactlibrary.orvibo.control;

import android.util.Log;

import com.reactlibrary.orvibo.bean.DeviceInfoResponse;
import com.reactlibrary.orvibo.devicesInterface.IDevice;
import com.reactlibrary.orvibo.util.Constants;
import com.reactlibrary.orvibo.util.ThreadPoolUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description
 * @Author yongjian.chen
 * @Date 2018/7/9
 * @Version
 */

public class CurtainImpl implements IDevice<DeviceInfoResponse.DListBean> {
    @Override
    public void open(final DeviceInfoResponse.DListBean dListBean) {
        Runnable runnable = new Runnable() {

            public void run() {
                try {
                    String result = "";
                    Map<String, String> paramsMap = new HashMap<String, String>();
                    paramsMap.put("uid", dListBean.getUid());
                    paramsMap.put("deviceId", dListBean.getDeviceId());
                    paramsMap.put("order", Constants.ORDER_OPEN);
                    paramsMap.put("value1", "100");
                    paramsMap.put("value2", "0");
                    paramsMap.put("value3", "0");
                    paramsMap.put("value4", "0");
                    result = OrviboApiModel.control(paramsMap);
                    Log.i("orvibo--ICurtain--open", result);
                } catch (Exception e) {
                    Log.i("orvibo", "error");
                }

            }

        };

        ThreadPoolUtil.getInstance().execute(runnable);
    }

    @Override
    public void close(final DeviceInfoResponse.DListBean dListBean) {
        Runnable runnable = new Runnable() {

            public void run() {
                try {
                    String result = "";
                    Map<String, String> paramsMap = new HashMap<String, String>();
                    paramsMap.put("uid", dListBean.getUid());
                    paramsMap.put("deviceId", dListBean.getDeviceId());
                    paramsMap.put("order", Constants.ORDER_CLOSE);
                    paramsMap.put("value1", "0");
                    paramsMap.put("value2", "0");
                    paramsMap.put("value3", "0");
                    paramsMap.put("value4", "0");
                    result = OrviboApiModel.control(paramsMap);
                    Log.i("orvibo--ICurtain--close", result);
                } catch (Exception e) {
                    Log.i("orvibo", "error");
                }

            }

        };

        ThreadPoolUtil.getInstance().execute(runnable);
    }

    public void stop(final DeviceInfoResponse.DListBean dListBean) {
        Runnable runnable = new Runnable() {

            public void run() {
                try {
                    String result = "";
                    Map<String, String> paramsMap = new HashMap<String, String>();
                    paramsMap.put("uid", dListBean.getUid());
                    paramsMap.put("deviceId", dListBean.getDeviceId());
                    paramsMap.put("order", Constants.ORDER_STOP);
                    paramsMap.put("value1", "0");
                    paramsMap.put("value2", "0");
                    paramsMap.put("value3", "0");
                    paramsMap.put("value4", "0");
                    result = OrviboApiModel.control(paramsMap);
                    Log.i("orvibo--ICurtain--stop", result);
                } catch (Exception e) {
                    Log.i("orvibo", "error");
                }

            }

        };

        ThreadPoolUtil.getInstance().execute(runnable);
    }
}

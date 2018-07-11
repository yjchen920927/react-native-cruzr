package com.reactlibrary.orvibo.control;

import android.util.Log;

import com.reactlibrary.orvibo.bean.SceneListResponse;
import com.reactlibrary.orvibo.devicesInterface.IDevice;
import com.reactlibrary.orvibo.util.Constants;
import com.reactlibrary.orvibo.util.ThreadPoolUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description
 * @Author yongjian.chen
 * @Date 2018/7/10
 * @Version
 */

public class SceneImpl implements IDevice<SceneListResponse.SceneListBean> {
    @Override
    public void open(final SceneListResponse.SceneListBean sceneListBean) {
        Runnable runnable = new Runnable() {

            public void run() {
                try {
                    String result = "";
                    Map<String, String> paramsMap = new HashMap<String, String>();
                    paramsMap.put("sceneNo", sceneListBean.getSceneNo());
                    result = OrviboApiModel.sceneExecute(paramsMap);
                    Log.i("orvibo--sceneImpl--open", result);
                } catch (Exception e) {
                    Log.i("orvibo", "error");
                }

            }

        };

        ThreadPoolUtil.getInstance().execute(runnable);
    }

    @Override
    public void close(SceneListResponse.SceneListBean object) {

    }
}

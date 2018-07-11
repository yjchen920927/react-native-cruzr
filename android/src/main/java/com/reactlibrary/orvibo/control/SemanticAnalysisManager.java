package com.reactlibrary.orvibo.control;

import android.util.Log;

import com.reactlibrary.CruzrUtils;
import com.reactlibrary.orvibo.bean.DeviceInfoResponse;
import com.reactlibrary.orvibo.bean.SceneListResponse;
import com.reactlibrary.orvibo.devicesInterface.IDevice;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description 语意分析管理类
 * @Author yongjian.chen
 * @Date 2018/7/9
 * @Version
 */

public class SemanticAnalysisManager {
    private static SemanticAnalysisManager semanticAnalysisManager;

    public static SemanticAnalysisManager getInstance() {
        if (semanticAnalysisManager == null)
            semanticAnalysisManager = new SemanticAnalysisManager();

        return semanticAnalysisManager;
    }

    public void semanticAnalysis(String str) {
        Log.i("orvibo--semantic","str:"+str);
        if (str.contains("灯")) {
            lightAnalysis(str);
        } else if (str.contains("帘")) {
            curtainAnalysis(str);
        } else if (str.contains("智能音响") || str.contains("上一首") || str.contains("下一首")) {
            stereoAnalysis(str);
        } else if(str.contains("模式")){
            sceneAnalysis(str);
        }

    }

    /**
     * 灯操作
     *
     * @param str
     */
    private void lightAnalysis(String str) {
        List<DeviceInfoResponse.DListBean> list = new ArrayList<>();
        if (str.contains("入户门")) {
            list = filterDevicesByRoomAndName(str, "入户门", "灯");
        } else if (str.contains("餐厅")) {
            list = filterDevicesByRoomAndName(str, "餐厅", "灯");
        } else if (str.contains("客厅")) {
            list = filterDevicesByRoomAndName(str, "客厅", "灯");
        } else if (str.contains("走廊")) {
            list = filterDevicesByRoomAndName(str, "走廊", "灯");
        } else if (str.contains("书房")) {
            list = filterDevicesByRoomAndName(str, "书房", "灯");
        } else if (str.contains("主卧")) {
            list = filterDevicesByRoomAndName(str, "主卧", "灯");
        } else if (str.contains("儿童房")) {
            list = filterDevicesByRoomAndName(str, "儿童房", "灯");
        } else if (str.contains("卫生间")) {
            list = filterDevicesByRoomAndName(str, "卫生间", "灯");
        } else if (str.contains("阳台")) {
            list = filterDevicesByRoomAndName(str, "阳台", "灯");
        }
        Log.i("orvibo--lightAnalysis","list:"+list.size()+"--"+list.toString());
        IDevice iDevice = new LightImpl();
        if (str.contains("打开")) {
            for (int i = 0;i<list.size();i++) {
                iDevice.open(list.get(i));
            }
        } else if (str.contains("关闭")) {
            for (int i = 0;i<list.size();i++) {
                iDevice.close(list.get(i));
            }
        }
    }

    /**
     * 帘操作
     *
     * @param str
     */
    private void curtainAnalysis(String str) {
        List<DeviceInfoResponse.DListBean> list = new ArrayList<>();
        if (str.contains("餐厅")) {
            list = filterDevicesByRoomAndName(str, "餐厅", "帘");
        } else if (str.contains("客厅")) {
            list = filterDevicesByRoomAndName(str, "客厅", "帘");
        } else if (str.contains("书房")) {
            list = filterDevicesByRoomAndName(str, "书房", "帘");
        } else if (str.contains("主卧")) {
            list = filterDevicesByRoomAndName(str, "主卧", "帘");
        } else if (str.contains("儿童房")) {
            list = filterDevicesByRoomAndName(str, "儿童房", "帘");
        } else if (str.contains("阳台")) {
            list = filterDevicesByRoomAndName(str, "阳台", "帘");
        }
        Log.i("orvibo--curtainAnalysis","list:"+list.size()+"--"+list.toString());
        CurtainImpl iDevice = new CurtainImpl();
        if (str.contains("打开")) {
            for (int i = 0;i<list.size();i++) {
                iDevice.open(list.get(i));
            }
        } else if (str.contains("关闭")) {
            for (int i = 0;i<list.size();i++) {
                iDevice.close(list.get(i));
            }
        }
        if (str.contains("打开")) {
            for (int i = 0;i<list.size();i++) {
                iDevice.open(list.get(i));
            }
        } else if (str.contains("关闭")) {
            for (int i = 0;i<list.size();i++) {
                iDevice.close(list.get(i));
            }
        } else if (str.contains("停止")) {
            for (int i = 0;i<list.size();i++) {
                iDevice.stop(list.get(i));
            }
        }
    }

    /**
     * 智能音响
     *
     * @param str
     */
    private void stereoAnalysis(String str) {
        DeviceInfoResponse.DListBean device = filterDeviceByName(str, "智能音响");
        if (device != null) {
            CurtainImpl iDevice = new CurtainImpl();
            if (str.contains("下一首")) {
                iDevice.open(device);
            } else if (str.contains("上一首")) {
                iDevice.close(device);
            } else if (str.contains("播放")) {
                iDevice.stop(device);
            } else if (str.contains("暂停")) {
                iDevice.stop(device);
            }
        }
    }

    /**
     * 情景模式
     * @param str
     */
    private void sceneAnalysis(String str){
        SceneListResponse.SceneListBean sceneListBean = filterScene(str);

        if (sceneListBean != null) {
            Log.i("orvibo--sceneAnalysis","sceneListBean:"+sceneListBean.toString());
            IDevice iDevice = new SceneImpl();
            iDevice.open(sceneListBean);
        }
    }

    /**
     * 过滤情景
     * @param str
     * @return
     */
    private SceneListResponse.SceneListBean filterScene(String str) {
        if (CruzrUtils.sceneListResponse != null) {
            List<SceneListResponse.SceneListBean> dListBeans = CruzrUtils.sceneListResponse.getSceneList();
            for (int i = 0; i < dListBeans.size(); i++) {
                Log.i("orvibo--sceneAnalysis","getSceneName:"+dListBeans.get(i).getSceneName());
                if (str.contains(dListBeans.get(i).getSceneName())) {
                    return dListBeans.get(i);
                }
            }
        }
        return null;
    }

    /**
     * 过滤设备
     * @param str
     * @return
     */
    private DeviceInfoResponse.DListBean filterDevice(String str) {
        if (CruzrUtils.deviceInfoBean != null) {
            List<DeviceInfoResponse.DListBean> dListBeans = CruzrUtils.deviceInfoBean.getDList();
            for (int i = 0; i < dListBeans.size(); i++) {
                if (str.contains(dListBeans.get(i).getDeviceName())) {
                    return dListBeans.get(i);
                }
            }
        }
        return null;
    }

    /**
     * 根据设备名过滤设备
     * @param str
     * @param name
     * @return
     */
    private DeviceInfoResponse.DListBean filterDeviceByName(String str, String name) {
        if (CruzrUtils.deviceInfoBean != null) {
            List<DeviceInfoResponse.DListBean> dListBeans = CruzrUtils.deviceInfoBean.getDList();
            for (int i = 0; i < dListBeans.size(); i++) {
                if (str.contains(name)) {
                    return dListBeans.get(i);
                }
            }
        }
        return null;
    }

    /**
     * 根据房间和设备类型名（灯或帘）返回要控制的设备列表
     *
     * @param str
     * @param room
     * @param name
     * @return
     */
    private List<DeviceInfoResponse.DListBean> filterDevicesByRoomAndName(String str, String room, String name) {
        List<DeviceInfoResponse.DListBean> list = new ArrayList<>();
        if (CruzrUtils.deviceInfoBean != null) {
            DeviceInfoResponse.DListBean device = filterDevice(str);
            if (device != null) {//先全匹配判断是否有设备
                list.add(device);
            } else {//再模糊匹配返回列表
                List<DeviceInfoResponse.DListBean> dListBeans = CruzrUtils.deviceInfoBean.getDList();
                for (int i = 0; i < dListBeans.size(); i++) {
                    if (dListBeans.get(i).getDeviceName().contains(room) && dListBeans.get(i).getDeviceName().contains(name)) {
                        list.add(dListBeans.get(i));
                    }
                }
            }
        }
        return list;
    }
}

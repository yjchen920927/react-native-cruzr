package com.reactlibrary.orvibo.bean;

import java.io.Serializable;
import java.util.List;

/**
 * @Description
 * @Author yongjian.chen
 * @Date 2018/7/10
 * @Version
 */

public class SceneListResponse implements Serializable {


    /**
     * status : 0
     * msg : success
     * sceneList : [{"onOffFlag":2,"sceneNo":"351f2f95049e4275b921262feccd2f0b","sceneId":-1,"sceneName":"会客模式","familyId":"cbe1855803a94268875c6cc5bfe60453","uid":"","dList":[{"deviceId":"d9f79ea0261b49b9bfb29f4703e892be","deviceName":"客厅沙帘","sceneBindId":"082112b0b5ae47d78804e3e2ec3a601d","order":"open","value1":100,"value2":1,"value3":0,"value4":0,"delayTime":90}],"pic":1,"createTime":"2018-06-27 13:20:10","updateTime":"2018-06-27 14:41:04"}]
     */

    private int status;
    private String msg;
    private List<SceneListBean> sceneList;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<SceneListBean> getSceneList() {
        return sceneList;
    }

    public void setSceneList(List<SceneListBean> sceneList) {
        this.sceneList = sceneList;
    }

    public static class SceneListBean {
        /**
         * onOffFlag : 2
         * sceneNo : 351f2f95049e4275b921262feccd2f0b
         * sceneId : -1
         * sceneName : 会客模式
         * familyId : cbe1855803a94268875c6cc5bfe60453
         * uid :
         * dList : [{"deviceId":"d9f79ea0261b49b9bfb29f4703e892be","deviceName":"客厅沙帘","sceneBindId":"082112b0b5ae47d78804e3e2ec3a601d","order":"open","value1":100,"value2":1,"value3":0,"value4":0,"delayTime":90}]
         * pic : 1
         * createTime : 2018-06-27 13:20:10
         * updateTime : 2018-06-27 14:41:04
         */

        private int onOffFlag;
        private String sceneNo;
        private int sceneId;
        private String sceneName;
        private String familyId;
        private String uid;
        private int pic;
        private String createTime;
        private String updateTime;
        private List<DListBean> dList;

        public int getOnOffFlag() {
            return onOffFlag;
        }

        public void setOnOffFlag(int onOffFlag) {
            this.onOffFlag = onOffFlag;
        }

        public String getSceneNo() {
            return sceneNo;
        }

        public void setSceneNo(String sceneNo) {
            this.sceneNo = sceneNo;
        }

        public int getSceneId() {
            return sceneId;
        }

        public void setSceneId(int sceneId) {
            this.sceneId = sceneId;
        }

        public String getSceneName() {
            return sceneName;
        }

        public void setSceneName(String sceneName) {
            this.sceneName = sceneName;
        }

        public String getFamilyId() {
            return familyId;
        }

        public void setFamilyId(String familyId) {
            this.familyId = familyId;
        }

        public String getUid() {
            return uid;
        }

        public void setUid(String uid) {
            this.uid = uid;
        }

        public int getPic() {
            return pic;
        }

        public void setPic(int pic) {
            this.pic = pic;
        }

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public String getUpdateTime() {
            return updateTime;
        }

        public void setUpdateTime(String updateTime) {
            this.updateTime = updateTime;
        }

        public List<DListBean> getDList() {
            return dList;
        }

        public void setDList(List<DListBean> dList) {
            this.dList = dList;
        }

        public static class DListBean {
            /**
             * deviceId : d9f79ea0261b49b9bfb29f4703e892be
             * deviceName : 客厅沙帘
             * sceneBindId : 082112b0b5ae47d78804e3e2ec3a601d
             * order : open
             * value1 : 100
             * value2 : 1
             * value3 : 0
             * value4 : 0
             * delayTime : 90
             */

            private String deviceId;
            private String deviceName;
            private String sceneBindId;
            private String order;
            private int value1;
            private int value2;
            private int value3;
            private int value4;
            private int delayTime;

            public String getDeviceId() {
                return deviceId;
            }

            public void setDeviceId(String deviceId) {
                this.deviceId = deviceId;
            }

            public String getDeviceName() {
                return deviceName;
            }

            public void setDeviceName(String deviceName) {
                this.deviceName = deviceName;
            }

            public String getSceneBindId() {
                return sceneBindId;
            }

            public void setSceneBindId(String sceneBindId) {
                this.sceneBindId = sceneBindId;
            }

            public String getOrder() {
                return order;
            }

            public void setOrder(String order) {
                this.order = order;
            }

            public int getValue1() {
                return value1;
            }

            public void setValue1(int value1) {
                this.value1 = value1;
            }

            public int getValue2() {
                return value2;
            }

            public void setValue2(int value2) {
                this.value2 = value2;
            }

            public int getValue3() {
                return value3;
            }

            public void setValue3(int value3) {
                this.value3 = value3;
            }

            public int getValue4() {
                return value4;
            }

            public void setValue4(int value4) {
                this.value4 = value4;
            }

            public int getDelayTime() {
                return delayTime;
            }

            public void setDelayTime(int delayTime) {
                this.delayTime = delayTime;
            }

            @Override
            public String toString() {
                return "DListBean{" +
                        "deviceId='" + deviceId + '\'' +
                        ", deviceName='" + deviceName + '\'' +
                        ", sceneBindId='" + sceneBindId + '\'' +
                        ", order='" + order + '\'' +
                        ", value1=" + value1 +
                        ", value2=" + value2 +
                        ", value3=" + value3 +
                        ", value4=" + value4 +
                        ", delayTime=" + delayTime +
                        '}';
            }
        }
    }

    @Override
    public String toString() {
        return "SceneListResponse{" +
                "status=" + status +
                ", msg='" + msg + '\'' +
                ", sceneList=" + sceneList +
                '}';
    }
}

package com.reactlibrary.orvibo.bean;

import java.io.Serializable;
import java.util.List;

/**
 * @Description
 * @Author yongjian.chen
 * @Date 2018/7/6
 * @Version
 */

public class DeviceInfoResponse implements Serializable {


    /**
     * status : 0
     * dList : [{"extAddr":"","uid":"18fe34d6b7bb","deviceId":"a92dce7cb4e648e49527a627c8671ac8","deviceName":"智能插座","deviceType":29,"roomId":"26ac44f5184746e089df3d514a19974e","sceneNo":"","model":"f8b11bed724647e98bd07a66dca6d5b6","sceneBindId":null,"order":null,"value1":null,"value2":null,"value3":null,"value4":null,"delayTime":null,"irDeviceId":null,"company":null,"endpoint":null,"online":null,"roomName":null}]
     * msg : 
     */

    private int status;
    private String msg;
    private List<DListBean> dList;

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

    public List<DListBean> getDList() {
        return dList;
    }

    public void setDList(List<DListBean> dList) {
        this.dList = dList;
    }

    public class DListBean implements Serializable {
        /**
         * extAddr : 
         * uid : 18fe34d6b7bb
         * deviceId : a92dce7cb4e648e49527a627c8671ac8
         * deviceName : 智能插座
         * deviceType : 29
         * roomId : 26ac44f5184746e089df3d514a19974e
         * sceneNo : 
         * model : f8b11bed724647e98bd07a66dca6d5b6
         * sceneBindId : null
         * order : null
         * value1 : null
         * value2 : null
         * value3 : null
         * value4 : null
         * delayTime : null
         * irDeviceId : null
         * company : null
         * endpoint : null
         * online : null
         * roomName : null
         */

        private String extAddr;
        private String uid;
        private String deviceId;
        private String deviceName;
        private int deviceType;
        private String roomId;
        private String sceneNo;
        private String model;
        private String sceneBindId;
        private String order;
        private String value1;
        private String value2;
        private String value3;
        private String value4;
        private String delayTime;
        private String irDeviceId;
        private String company;
        private String endpoint;
        private String online;
        private String roomName;

        public String getExtAddr() {
            return extAddr;
        }

        public void setExtAddr(String extAddr) {
            this.extAddr = extAddr;
        }

        public String getUid() {
            return uid;
        }

        public void setUid(String uid) {
            this.uid = uid;
        }

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

        public int getDeviceType() {
            return deviceType;
        }

        public void setDeviceType(int deviceType) {
            this.deviceType = deviceType;
        }

        public String getRoomId() {
            return roomId;
        }

        public void setRoomId(String roomId) {
            this.roomId = roomId;
        }

        public String getSceneNo() {
            return sceneNo;
        }

        public void setSceneNo(String sceneNo) {
            this.sceneNo = sceneNo;
        }

        public String getModel() {
            return model;
        }

        public void setModel(String model) {
            this.model = model;
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

        public String getValue1() {
            return value1;
        }

        public void setValue1(String value1) {
            this.value1 = value1;
        }

        public String getValue2() {
            return value2;
        }

        public void setValue2(String value2) {
            this.value2 = value2;
        }

        public String getValue3() {
            return value3;
        }

        public void setValue3(String value3) {
            this.value3 = value3;
        }

        public String getValue4() {
            return value4;
        }

        public void setValue4(String value4) {
            this.value4 = value4;
        }

        public String getDelayTime() {
            return delayTime;
        }

        public void setDelayTime(String delayTime) {
            this.delayTime = delayTime;
        }

        public String getIrDeviceId() {
            return irDeviceId;
        }

        public void setIrDeviceId(String irDeviceId) {
            this.irDeviceId = irDeviceId;
        }

        public String getCompany() {
            return company;
        }

        public void setCompany(String company) {
            this.company = company;
        }

        public String getEndpoint() {
            return endpoint;
        }

        public void setEndpoint(String endpoint) {
            this.endpoint = endpoint;
        }

        public String getOnline() {
            return online;
        }

        public void setOnline(String online) {
            this.online = online;
        }

        public String getRoomName() {
            return roomName;
        }

        public void setRoomName(String roomName) {
            this.roomName = roomName;
        }

        @Override
        public String toString() {
            return "DListBean{" +
                    "extAddr='" + extAddr + '\'' +
                    ", uid='" + uid + '\'' +
                    ", deviceId='" + deviceId + '\'' +
                    ", deviceName='" + deviceName + '\'' +
                    ", deviceType=" + deviceType +
                    ", roomId='" + roomId + '\'' +
                    ", sceneNo='" + sceneNo + '\'' +
                    ", model='" + model + '\'' +
                    ", sceneBindId='" + sceneBindId + '\'' +
                    ", order='" + order + '\'' +
                    ", value1='" + value1 + '\'' +
                    ", value2='" + value2 + '\'' +
                    ", value3='" + value3 + '\'' +
                    ", value4='" + value4 + '\'' +
                    ", delayTime='" + delayTime + '\'' +
                    ", irDeviceId='" + irDeviceId + '\'' +
                    ", company='" + company + '\'' +
                    ", endpoint='" + endpoint + '\'' +
                    ", online='" + online + '\'' +
                    ", roomName='" + roomName + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "DeviceInfoBean{" +
                "status=" + status +
                ", msg='" + msg + '\'' +
                ", dList=" + dList +
                '}';
    }
}

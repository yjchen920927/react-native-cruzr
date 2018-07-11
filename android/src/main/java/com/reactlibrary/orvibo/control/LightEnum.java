package com.reactlibrary.orvibo.control;

/**
 * @Description
 * @Author yongjian.chen
 * @Date 2018/7/9
 * @Version
 */

public enum LightEnum {
    TONGDENG("筒灯"), DENGDAI("灯带"), RGBDENGDAI("RGB灯"), DIAODENG("吊灯"),BIDENG("壁灯"),BATAIDENG("吧台灯"),
    ZOUNANDENG("走廊灯"),ZHUDENG("主灯"),CHUANGTAIDENG("窗台灯"),YEMAOJIANDENG("衣帽间灯"),WEISHENGJIANDENG("卫生间灯");
    // 成员变量
    private String name;
    // 构造方法
    private LightEnum(String name) {
        this.name = name;
    }

    // get set 方法
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}

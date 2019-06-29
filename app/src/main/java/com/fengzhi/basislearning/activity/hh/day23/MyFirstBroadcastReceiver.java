package com.fengzhi.basislearning.activity.hh.day23;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * 创建广播接收器的步骤：
 * 1.创建一个类，继承BroadcastReceiver
 *   重写onReceive（）方法
 * 2.在清单配置文件中注册
 *  在<application 节点下，声明<receiver 节点
 *  指定name属性 ＝ “广播的全路径”
 *  指定子节点<intent-filter>  <action name = "声明广播的频道">
 */
public class MyFirstBroadcastReceiver extends BroadcastReceiver {
    /**
     * 当广播有接收消息的时候，就会调用
     * @param context：当前广播接收器所在的上下文
     * @param intent：接收广播的意图
     */
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i("info","====onReceive======");
    }
}

package com.fengzhi.basislearning.activity.hh.day23;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;

import com.fengzhi.basislearning.R;
import com.fengzhi.basislearning.base.SlideBackBaseActivity;

import butterknife.BindView;

public class BroNotifaActivity extends SlideBackBaseActivity {
    @BindView(R.id.title)
    TextView title;
    private NotificationManager manager;
    private IntentFilter mIntentFilter = null;

    private MyFirstBroadcastReceiver mMyBroadcastRecvier = null;
    private NotificationChannel mNotificationChannel;
    public static final String CHANNEL_ID = "default";
    private static final String CHANNEL_NAME = "Default Channel";
    private static final String CHANNEL_DESCRIPTION = "this is default channel!";

    @Override
    protected void initView(@Nullable Bundle savedInstanceState) {
        title.setText("BroNotifaActivity");
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            mNotificationChannel = new NotificationChannel(CHANNEL_ID, CHANNEL_NAME,
                    NotificationManager.IMPORTANCE_DEFAULT);
            mNotificationChannel.setDescription(CHANNEL_DESCRIPTION);
            //获取到通知的管理器对象
            manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
            manager.createNotificationChannel(mNotificationChannel);
        } else manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        //过滤器
        mIntentFilter = new IntentFilter("com.fengzhi.basislearning.activity.hh.day23" +
                ".myfirstbroadcastreceiver");
        //创建广播接收者的对象
        mMyBroadcastRecvier = new MyFirstBroadcastReceiver();
        //注册广播接收者的对象
        registerReceiver(mMyBroadcastRecvier, mIntentFilter);

    }

    //点击发送广播
    public void btnSendBroadcast(View view) {
        Intent intent = new Intent();
        //指定要发送到的广播的频道（在注册的时候指定的广播的action）
        intent.setAction("com.fengzhi.basislearning.activity.hh.day23.myfirstbroadcastreceiver");
        //发送广播
        sendBroadcast(intent);
    }

    //点击发送通知
    public void btnSendNotification(View view) {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, CHANNEL_ID);
        builder.setContentTitle("标题").setContentText("打开应用，抢红包").setSmallIcon(R.mipmap.ic_launcher)//必须的
                .setLargeIcon(BitmapFactory.
                        decodeResource(getResources(), android.R.drawable.ic_menu_compass)).setDefaults(Notification.DEFAULT_SOUND | Notification.DEFAULT_VIBRATE | Notification.DEFAULT_LIGHTS);

        Intent intent = new Intent(this, DetailActivity.class);
        PendingIntent pendingIntent = PendingIntent.
                getActivity(this, 100, intent, PendingIntent.FLAG_ONE_SHOT);//通知只能被点开一次

        //设置通知的延迟意图（打开通知要跳转的页面意图）
        builder.setContentIntent(pendingIntent);

        //获取到了通知对象
        Notification notification = builder.build();
        //发送通知  1:当前通知的唯一标识。在取消通知的时候可能会用到
        manager.notify(1, notification);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //取消广播接收者的注册
        unregisterReceiver(mMyBroadcastRecvier);
    }


    @Override
    protected int getLayoutResId() {
        return R.layout.activity_bro_notifa;
    }
}

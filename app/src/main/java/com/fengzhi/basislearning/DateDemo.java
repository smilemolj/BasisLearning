package com.fengzhi.basislearning;

import java.text.SimpleDateFormat;
import java.util.Date;

class DateDemo {
    public static void learn() {
        Date date = new Date(679845000);
        System.out.println(date);
        SimpleDateFormat format = new SimpleDateFormat();
        //设置显示时间的格式
        /*
         * y:年
         * M:月
         * d：当前月中的天数
         * D:当前事件是今年中的天数
         * E：星期
         * H：小时
         * m：分钟
         * s：秒
         * S：毫秒
         */
        format.applyPattern("yyyy:MM:dd E HH:mm:ss:SS");
        System.out.println(format.format(date));

        //得到距1970 1,1 00:00:00:00 GMT 相距 679845秒的时间并转换格式
    }
}

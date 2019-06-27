package com.fengzhi.basislearning.gl.day13;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class CalendarDemo {
    public static void learn() {
        //获得一个日历的实例
        Calendar instance = Calendar.getInstance();
        Calendar calendar = new GregorianCalendar();
        //get:获得
        System.out.println("年："+calendar.get(Calendar.YEAR));
        System.out.println("月："+(calendar.get(Calendar.MONTH)+1));
        System.out.println("日："+calendar.get(Calendar.DAY_OF_MONTH));
        System.out.println("年中日："+calendar.get(Calendar.DAY_OF_YEAR));
        System.out.println("12小时计数："+calendar.get(Calendar.HOUR));
        System.out.println("24小时计数："+calendar.get(Calendar.HOUR_OF_DAY));
        System.out.println("分钟："+calendar.get(Calendar.MINUTE));
        System.out.println("秒："+calendar.get(Calendar.SECOND));
    }
}

package com.fengzhi.basislearning.gl.day13;

import java.util.Random;

public class RandomDemo {
    public static void learn() {
        Random random = new Random();
        System.out.println(random.nextBoolean());
        System.out.println(random.nextDouble());
        System.out.println(random.nextFloat());
        System.out.println(random.nextInt());
        System.out.println(random.nextInt(10));
        System.out.println(random.nextLong());
        for (int i = 0; i < 1000; i++) {
            //[0,10)
            System.out.print(random.nextInt(10)+",");
        }
        //生成一个大于等于0.0，小于1.0的数
        System.out.println("");
        System.out.println(Math.random());
    }
}

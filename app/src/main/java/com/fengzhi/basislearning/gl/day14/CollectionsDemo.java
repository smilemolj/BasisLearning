package com.fengzhi.basislearning.gl.day14;

import java.util.ArrayList;
import java.util.Collections;

public class CollectionsDemo {
    public static void learn() {
        ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < 10; i++) {
            list.add("b:"+i);
        }
        list.add("a:"+1);
        for (String string : list) {
            System.out.println(string);
        }
        System.out.println("-----------------------");
        //自然排序
//		Collections.sort(list);
        //随机排序
//		Collections.shuffle(list);
//		反转
        Collections.reverse(list);

        for (String string : list) {
            System.out.println(string);
        }
    }
}

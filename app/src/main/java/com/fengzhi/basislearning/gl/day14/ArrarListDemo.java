package com.fengzhi.basislearning.gl.day14;

import java.util.ArrayList;
import java.util.Iterator;

public class ArrarListDemo {

    public static void learn() {
        /**
         * <>泛型
         * 指明集合中存储数据的数据类型
         * 只能写入引用数据类型
         */
        ArrayList<String> list = new ArrayList<String>();
        System.out.println("集合长度：" + list.size());
        System.out.println("集合是否为空:" + list.isEmpty());

        list.add("张三");
        list.add("李四");
        list.add("王五");
        list.add("马六");
        list.add("候七");
        list.add("张龙");
        list.add("赵虎");
        list.add("元芳");
        list.add("包包");
        list.add("波波");
        //允许存空值
        list.add(null);
        //允许重复
        list.add(null);
        //使用for循环遍历集合
//		forErgodic(list);
        //使用foreach遍历集合
//		foreachErgodic(list);
        //使用迭代器遍历
//		iterableErgodic(list);
//		System.out.println("集合长度："+list.size());
//		System.out.println("集合是否为空:"+list.isEmpty());

//		ArrayList<String> copyList = new ArrayList<String>();
        //添加一组元素
//		copyList.addAll(list);
//		iterableErgodic(copyList);
        //移除集合中元素，也会返回当前要移除的元素
        String string = list.remove(list.size() - 1 - 1);
        String string2 = list.remove(list.size() - 1);
        System.out.println(list.size() + string + string2);
//		foreachErgodic(list);
        //修改指定位置的值
        list.set(2, "王麻子");
//		foreachErgodic(list);
        //清除
        list.clear();
        foreachErgodic(list);
    }

    public static void forErgodic(ArrayList<String> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    public static void foreachErgodic(ArrayList<String> list) {
        for (String string : list) {
            System.out.println(string);
        }
    }

    public static void iterableErgodic(ArrayList<String> list) {
        //获得一个迭代器
        Iterator<String> iterator = list.iterator();
        //hasNext：判断当前游标后是否还有元素，有返回true
        while (iterator.hasNext()) {
            //移动游标到下一位，并取出元素
            String s = iterator.next();
            System.out.println(s);
        }
    }
}

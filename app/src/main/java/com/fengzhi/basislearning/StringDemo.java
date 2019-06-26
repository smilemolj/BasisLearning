package com.fengzhi.basislearning;
/**
 * String
 * 		一个不可变的字符序列，值不变性
 * StringBuffer
 *		线程安全的可变字符序列,效率慢
 * StringBuilder
 * 		一个可变的字符序列，线程不安全，效率高
 */
class StringDemo {
    public static void learn() {
        StringBuffer sb = new StringBuffer("abc");
        System.out.println(sb);
        for (int i = 0; i < 2; i++) {
            sb.append("abcdefg");
        }
        System.out.println("==*_*==");
        System.out.println(sb);

        String s = "123456789@qq.com";
        //当前字母第一次出现时所在字符串的下标
        System.out.println(s.indexOf("q"));
        //当前字母最后一次出现时所在字符串的下标
        System.out.println(s.lastIndexOf("q"));

        String s3 = "tnt";
        //忽略大小写比较字符串
        if (s3.equalsIgnoreCase("TNT")) {
            System.out.println("YES");
        }else{
            System.out.println("NO");
        }
        System.out.println('t'+0);
        System.out.println('s'+0);
        System.out.println('u'+0);
        //使用字典顺序比较两个字符串，相同出0
        System.out.println(s3.compareTo("tnt"));
        //当前字符串是否以什么结尾
        System.out.println("day13.txt".endsWith(".txt"));
        //当前字符串是否以什么开始
        System.out.println("day13.txt".startsWith("day"));
        //获得当前字符串中下标为参数的字符
        System.out.println("1234".charAt(3));

        System.out.println("老司机带带我".substring(3));
        System.out.println("老司机带带我".substring(3,5));

        System.out.println("123".concat("456"));
        System.out.println("11223344".replace("1122", "5"));
        //忽略前导空白，后导空白
        System.out.println("   qf  qf   ".trim());
        //小写转大写
        System.out.println("tnT".toUpperCase());
        //大写转小写
        System.out.println("TNT".toLowerCase());
        //valueOf将其他类型数据转换为字符串
        String valueOf = String.valueOf(true);
        System.out.println(valueOf);

        System.out.println("12345".length());
    }
}

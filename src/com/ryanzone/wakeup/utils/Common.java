package com.ryanzone.wakeup.utils;


/**
 * 一些常用的公共方法
 * @author zhangfuli
 */
public class Common {
	/**
	 * 获取显示的小时和分钟
	 * @param start 起始时间
	 * @param end 结束时间
	 * @return 字符串数组
	 */
    public static String[] getTimeStrings(int start, int end) {
	    int lengh = end - start + 1;
	    String[] strings = new String[lengh];
        for (int i = start; i <= end; i++) {
            if (i < 10) {
                strings[i - start] = "0" + i;
            } else {
                strings[i - start] = "" + i;
            }
        }
        return strings;
	}

}
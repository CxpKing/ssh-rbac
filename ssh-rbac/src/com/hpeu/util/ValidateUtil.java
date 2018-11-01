package com.hpeu.util;

/**
 * 验证数据工具类
 * @author 姚臣伟
 */
public class ValidateUtil {
	private ValidateUtil() {}
	
	/**
	 * 验证字符串是否有效
	 * @param str 被验证的字符串
	 * @param reg 正则表达式
	 * @return 返回true表示有效；false表示无效
	 */
	public static boolean validateString(String str, String reg) {
		if (null == str || "".equals(str.trim())) {
			return false;
		}
		return str.matches(reg);
	}
	
	/**
	 * 把字符串的数字转换为整数
	 * @param num 字符串的数字
	 * @return 返回转换后的整数
	 */
	public static int stringToInt(String num) {
		if (null == num || "".equals(num.trim())) {
			return 0;
		}
		try {
			return Integer.parseInt(num);
		} catch (NumberFormatException e) {
			return 0;
		}
	}
}

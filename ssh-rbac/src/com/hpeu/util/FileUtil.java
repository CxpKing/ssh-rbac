package com.hpeu.util;

import java.util.Random;

/**
 * 文件操作工具类
 * @author 姚臣伟
 */
public class FileUtil {
	private FileUtil() {}
	
	/**
	 * 从上传文件信息中获取文件名称
	 * @param str 上传文件信息字符串
	 * @return 返回文件名称
	 */
	public static String getFileName(String str) {
		if (null == str || "".equals(str.trim())) {
			return "";
		}
		//form-data; name="upfile"; filename="2.jpg"
		String tmp = "filename=";
		int p = str.indexOf(tmp);
		if (p != -1) {
			return str.substring(p+tmp.length()+1, str.length()-1);
		} else {
			return "";
		}
	}
	
	/**
	 * 根据mime类型生成扩展名
	 * @param mimeType mime类型
	 * @return 返回扩展名
	 */
	public static String getExt(String mimeType) {
		if (null == mimeType || "".equals(mimeType.trim())) {
			return "";
		}
		switch (mimeType.trim()) {
			case "image/jpeg":
				return ".jpg";
			case "image/png":
				return ".png";
			case "image/gif":
				return ".gif";
		}
		return "";
	}
	
	/**
	 * 根据扩展名重新生成文件名称
	 * @param ext 文件扩展名
	 * @return 返回新的文件名称
	 */
	public static String createFileName(String ext) {
		// 获取时间戳
		long time = System.currentTimeMillis();
		// 获取4位的随机数
		int rnd = new Random().nextInt(9999);
		
		return time + "" + rnd + ext;
	}
	
	
	
	
	
	
	
	
}

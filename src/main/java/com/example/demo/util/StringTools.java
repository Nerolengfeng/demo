/**
 * @包路径：cn.edu.jmun.common.util
 * @文件名：StringTools.java
 * @类描述：TODO(TODO)
 * @创建人：冯文超
 * @创建时间：2016年3月27日  下午7:48:30
 */
package com.example.demo.util;

/**
 * @包路径：cn.edu.jmun.common.util
 * @类名：StringTools
 * @描述：TODO(TODO)
 * @作者：冯文超
 * @创建时间：2016年3月27日  下午7:48:30
 */
public class StringTools {

	public static boolean isEmpty(String str){
		if (str == null || "".equals(str)) {
			return true;
		}
		return false;
	}
	
	public static boolean isNotEmpty(String str) {
		return !isEmpty(str);
	}
	
	public static String toTirm(String str) {
		if (isEmpty(str)) {
			str = "";
		}
		return str;
	}
}

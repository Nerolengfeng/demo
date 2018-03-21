package com.example.demo.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTools {

	private static SimpleDateFormat sdf = new SimpleDateFormat(); 
	
	/**
	 * 获得 yyyy-MM-dd格式的当前时间
	 * @return
	 */
	public static String getCurYMD() {
		sdf.applyPattern("yyyy-MM-dd");
		return sdf.format(new Date());
	}
	
	/**
	 * 获得当前年
	 * @return
	 */
	public static String getCurYear() {
		sdf.applyPattern("yyyy");
		return sdf.format(new Date());
	}
	
	/**
	 * 获得当前月
	 * @return
	 */
	public static String getCurMonth() {
		sdf.applyPattern("MM");
		return sdf.format(new Date());
	}
	
	/**
	 * 获得当前年月
	 * @return
	 */
	public static String getCurYM() {
		sdf.applyPattern("yyyyMM");
		return sdf.format(new Date());
	}
	
	/**
	 * 获得当前时间
	 * @return
	 */
	public static String getNowTime() {
		sdf.applyPattern("yyyyMMddHHmmss");
		return sdf.format(new Date());
	}
	
	/**
	 * 把sourcefmt格式的时间格式字符串，转换成destfmt格式的时间字符串
	 * @param source
	 * @param sourcefmt
	 * @param destfmt
	 * @return
	 */
	public static String getFormatDate(String source, String sourcefmt, String destfmt) {
		if (StringTools.isEmpty(source)) {
			return "";
		}
		sdf.applyPattern(sourcefmt);
		Date date = null;
		try {
			date = sdf.parse(source);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		sdf.applyPattern(destfmt);
		return sdf.format(date);
	}
	
}

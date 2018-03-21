/**
 * @包路径：cn.edu.jmun.common.valuebean
 * @文件名：Region.java
 * @类描述：TODO ( 行政区划地址valuebean )
 * @创建人：冯文超
 * @创建时间：2016年3月26日  下午8:59:11
 */
package com.example.demo.dto;

import org.apache.ibatis.type.Alias;

/**
 * @包路径：cn.edu.jmun.common.valuebean
 * @类名：Region
 * @描述：TODO ( 行政区划地址valuebean )
 * @作者：冯文超
 * @创建时间：2016年3月26日  下午8:59:11
 */
@Alias("RegionVB")
public class RegionVB {
	
	/**
	 * 行政区划表ID 
	 */
	private String id;
	/**
	 * 地名
	 */
	private String name;
	/**
	 * 上级ID
	 */
	private String pid;
	/**
	 * 排序
	 */
	private String sort;
	/**
	 * 行政区划等级()
	 */
	private String level;
	/**
	 * 行政区划代码
	 */
	private String longcode;
	/**
	 * 行政区划代码（小）
	 */
	private String code;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public String getSort() {
		return sort;
	}
	public void setSort(String sort) {
		this.sort = sort;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public String getLongcode() {
		return longcode;
	}
	public void setLongcode(String longcode) {
		this.longcode = longcode;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
	
}

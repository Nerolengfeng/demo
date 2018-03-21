/**
 * @包路径：cn.edu.jmun.common.formbean
 * @文件名：DmbFB.java
 * @类描述：TODO( 代码表FB )
 * @创建人：冯文超
 * @创建时间：2016-4-21  上午11:40:47
 */
package com.example.demo.dto;

/**
 * @包路径：cn.edu.jmun.common.formbean
 * @类名：DmbFB
 * @描述：TODO( 代码表FB )
 * @作者：冯文超
 * @创建时间：2016-4-21  上午11:40:47
 */
public class DmbFB {
	
	/**
	 * 表名
	 */
	private String tablename;
	/**
	 * 代码表 ID
	 */
	private String dmid;
	/**
	 * 代码表 名称
	 */
	private String dmmc;
	/**
	 * 代码表 上一级ID
	 */
	private String pid;
	/**
	 * 代码表 排序
	 */
	private String sort;
	/**
	 * 代码表 是否有效
	 */
	private String sfyx;
	public String getDmid() {
		return dmid;
	}
	public void setDmid(String dmid) {
		this.dmid = dmid;
	}
	public String getDmmc() {
		return dmmc;
	}
	public void setDmmc(String dmmc) {
		this.dmmc = dmmc;
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
	public String getSfyx() {
		return sfyx;
	}
	public void setSfyx(String sfyx) {
		this.sfyx = sfyx;
	}
	public String getTablename() {
		return tablename;
	}
	public void setTablename(String tablename) {
		this.tablename = tablename;
	}
	
}

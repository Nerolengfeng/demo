/**
 * @包路径：cn.edu.jmun.mzgl.valuebean
 * @文件名：YwxxVB.java
 * @类描述：TODO(TODO)
 * @创建人：冯文超
 * @创建时间：2016年5月23日  下午2:00:20
 */
package com.example.demo.dto;

import org.apache.ibatis.type.Alias;

/**
 * @包路径：cn.edu.jmun.mzgl.valuebean
 * @类名：YwxxVB
 * @描述：TODO(TODO)
 * @作者：冯文超
 * @创建时间：2016年5月23日  下午2:00:20
 */
@Alias("YwxxVB")
public class YwxxVB {

	private int dmid;
	private String dmmc;
	private String jg;
	private String sfyx;
	public int getDmid() {
		return dmid;
	}
	public void setDmid(int dmid) {
		this.dmid = dmid;
	}
	public String getDmmc() {
		return dmmc;
	}
	public void setDmmc(String dmmc) {
		this.dmmc = dmmc;
	}
	
	public String getJg() {
		return jg;
	}
	public void setJg(String jg) {
		this.jg = jg;
	}
	public String getSfyx() {
		return sfyx;
	}
	public void setSfyx(String sfyx) {
		this.sfyx = sfyx;
	}
	
	
}

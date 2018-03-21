/**
 * @包路径：cn.edu.jmun.rygl.valuebean
 * @文件名：KqjlVB.java
 * @类描述：TODO(TODO)
 * @创建人：冯文超
 * @创建时间：2016年5月18日  下午1:22:49
 */
package com.example.demo.dto;

import org.apache.ibatis.type.Alias;

/**
 * @包路径：cn.edu.jmun.rygl.valuebean
 * @类名：KqjlVB
 * @描述：TODO(TODO)
 * @作者：冯文超
 * @创建时间：2016年5月18日  下午1:22:49
 */
@Alias("KqjlVB")
public class KqjlVB {
	
	private String kqrq;
	private String sfcd;
	private String dksjz;
	private String sfzt;
	private String dksjw;
	public String getKqrq() {
		return kqrq;
	}
	public void setKqrq(String kqrq) {
		this.kqrq = kqrq;
	}
	public String getSfcd() {
		return sfcd;
	}
	public void setSfcd(String sfcd) {
		this.sfcd = sfcd;
	}
	public String getDksjz() {
		return dksjz;
	}
	public void setDksjz(String dksjz) {
		this.dksjz = dksjz;
	}
	public String getSfzt() {
		return sfzt;
	}
	public void setSfzt(String sfzt) {
		this.sfzt = sfzt;
	}
	public String getDksjw() {
		return dksjw;
	}
	public void setDksjw(String dksjw) {
		this.dksjw = dksjw;
	}

	
}

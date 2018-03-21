/**
 * @包路径：cn.edu.jmun.mzgl.valuebean
 * @文件名：BrxxPojoVB.java
 * @类描述：TODO(TODO)
 * @创建人：冯文超
 * @创建时间：2016年5月22日  下午3:58:57
 */
package com.example.demo.dto;

/**
 * @包路径：cn.edu.jmun.mzgl.valuebean
 * @类名：BrxxPojoVB
 * @描述：TODO(TODO)
 * @作者：冯文超
 * @创建时间：2016年5月22日  下午3:58:57
 */
public class BrxxPojoVB {

	/**
	 * 病人信息
	 */
	private BrjbxxbVB brxx;
	/**
	 * 人员信息
	 */
	private RyjbxxbVB ryxx;
	public BrjbxxbVB getBrxx() {
		return brxx;
	}
	public void setBrxx(BrjbxxbVB brxx) {
		this.brxx = brxx;
	}
	public RyjbxxbVB getRyxx() {
		return ryxx;
	}
	public void setRyxx(RyjbxxbVB ryxx) {
		this.ryxx = ryxx;
	}
	
	
}

/**
 * @包路径：cn.edu.jmun.common.util
 * @文件名：AjaxJsonResult.java
 * @类描述：TODO(TODO)
 * @创建人：冯文超
 * @创建时间：2016年3月26日  下午11:17:36
 */
package com.example.demo.util;


import com.google.gson.Gson;

/**
 * @包路径：cn.edu.jmun.common.util
 * @类名：AjaxJsonResult
 * @描述：TODO ( ajax返回类 )
 * @作者：冯文超
 * @创建时间：2016年3月26日  下午11:17:36
 */
public class AjaxJsonResult {

	/**
	 * 成功返回码
	 */
	public static final int CODE_SUCCESS = 1;

	/**
	 * 失败返回码
	 */
	public static final int CODE_ERROR = -1;

	/**
	 * 登陆超时返回码
	 */
	public static final int CODE_TIMEOUT = -2;

	/**
	 * 系统异常返回码
	 */
	public static final int CODE_SYSEXCEP = -9;
	
	/**
	 * 返回消息
	 */
	private String returnMsg;
	/**
	 * 消息代码（1:成功，-1:失败，-2:登陆超时，-9:系统异常）
	 */
	private int returnCode;
	
	/**
	 * 返回数据对象
	 */
	private Object returnData;
	/**
	 * 总页数
	 */
	private String pageCount;
	/**
	 * 总记录数
	 */
	private String rowsCount;
	/**
	 * 开始行号
	 */
	private String startNum;
	
	public AjaxJsonResult () {
		this.returnCode = CODE_SUCCESS;
	}
	
	/**
	 * 获得JSON对象
	 * @return
	 */
	public String toJSON() {
		return new Gson().toJson(this);
	}
	
	
	/**
	 * 设置操作成功
	 * 
	 */
	public void setOperSuc() {
		this.returnCode = CODE_SUCCESS;
		this.returnMsg = "操作成功！";
	}

	/**
	 * 设置操作成功
	 * 
	 * @param returnData
	 */
	public void setOperSuc(Object returnData) {
		setOperSuc();
		setReturnData(returnData);
	}

	/**
	 * 设置操作失败
	 * 
	 */
	public void setOperErr() {
		this.returnCode = CODE_ERROR;
		this.returnMsg = "操作失败！";
	}

	/**
	 * 设置登陆超时
	 * 
	 */
	public void setLoginTimeOut() {
		this.returnCode = CODE_TIMEOUT;
		this.returnMsg = "登陆超时，请重新登陆！";
	}
	
	/**
	 * 设置系统异常
	 * 
	 * @param t
	 * @exception NullPointerException
	 */
	public void setSysException(Throwable t) {
		if (t == null) {
			throw new NullPointerException("t is null");
		}
		this.returnCode = CODE_SYSEXCEP;
		this.returnMsg = "服务器异常，请稍后再试！";
	}

	public String getReturnMsg() {
		return returnMsg;
	}

	public void setReturnMsg(String returnMsg) {
		this.returnMsg = returnMsg;
	}

	public int getReturnCode() {
		return returnCode;
	}

	public void setReturnCode(int returnCode) {
		this.returnCode = returnCode;
	}

	public Object getReturnData() {
		return returnData;
	}

	public void setReturnData(Object returnData) {
		if (returnData == null) {
			throw new NullPointerException("returnData is null");
		}
		this.returnData = returnData;
	}

	public String getPageCount() {
		return pageCount;
	}

	public void setPageCount(String pageCount) {
		this.pageCount = pageCount;
	}

	public String getRowsCount() {
		return rowsCount;
	}

	public void setRowsCount(String rowsCount) {
		this.rowsCount = rowsCount;
	}

	public String getStartNum() {
		return startNum;
	}

	public void setStartNum(String startNum) {
		this.startNum = startNum;
	}
	
}

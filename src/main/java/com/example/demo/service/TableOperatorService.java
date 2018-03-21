/**
 * @包路径：cn.edu.jmun.common.service
 * @文件名：TableOperatorService.java
 * @类描述：TODO(  )
 * @创建人：冯文超
 * @创建时间：2016-4-21  上午11:33:31
 */
package com.example.demo.service;

/**
 * @包路径：cn.edu.jmun.common.service
 * @类名：TableOperatorService
 * @描述：TODO(  )
 * @作者：冯文超
 * @创建时间：2016-4-21  上午11:33:31
 */
public interface TableOperatorService {

	/**
	 * 获取代码表
	 * @param tablename
	 * @return
	 */
	public String getDmbHtml(String tablename, String param);
	
	/**
	 * 根据ID获取代码表里面的名称
	 * @param tablename
	 * @param dmid
	 * @return
	 */
	public String getDmbName(String tablename, String dmid);
}

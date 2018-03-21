/**
 * @包路径：cn.edu.jmun.common.dao
 * @文件名：TableOperatorDao.java
 * @类描述：TODO( 代码表操作 dao )
 * @创建人：冯文超
 * @创建时间：2016-4-21  上午10:32:26
 */
package com.example.demo.dao;


import com.example.demo.dto.DmbVB;

/**
 * @包路径：cn.edu.jmun.common.dao
 * @类名：TableOperatorDao
 * @描述：TODO( 代码表操作 dao )
 * @作者：冯文超
 * @创建时间：2016-4-21  上午10:32:26
 */
public interface TableOperatorDao {

	/**
	 * 获取代码表
	 * @param tablename
	 * @return
	 */
	public DmbVB[] getDmb(String tablename);
	
	/**
	 * 根据ID获取代码表里面的名称
	 * @param tablename
	 * @param dmid
	 * @return
	 */
	public String getDmbName(String tablename, String dmid);
}

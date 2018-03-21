/**
 * @包路径：cn.edu.jmun.common.dao.impl
 * @文件名：TableOperatorImpl.java
 * @类描述：TODO(  )
 * @创建人：冯文超
 * @创建时间：2016-4-21  上午10:34:12
 */
package com.example.demo.dao.impl;

import org.springframework.stereotype.Repository;

import com.example.demo.dao.TableOperatorDao;
import com.example.demo.dto.DmbVB;

/**
 * @包路径：cn.edu.jmun.common.dao.impl
 * @类名：TableOperatorImpl
 * @描述：TODO(  )
 * @作者：冯文超
 * @创建时间：2016-4-21  上午10:34:12
 */
@Repository
public class TableOperatorDaoImpl  implements TableOperatorDao {


	/**
	 * 获取代码表
	 */
	public DmbVB[] getDmb(String tablename) {
		
		return this.getDmb(tablename);
	}

	/**
	 * 根据ID获取代码表里面的名称
	 * @param tablename
	 * @param dmid
	 * @return
	 */
	public String getDmbName (String tablename, String dmid) {
		
		return this.getDmbName(tablename, dmid);
	}
}

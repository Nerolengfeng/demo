/**
 * @包路径：cn.edu.jmun.common.dao
 * @文件名：RegionDao.java
 * @类描述：TODO ( 行政区划数据 )
 * @创建人：冯文超
 * @创建时间：2016年3月26日  下午9:42:38
 */
package com.example.demo.dao;

import com.example.demo.dto.RegionFB;
import com.example.demo.dto.RegionVB;

/**
 * @包路径：cn.edu.jmun.common.dao
 * @类名：RegionDao
 * @描述：TODO ( 行政区划数据 )
 * @作者：冯文超
 * @创建时间：2016年3月26日  下午9:42:38
 */
public interface RegionDao {

	/**
	 * 获取行政区划数据
	 * @param fb
	 * @return
	 * @throws Exception
	 */
	RegionVB[] getXzqhData(RegionFB fb) throws Exception;
	
	/**
	 * 获得行政区划名称
	 * @param fb
	 * @return
	 */
	public String[] getXzqhName(RegionFB fb);
}

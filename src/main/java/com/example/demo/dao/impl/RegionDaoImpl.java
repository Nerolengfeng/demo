/**
 * @包路径：cn.edu.jmun.common.dao.impl
 * @文件名：RegionDaoImpl.java
 * @类描述：TODO ( 行政区划代码 )
 * @创建人：冯文超
 * @创建时间：2016年3月26日  下午9:43:44
 */
package com.example.demo.dao.impl;

import org.springframework.stereotype.Repository;

import com.example.demo.dao.RegionDao;
import com.example.demo.dto.RegionFB;
import com.example.demo.dto.RegionVB;

/**
 * @包路径：cn.edu.jmun.common.dao.impl
 * @类名：RegionDaoImpl
 * @描述：TODO ( 行政区划代码 )
 * @作者：冯文超
 * @创建时间：2016年3月26日  下午9:43:44
 */
@Repository
public class  RegionDaoImpl  implements RegionDao {



	/**
	 * 获取行政区划数据
	 * @param
	 * @return
	 * @throws Exception
	 */
	public RegionVB[] getXzqhData(RegionFB fb) throws Exception {
		
		return this.getXzqhData(fb);
	}

	/**
	 * 获得行政区划名称
	 * @param fb
	 * @return
	 */
	public String[] getXzqhName (RegionFB fb) {
		
		return this.getXzqhName(fb);
	}

	
}

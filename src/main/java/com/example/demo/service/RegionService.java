/**
 * @包路径：cn.edu.jmun.common.service
 * @文件名：RegionService.java
 * @类描述：TODO(TODO)
 * @创建人：冯文超
 * @创建时间：2016年3月26日  下午9:56:45
 */
package com.example.demo.service;

import com.example.demo.dto.RegionFB;

/**
 * @包路径：cn.edu.jmun.common.service
 * @类名：RegionService
 * @描述：TODO(TODO)
 * @作者：冯文超
 * @创建时间：2016年3月26日  下午9:56:45
 */
public interface RegionService {

	/**
	 * 获取行政区划代码html
	 * @param vb
	 * @return
	 * @throws Exception 
	 */
	String getRegionHtml(RegionFB vb) throws Exception;
	
	/**
	 * 获得行政区划名称
	 * @param
	 * @return
	 */
	public String getXzqhName(String xzqhdm);
}

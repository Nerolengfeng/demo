/**
 * @包路径：cn.edu.jmun.common.service
 * @文件名：RegionServiceImpl.java
 * @类描述：TODO(TODO)
 * @创建人：冯文超
 * @创建时间：2016年3月26日  下午9:59:44
 */
package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.util.StringTools;
import com.example.demo.dao.RegionDao;
import com.example.demo.dto.RegionFB;
import com.example.demo.service.RegionService;
import com.example.demo.dto.RegionVB;

/**
 * @包路径：cn.edu.jmun.common.service
 * @类名：RegionServiceImpl
 * @描述：TODO(TODO)
 * @作者：冯文超
 * @创建时间：2016年3月26日  下午9:59:44
 */
@Service
public class RegionServiceImpl implements RegionService {

	/**
	 * 行政区划Dao
	 */
	@Autowired
	private RegionDao dao;
	
	/**
	 * 获取行政区划代码html
	 * @throws Exception 
	 * 
	 */
	public String getRegionHtml(RegionFB fb) throws Exception  {
		
		fb.setLongcode(StringTools.toTirm(fb.getLongcode())+"%");
		RegionVB[] vbs = dao.getXzqhData(fb);
		StringBuffer sb = new StringBuffer("<option value=''>请选择</option>");
		if (vbs != null && vbs.length > 0) {
			for (RegionVB info : vbs) {
				sb.append("<option value='"+info.getLongcode()+"'>"+info.getName()+"</option>");
			}
		}
		
		return sb.toString();
	}
	
	/**
	 * 获得行政区划名称
	 * @param
	 * @return
	 */
	public String getXzqhName (String xzqhdm) {
		String name = "";
		if (StringTools.isNotEmpty(xzqhdm) && xzqhdm.length() == 12) {
			RegionFB fb = new RegionFB();
			
			fb.setSzs(xzqhdm.substring(0, 2));
			fb.setSzq(xzqhdm.substring(0, 4));
			fb.setSzx(xzqhdm.substring(0, 6));
			fb.setSzz(xzqhdm.substring(0, 9));
			fb.setSzc(xzqhdm);
			
			String[] names = dao.getXzqhName(fb);
			if (names != null && names.length > 0) {
				for (String info : names) {
					name += info;
				}
			}
		}
		return name;
	}

}

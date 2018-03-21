/**
 * @包路径：cn.edu.jmun.common.service.impl
 * @文件名：TableOperatorServiceImpl.java
 * @类描述：TODO(  )
 * @创建人：冯文超
 * @创建时间：2016-4-21  上午11:34:51
 */
package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.util.StringTools;
import com.example.demo.dao.TableOperatorDao;
import com.example.demo.service.TableOperatorService;
import com.example.demo.dto.DmbVB;

/**
 * @包路径：cn.edu.jmun.common.service.impl
 * @类名：TableOperatorServiceImpl
 * @描述：TODO(  )
 * @作者：冯文超
 * @创建时间：2016-4-21  上午11:34:51
 */
@Service
public class TableOperatorServiceImpl implements TableOperatorService {

	/**
	 * 代码表操作dao
	 */
	@Autowired
	private TableOperatorDao dao;
	
	/**
	 * 获取代码表html代码
	 */
	public String getDmbHtml(String tablename, String param) {
		DmbVB[] vbs = dao.getDmb(tablename);
		StringBuffer sbf = new StringBuffer("<option value=''>请选择</option>");
		if (vbs != null && vbs.length > 0) {
			
			for (int i=0; i<vbs.length; i++) {
				if (StringTools.isNotEmpty(param)) {
					sbf.append("<option value='"+vbs[i].getDmid()+"' selected>"+vbs[i].getDmmc()+"</option>");
				} else {
					sbf.append("<option value='"+vbs[i].getDmid()+"'>"+vbs[i].getDmmc()+"</option>");
				}
			}
		}
		return sbf.toString();
	}
	
	/**
	 * 根据ID获取代码表里面的名称
	 * @param tablename
	 * @param dmid
	 * @return
	 */
	public String getDmbName (String tablename, String dmid) {
		String name = "";
		if (StringTools.isNotEmpty(tablename) && StringTools.isNotEmpty(dmid)) {
			name = dao.getDmbName(tablename, dmid);
		}
		return name;
	}
}

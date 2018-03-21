/**
 * @包路径：cn.edu.jmun.common.controller
 * @文件名：RegionController.java
 * @类描述：TODO ( 行政区划Controller )
 * @创建人：冯文超
 * @创建时间：2016年3月26日  下午10:11:32
 */
package com.example.demo.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.util.AjaxJsonResult;
import com.example.demo.dto.RegionFB;
import com.example.demo.service.RegionService;

/**
 * @包路径：cn.edu.jmun.common.controller
 * @类名：RegionController
 * @描述：TODO ( 行政区划Controller )
 * @作者：冯文超
 * @创建时间：2016年3月26日  下午10:11:32
 */
@Controller
@RequestMapping("/common/region")
public class RegionController {
	
	/**
	 * 行政区划service
	 */
	@Autowired
	private RegionService service;
	
	/**
	 * 行政区划代码表
	 * @param fb
	 * @param response
	 */
	@RequestMapping(value="/getRegionHtml", method=RequestMethod.POST)
	public @ResponseBody void getRegionHtml(RegionFB fb, HttpServletResponse response) {
		
		AjaxJsonResult ajaxJsonResult = new AjaxJsonResult();
		try {
			String data = service.getRegionHtml(fb);
			ajaxJsonResult.setReturnData(data);
		} catch (Exception e) {
			e.printStackTrace();
			ajaxJsonResult.setSysException(e);
		} finally {
			try {
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.print(ajaxJsonResult.toJSON());
				out.close();
			} catch (IOException e) {
			}
			
		}
	}
	
	@RequestMapping(value="/getRegionHtml1", method=RequestMethod.POST)
	public @ResponseBody String getRegionHtml1(RegionFB fb, HttpServletResponse response) {
		response.setContentType("text/html;charset=UTF-8");
		AjaxJsonResult ajaxJsonResult = new AjaxJsonResult();
		try {
			String data = service.getRegionHtml(fb);
			ajaxJsonResult.setReturnData(data);
			return ajaxJsonResult.toJSON();
		} catch (Exception e) {
			e.printStackTrace();
			ajaxJsonResult.setSysException(e);
			return ajaxJsonResult.toJSON();
		} 
	}
}

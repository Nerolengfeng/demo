/**
 * @包路径：cn.edu.jmun.common
 * @文件名：TableOperator.java
 * @类描述：TODO( 代码表操作 )
 * @创建人：冯文超
 * @创建时间：2016-4-21  上午10:37:27
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
import com.example.demo.dto.DmbFB;
import com.example.demo.service.TableOperatorService;

/**
 * @包路径：cn.edu.jmun.common
 * @类名：TableOperator
 * @描述：TODO( 代码表操作 )
 * @作者：冯文超
 * @创建时间：2016-4-21  上午10:37:27
 */
@Controller
@RequestMapping("/common/tableoperator")
public class TableOperator {

	/**
	 * 代码表操作service
	 */
	@Autowired
	private TableOperatorService service;
	
	/**
	 * 获得代码表html controller
	 * @param fb
	 * @param response
	 */
	@RequestMapping(value="/getHtmlDmb",method=RequestMethod.POST)
	public @ResponseBody void getHtmlDmb(DmbFB fb, HttpServletResponse response) {
		AjaxJsonResult ajaxJsonResult = new AjaxJsonResult();
		try {
			String data = service.getDmbHtml(fb.getTablename(),fb.getDmid());
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
	
	
	
}

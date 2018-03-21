/**
 * @包路径：cn.edu.jmun.common.controller
 * @文件名：LoginController.java
 * @类描述：TODO(TODO)
 * @创建人：冯文超
 * @创建时间：2016年4月17日  下午9:18:16
 */
package com.example.demo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.util.SessionConfig;
import com.example.demo.dto.LoginFB;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.example.demo.service.LoginService;

/**
 * @包路径：cn.edu.jmun.common.controller
 * @类名：LoginController
 * @描述：TODO(TODO)
 * @作者：冯文超
 * @创建时间：2016年4月17日  下午9:18:16
 */
@Controller
@RequestMapping("/common")
public class LoginController  {

	/**
	 * LoginController
	 */
	@Autowired
	protected LoginService service;
	
	@RequestMapping(value="login",method=RequestMethod.POST)
	public String login(LoginFB fb, HttpServletRequest request, HttpServletResponse response) {
		try {
			
			SessionConfig sessionConf = service.login(fb);
			if (sessionConf != null) {
				request.getSession().setAttribute("sessionConf", sessionConf);
				return "redirect:/index.jsp";
			} else {
				request.getSession().setAttribute("errorMsg", "用户名或密码错误！");
				return "redirect:/login.jsp";
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return "redirect:/index.jsp";
		}
	}

	@GetMapping("/test")
	@ResponseBody
	public ModelAndView Test(){
		ModelAndView mav=new ModelAndView("login");
		return mav;

	}

	@GetMapping("/login")
	public String Login2() {
		System.out.println("调用了");
		return "login";
	}
}

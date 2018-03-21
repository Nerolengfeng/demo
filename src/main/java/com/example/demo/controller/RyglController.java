/**
 * @包路径：cn.edu.jmun.mzgl.controller
 * @文件名：RyglController.java
 * @类描述：TODO( 人员管理Controller )
 * @创建人：冯文超
 * @创建时间：2016-4-21  下午03:32:33
 */
package com.example.demo.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.util.AjaxJsonResult;
import com.example.demo.util.DateTools;
import com.example.demo.util.SessionConfig;
import com.example.demo.util.StringTools;
import com.example.demo.dto.YwryxxFB;
import com.example.demo.service.RyglService;
import com.example.demo.dto.JbgzVB;
import com.example.demo.dto.KqjlVB;
import com.example.demo.dto.RyjbxxbVB;
import com.example.demo.dto.YwryPojoVB;
import com.example.demo.dto.YwryjxkhbVB;
import com.example.demo.dto.YwryqjbVB;

/**
 * @包路径：cn.edu.jmun.mzgl.controller
 * @类名：RyglController
 * @描述：TODO( 人员管理Controller )
 * @作者：冯文超
 * @创建时间：2016-4-21 下午03:32:33
 */
@Controller
@RequestMapping("/rygl")
public class RyglController {

	/**
	 * 注入人员管理service
	 */
	@Autowired
	private RyglService service;

	/**
	 * 根据身份证号码得到人员信息
	 * 
	 * @param fb
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/getRyxxBySfzhm", method = RequestMethod.POST)
	public String getRyxxBySfzhm(YwryxxFB fb, HttpServletRequest request) {
		try {
			SessionConfig sessionConf = (SessionConfig) request.getSession()
					.getAttribute("sessionConf");
			if (sessionConf == null) {
				request.getSession().setAttribute("errorMsg", "连接超时，请重新登录！");
				return "../error.jsp";
			}
			YwryPojoVB vb = service.getRyxxBySfzhm(fb.getSfzhm());
			if (vb == null) {
				RyjbxxbVB ryxx = new RyjbxxbVB();
				ryxx.setSfzhm(fb.getSfzhm());
				ryxx.setXb(Integer.parseInt(fb.getSfzhm().substring(16, 17))
						% 2 + "");
				ryxx.setBirthday(DateTools.getFormatDate(fb.getSfzhm()
						.substring(6, 14), "yyyyMMdd", "yyyy-MM-dd"));
				ryxx.setNl((Integer.parseInt(DateTools.getCurYear()) - Integer
						.parseInt(fb.getSfzhm().substring(6, 10)))
						+ "");

				vb = new YwryPojoVB();
				vb.setRyxx(ryxx);
			} else {
				if (vb.getYwry() != null) {
					vb = null;
					request.getSession().setAttribute("errorMsg", "人员已录入！");
				}
			}
			request.setAttribute("vb", vb);
			return "ryxz.jsp";
		} catch (Exception e) {
			e.printStackTrace();
			request.getSession().setAttribute("errorMsg", "服务器异常，请稍后再试！");
			return "../error.jsp";
		}
	}

	/**
	 * 人员新增保存
	 * 
	 * @param fb
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/ywrySave", method = RequestMethod.POST)
	public String ywrySave(YwryxxFB fb, HttpServletRequest request) {
		try {
			SessionConfig sessionConf = (SessionConfig) request.getSession()
					.getAttribute("sessionConf");
			if (sessionConf == null) {
				request.getSession().setAttribute("errorMsg", "连接超时，请重新登录！");
				return "../error.jsp";
			}
			if (service.ryxzSave(fb)) {
				request.getSession().setAttribute("errorMsg", "操作成功！");
			} else {
				request.getSession().setAttribute("errorMsg", "操作失败！");
			}
			return "ryxz.jsp";
		} catch (Exception e) {
			e.printStackTrace();
			request.getSession().setAttribute("errorMsg", "服务器异常，请稍后再试！");
			return "../error.jsp";
		}
	}

	/**
	 * 判断账号是否存在
	 * 
	 * @param fb
	 * @param request
	 */
	@RequestMapping(value = "/getzhsfcz", method = RequestMethod.POST)
	public void getzhsfcz(YwryxxFB fb, HttpServletResponse response,
			HttpServletRequest request) {
		AjaxJsonResult ajaxJsonResult = new AjaxJsonResult();
		try {
			SessionConfig sessionConf = (SessionConfig) request.getSession()
					.getAttribute("sessionConf");
			if (sessionConf == null) {
				ajaxJsonResult.setLoginTimeOut();
			}
			if (StringTools.isNotEmpty(fb.getZhbm())) {
				if (service.getzhsfcz(fb.getZhbm())) {
					ajaxJsonResult.setOperSuc();
					ajaxJsonResult.setReturnMsg("账号可以使用");
				} else {
					ajaxJsonResult.setOperErr();
					ajaxJsonResult.setReturnMsg("账号已存在");
				}
			} else {
				ajaxJsonResult.setOperErr();
			}
		} catch (Exception e) {
			e.printStackTrace();
			ajaxJsonResult.setSysException(e);
		} finally {
			try {
				PrintWriter out = response.getWriter();
				out.print(ajaxJsonResult.toJSON());
				out.flush();
				out.close();
			} catch (IOException e) {
			}
		}
	}

	/**
	 * 人员信息数查询
	 * 
	 * @param fb
	 * @param response
	 */
	@RequestMapping(value = "/ryxxsCx", method = RequestMethod.POST)
	public void ryxxsCx(YwryxxFB fb, HttpServletResponse response,
			HttpServletRequest request) {
		AjaxJsonResult ajaxJsonResult = new AjaxJsonResult();
		try {
			SessionConfig sessionConf = (SessionConfig) request.getSession()
					.getAttribute("sessionConf");
			if (sessionConf == null) {
				ajaxJsonResult.setLoginTimeOut();
			}
			int rowsCount = service.ryxxsCx(fb);
			ajaxJsonResult.setReturnData(rowsCount);
		} catch (Exception e) {
			e.printStackTrace();
			ajaxJsonResult.setSysException(e);
		} finally {
			try {
				PrintWriter out = response.getWriter();
				out.print(ajaxJsonResult.toJSON());
				out.flush();
				out.close();
			} catch (IOException e) {
			}
		}
	}

	/**
	 * 人员信息查询
	 * 
	 * @param fb
	 * @param response
	 */
	@RequestMapping(value = "/ryxxCx", method = RequestMethod.POST)
	public void ryxxCx(YwryxxFB fb, HttpServletResponse response,
			HttpServletRequest request) {
		AjaxJsonResult ajaxJsonResult = new AjaxJsonResult();
		try {
			SessionConfig sessionConf = (SessionConfig) request.getSession()
					.getAttribute("sessionConf");
			if (sessionConf == null) {
				ajaxJsonResult.setLoginTimeOut();
			}
			YwryPojoVB[] vbs = service.ryxxCx(fb);
			ajaxJsonResult.setReturnData(vbs);
		} catch (Exception e) {
			e.printStackTrace();
			ajaxJsonResult.setSysException(e);
		} finally {
			try {
				PrintWriter out = response.getWriter();
				out.print(ajaxJsonResult.toJSON());
				out.flush();
				out.close();
			} catch (IOException e) {
			}
		}
	}

	/**
	 * 人员信息详显
	 * 
	 * @param fb
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/ryxxXx", method = RequestMethod.GET)
	public String ryxxXx(YwryxxFB fb, HttpServletRequest request) {
		try {
			SessionConfig sessionConf = (SessionConfig) request.getSession()
					.getAttribute("sessionConf");
			if (sessionConf == null) {
				request.getSession().setAttribute("errorMsg", "连接超时，请重新登录！");
				return "../error.jsp";
			}
			if (StringTools.isEmpty(fb.getGrbh())) {
				request.getSession().setAttribute("errorMsg", "服务器异常，请稍后再试！");
			} else {
				YwryPojoVB vb = service.getRyxxByGrbh(fb.getGrbh());
				request.setAttribute("vb", vb);
			}
			return "ryxxxx.jsp";
		} catch (Exception e) {
			e.printStackTrace();
			request.getSession().setAttribute("errorMsg", "服务器异常，请稍后再试！");
			return "../error.jsp";
		}
	}

	/**
	 * 人员信息修改显示
	 * 
	 * @param fb
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/ryxxXgxx", method = RequestMethod.GET)
	public String ryxxXgxx(YwryxxFB fb, HttpServletRequest request) {
		try {
			SessionConfig sessionConf = (SessionConfig) request.getSession()
					.getAttribute("sessionConf");
			if (sessionConf == null) {
				request.getSession().setAttribute("errorMsg", "连接超时，请重新登录！");
				return "../error.jsp";
			}
			if (StringTools.isEmpty(fb.getGrbh())) {
				request.getSession().setAttribute("errorMsg", "服务器异常，请稍后再试！");
			} else {
				YwryPojoVB vb = service.getRyxxByGrbh1(fb.getGrbh());
				request.setAttribute("vb", vb);
			}
			return "ryxxxg.jsp";
		} catch (Exception e) {
			e.printStackTrace();
			request.getSession().setAttribute("errorMsg", "服务器异常，请稍后再试！");
			return "../error.jsp";
		}
	}

	/**
	 * 人员新增保存
	 * 
	 * @param fb
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/updateRyxx", method = RequestMethod.POST)
	public String updateRyxx(YwryxxFB fb, HttpServletRequest request) {
		try {
			SessionConfig sessionConf = (SessionConfig) request.getSession()
					.getAttribute("sessionConf");
			if (sessionConf == null) {
				request.getSession().setAttribute("errorMsg", "连接超时，请重新登录！");
				return "../error.jsp";
			}
			if (service.updateRyxx(fb)) {
				request.getSession().setAttribute("errorMsg", "操作成功！");
			} else {
				request.getSession().setAttribute("errorMsg", "操作失败！");
			}
			return "ryxgcx.jsp";
		} catch (Exception e) {
			e.printStackTrace();
			request.getSession().setAttribute("errorMsg", "服务器异常，请稍后再试！");
			return "../error.jsp";
		}
	}

	/**
	 * 人员注销
	 * 
	 * @param fb
	 * @param response
	 */
	@RequestMapping(value = "ryzx", method = RequestMethod.POST)
	public void ryzx(YwryxxFB fb, HttpServletResponse response,
			HttpServletRequest request) {
		AjaxJsonResult ajaxJsonResult = new AjaxJsonResult();
		try {
			SessionConfig sessionConf = (SessionConfig) request.getSession()
					.getAttribute("sessionConf");
			if (sessionConf == null) {
				ajaxJsonResult.setLoginTimeOut();
			}
			if (service.delRyxx(fb)) {
				ajaxJsonResult.setOperSuc();
			} else {
				ajaxJsonResult.setOperErr();
			}
		} catch (Exception e) {
			e.printStackTrace();
			ajaxJsonResult.setSysException(e);
		} finally {
			try {
				PrintWriter out = response.getWriter();
				out.print(ajaxJsonResult.toJSON());
				out.flush();
				out.close();
			} catch (IOException e) {
			}
		}
	}

	/**
	 * 请假人信息显示
	 * 
	 * @param fb
	 * @return
	 */
	@RequestMapping(value = "qjrxxxx", method = RequestMethod.GET)
	public String qjrxxxx(YwryxxFB fb, HttpServletRequest request) {
		try {
			SessionConfig sessionConf = (SessionConfig) request.getSession()
					.getAttribute("sessionConf");
			if (sessionConf == null) {
				request.getSession().setAttribute("errorMsg", "连接超时，请重新登录！");
				return "../error.jsp";
			}
			if (StringTools.isEmpty(fb.getGrbh())) {
				request.getSession().setAttribute("errorMsg", "服务器异常，请稍后再试！");
			} else {
				YwryPojoVB vb = service.getRyxxByGrbh(fb.getGrbh());
				request.setAttribute("vb", vb);
			}
			return "ryqj.jsp";
		} catch (Exception e) {
			e.printStackTrace();
			request.getSession().setAttribute("errorMsg", "服务器异常，请稍后再试！");
			return "../error.jsp";
		}
	}

	/**
	 * 人员请假
	 * 
	 * @param fb
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "ryqj", method = RequestMethod.POST)
	public String ryqj(YwryxxFB fb, HttpServletRequest request) {
		try {
			SessionConfig sessionConf = (SessionConfig) request.getSession()
					.getAttribute("sessionConf");
			if (sessionConf == null) {
				request.getSession().setAttribute("errorMsg", "连接超时，请重新登录！");
				return "../error.jsp";
			}
			if (service.sfyyqj(fb)) {
				request.getSession().setAttribute("errorMsg", "人员该时间段已经请假！");
			} else {
				if (service.insertYwryqjb(fb)) {
					request.getSession().setAttribute("errorMsg", "提交成功！");
				} else {
					request.getSession().setAttribute("errorMsg", "提交失败！");
				}
			}
			return "ryqjcx.jsp";
		} catch (Exception e) {
			e.printStackTrace();
			request.getSession().setAttribute("errorMsg", "服务器异常，请稍后再试！");
			return "../error.jsp";
		}
	}

	/**
	 * 请假信息数查询
	 * 
	 * @param fb
	 * @param response
	 */
	@RequestMapping(value = "qjxxsCx", method = RequestMethod.POST)
	public void qjxxsCx(YwryxxFB fb, HttpServletResponse response,
			HttpServletRequest request) {
		AjaxJsonResult ajaxJsonResult = new AjaxJsonResult();
		try {
			SessionConfig sessionConf = (SessionConfig) request.getSession()
					.getAttribute("sessionConf");
			if (sessionConf == null) {
				ajaxJsonResult.setLoginTimeOut();
			}
			int count = service.qjryxxsCx(fb);
			ajaxJsonResult.setReturnData(count);
		} catch (Exception e) {
			e.printStackTrace();
			ajaxJsonResult.setSysException(e);
		} finally {
			try {
				PrintWriter out = response.getWriter();
				out.print(ajaxJsonResult.toJSON());
				out.flush();
				out.close();
			} catch (IOException e) {
			}
		}
	}

	/**
	 * 请假信息查询
	 * 
	 * @param fb
	 * @param response
	 */
	@RequestMapping(value = "qjxxCx", method = RequestMethod.POST)
	public void qjxxCx(YwryxxFB fb, HttpServletResponse response,
			HttpServletRequest request) {
		AjaxJsonResult ajaxJsonResult = new AjaxJsonResult();
		try {
			SessionConfig sessionConf = (SessionConfig) request.getSession()
					.getAttribute("sessionConf");
			if (sessionConf == null) {
				ajaxJsonResult.setLoginTimeOut();
			}
			YwryPojoVB[] vbs = service.qjryxxCx(fb);
			ajaxJsonResult.setReturnData(vbs);
		} catch (Exception e) {
			e.printStackTrace();
			ajaxJsonResult.setSysException(e);
		} finally {
			try {
				PrintWriter out = response.getWriter();
				out.print(ajaxJsonResult.toJSON());
				out.flush();
				out.close();
			} catch (IOException e) {
			}
		}
	}

	/**
	 * 请假人员信息详情
	 * 
	 * @param fb
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "qjxxXx", method = RequestMethod.GET)
	public String qjxxXx(YwryxxFB fb, HttpServletRequest request) {
		try {
			SessionConfig sessionConf = (SessionConfig) request.getSession()
					.getAttribute("sessionConf");
			if (sessionConf == null) {
				request.getSession().setAttribute("errorMsg", "连接超时，请重新登录！");
				return "../error.jsp";
			}
			if (StringTools.isEmpty(fb.getGrbh())) {
				request.getSession().setAttribute("errorMsg", "服务器异常，请稍后再试！");
			} else {
				YwryPojoVB vb = service.getRyxxByGrbh(fb.getGrbh());
				YwryqjbVB[] qjxx = service.qjjlxx(fb.getGrbh());
				vb.setQjxx(qjxx);
				request.setAttribute("vb", vb);
			}
			return "qjjlxx.jsp";
		} catch (Exception e) {
			e.printStackTrace();
			request.getSession().setAttribute("errorMsg", "服务器异常，请稍后再试！");
			return "../error.jsp";
		}
	}

	/**
	 * 请假信息查询
	 * 
	 * @param fb
	 * @param response
	 */
	@RequestMapping(value = "qjjlsc", method = RequestMethod.POST)
	public void qjjlsc(YwryxxFB fb, HttpServletResponse response,
			HttpServletRequest request) {
		AjaxJsonResult ajaxJsonResult = new AjaxJsonResult();
		try {
			SessionConfig sessionConf = (SessionConfig) request.getSession()
					.getAttribute("sessionConf");
			if (sessionConf == null) {
				ajaxJsonResult.setLoginTimeOut();
			}
			if (service.delQjjl(fb)) {
				ajaxJsonResult.setOperSuc();
			} else {
				ajaxJsonResult.setOperErr();
			}
		} catch (Exception e) {
			e.printStackTrace();
			ajaxJsonResult.setSysException(e);
		} finally {
			try {
				PrintWriter out = response.getWriter();
				out.print(ajaxJsonResult.toJSON());
				out.flush();
				out.close();
			} catch (IOException e) {
			}
		}
	}

	/**
	 * 请假人员信息详情
	 * 
	 * @param fb
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "qjscXx", method = RequestMethod.GET)
	public String qjscXx(YwryxxFB fb, HttpServletRequest request) {
		try {
			SessionConfig sessionConf = (SessionConfig) request.getSession()
					.getAttribute("sessionConf");
			if (sessionConf == null) {
				request.getSession().setAttribute("errorMsg", "连接超时，请重新登录！");
				return "../error.jsp";
			}
			if (StringTools.isEmpty(fb.getGrbh())) {
				request.getSession().setAttribute("errorMsg", "服务器异常，请稍后再试！");
			} else {
				YwryPojoVB vb = service.getRyxxByGrbh(fb.getGrbh());
				YwryqjbVB[] qjxx = service.qjjlxx(fb.getGrbh());
				vb.setQjxx(qjxx);
				request.setAttribute("vb", vb);
			}
			return "qjxxsc.jsp";
		} catch (Exception e) {
			e.printStackTrace();
			request.getSession().setAttribute("errorMsg", "服务器异常，请稍后再试！");
			return "../error.jsp";
		}
	}

	/**
	 * 可考核人员数查询
	 * @param fb
	 * @return
	 */
	@RequestMapping(value = "kkhrysCx", method = RequestMethod.POST)
	public void kkhrysCx(YwryxxFB fb, HttpServletRequest request,
			HttpServletResponse response) {
		AjaxJsonResult ajaxJsonResult = new AjaxJsonResult();
		try {
			SessionConfig sessionConf = (SessionConfig) request.getSession()
					.getAttribute("sessionConf");
			if (sessionConf == null) {
				ajaxJsonResult.setLoginTimeOut();
			}
			int count = service.kkhrysCx(fb);
			ajaxJsonResult.setReturnData(count);
		} catch (Exception e) {
			e.printStackTrace();
			ajaxJsonResult.setSysException(e);
		} finally {
			try {
				PrintWriter out = response.getWriter();
				out.print(ajaxJsonResult.toJSON());
				out.flush();
				out.close();
			} catch (IOException e) {
			}
		}
	}

	/**
	 * 可考核人员查询
	 * @param fb
	 * @return
	 */
	@RequestMapping(value = "kkhryCx", method = RequestMethod.POST)
	public void kkhryCx(YwryxxFB fb, HttpServletRequest request,
			HttpServletResponse response) {
		AjaxJsonResult ajaxJsonResult = new AjaxJsonResult();
		try {
			SessionConfig sessionConf = (SessionConfig) request.getSession()
					.getAttribute("sessionConf");
			if (sessionConf == null) {
				ajaxJsonResult.setLoginTimeOut();
			}
			YwryPojoVB[] vbs = service.kkhryCx(fb);
			ajaxJsonResult.setReturnData(vbs);
		} catch (Exception e) {
			e.printStackTrace();
			ajaxJsonResult.setSysException(e);
		} finally {
			try {
				PrintWriter out = response.getWriter();
				out.print(ajaxJsonResult.toJSON());
				out.flush();
				out.close();
			} catch (IOException e) {
			}
		}
	}
	
	/**
	 * 人员信息详显
	 * 
	 * @param fb
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "khryxxXx", method = RequestMethod.GET)
	public String khryxxXx(YwryxxFB fb, HttpServletRequest request) {
		try {
			SessionConfig sessionConf = (SessionConfig) request.getSession()
					.getAttribute("sessionConf");
			if (sessionConf == null) {
				request.getSession().setAttribute("errorMsg", "连接超时，请重新登录！");
				return "../error.jsp";
			}
			if (StringTools.isEmpty(fb.getGrbh())) {
				request.getSession().setAttribute("errorMsg", "服务器异常，请稍后再试！");
			} else {
				YwryPojoVB vb = service.getRyxxByGrbh(fb.getGrbh());
				request.setAttribute("vb", vb);
			}
			return "rykh.jsp";
		} catch (Exception e) {
			e.printStackTrace();
			request.getSession().setAttribute("errorMsg", "服务器异常，请稍后再试！");
			return "../error.jsp";
		}
	}
	
	/**
	 * 人员考核保存
	 * @param fb
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "rykhBc", method = RequestMethod.POST)
	public String rykhBc (YwryxxFB fb, HttpServletRequest request) {
		try {
			SessionConfig sessionConf = (SessionConfig) request.getSession()
					.getAttribute("sessionConf");
			if (sessionConf == null) {
				request.getSession().setAttribute("errorMsg", "连接超时，请重新登录！");
				return "../error.jsp";
			}
			
			String khxs[] = {"01", "02", "03", "04", "05", "06", "07"};
			List<YwryjxkhbVB> list = new ArrayList<YwryjxkhbVB>();
			YwryjxkhbVB vb = null;
			String curTime = DateTools.getNowTime();
			String curNY = DateTools.getFormatDate(curTime, "yyyyMMddHHmmss", "yyyyMM");
			for (int i=0; i<khxs.length; i++) {
				vb = new YwryjxkhbVB();
				
				vb.setCzrid(sessionConf.getGrbh());
				vb.setCzsj(curTime);
				vb.setKhny(curNY);
				vb.setGrbh(fb.getGrbh());
				vb.setKhx(khxs[i]);
				
				if ("01".equals(khxs[i])) {
					vb.setKhfs(fb.getZsgzsj());
				} else if ("02".equals(khxs[i])) {
					vb.setKhfs(fb.getZrsg());
				} else if ("03".equals(khxs[i])) {
					vb.setKhfs(fb.getZsjl());
				} else if ("04".equals(khxs[i])) {
					vb.setKhfs(fb.getGztd());
				} else if ("05".equals(khxs[i])) {
					vb.setKhfs(fb.getRwwcqk());
				} else if ("06".equals(khxs[i])) {
					vb.setKhfs(fb.getGzhgx());
				} else if ("07".equals(khxs[i])) {
					vb.setKhfs(fb.getGzzl());
				}
				list.add(vb);
			}
			YwryjxkhbVB[] vbs = new YwryjxkhbVB[list.size()];
			list.toArray(vbs);
			list.clear();
			if (service.rykhBc(vbs)) {
				request.getSession().setAttribute("errorMsg", "提交成功！");
			} else {
				request.getSession().setAttribute("errorMsg", "提交失败！");
			}
			return "ryjxkhcx.jsp";
		} catch (Exception e) {
			e.printStackTrace();
			request.getSession().setAttribute("errorMsg", "服务器异常，请稍后再试！");
			return "../error.jsp";
		}
	}
	
	/**
	 * 人员考核记录数查询
	 * @param fb
	 * @param request
	 * @param response
	 */
	@RequestMapping(value = "rykhjlsCx", method = RequestMethod.POST)
	public void rykhjlsCx (YwryxxFB fb, HttpServletRequest request, HttpServletResponse response) {
		AjaxJsonResult ajaxJsonResult = new AjaxJsonResult();
		try {
			SessionConfig sessionConf = (SessionConfig) request.getSession()
					.getAttribute("sessionConf");
			if (sessionConf == null) {
				ajaxJsonResult.setLoginTimeOut();
			}
			int count = service.rykhjlsCx(fb);
			ajaxJsonResult.setReturnData(count);
		} catch (Exception e) {
			e.printStackTrace();
			ajaxJsonResult.setSysException(e);
		} finally {
			try {
				PrintWriter out = response.getWriter();
				out.print(ajaxJsonResult.toJSON());
				out.flush();
				out.close();
			} catch (Exception e2) {
			}
		}
	}
	
	/**
	 * 人员考核记录查询
	 * @param fb
	 * @param request
	 * @param response
	 */
	@RequestMapping(value = "rykhjlCx", method = RequestMethod.POST)
	public void rykhjlCx (YwryxxFB fb, HttpServletRequest request, HttpServletResponse response) {
		AjaxJsonResult ajaxJsonResult = new AjaxJsonResult();
		try {
			SessionConfig sessionConf = (SessionConfig) request.getSession()
					.getAttribute("sessionConf");
			if (sessionConf == null) {
				ajaxJsonResult.setLoginTimeOut();
			}
			
			YwryPojoVB[] vbs = service.rykhjlCx(fb);
			ajaxJsonResult.setReturnData(vbs);
		} catch (Exception e) {
			e.printStackTrace();
			ajaxJsonResult.setSysException(e);
		} finally {
			try {
				PrintWriter out = response.getWriter();
				out.print(ajaxJsonResult.toJSON());
				out.flush();
				out.close();
			} catch (Exception e2) {
			}
		}
	}
	
	/**
	 * 人员签到
	 * @param fb
	 * @param request
	 * @param response
	 */
	@RequestMapping(value = "ryQd", method = RequestMethod.POST)
	public void ryQd(YwryxxFB fb, HttpServletRequest request, HttpServletResponse response) {
		AjaxJsonResult ajaxJsonResult = new AjaxJsonResult();
		try {
			SessionConfig sessionConf = (SessionConfig) request.getSession()
					.getAttribute("sessionConf");
			if (sessionConf == null) {
				ajaxJsonResult.setLoginTimeOut();
			}
			String msg = "";
			if (service.sfQdQt(fb)) {
				msg = "已签到！";
			} else {
				if (service.qdQtBc(fb)) {
					msg = "签到成功！";
				} else {
					msg = "签到失败！";
				}
			}
			ajaxJsonResult.setReturnData(msg);
		} catch (Exception e) {
			e.printStackTrace();
			ajaxJsonResult.setSysException(e);
		} finally {
			try {
				PrintWriter out = response.getWriter();
				out.print(ajaxJsonResult.toJSON());
				out.flush();
				out.close();
			} catch (Exception e2) {
			}
		}
	}
	
	/**
	 * 人员签退
	 * @param fb
	 * @param request
	 * @param response
	 */
	@RequestMapping(value = "ryQt", method = RequestMethod.POST)
	public void ryQt(YwryxxFB fb, HttpServletRequest request, HttpServletResponse response) {
		AjaxJsonResult ajaxJsonResult = new AjaxJsonResult();
		try {
			SessionConfig sessionConf = (SessionConfig) request.getSession()
					.getAttribute("sessionConf");
			if (sessionConf == null) {
				ajaxJsonResult.setLoginTimeOut();
			}
			String msg = "";
			if (service.sfQdQt(fb)) {
				if (service.zcQt(fb)) {
					msg = "签退成功！";
				} else {
					msg = "签退失败！";
				}
			} else {
				if (service.qdQtBc(fb)) {
					msg = "签退成功！";
				} else {
					msg = "签退失败！";
				}
			}
			ajaxJsonResult.setReturnData(msg);
		} catch (Exception e) {
			e.printStackTrace();
			ajaxJsonResult.setSysException(e);
		} finally {
			try {
				PrintWriter out = response.getWriter();
				out.print(ajaxJsonResult.toJSON());
				out.flush();
				out.close();
			} catch (Exception e2) {
			}
		}
	}
	
	/**
	 * 人员考勤记录数查询
	 * @param fb
	 * @param request
	 * @param response
	 */
	@RequestMapping(value = "kqjlsCx", method = RequestMethod.POST)
	public void kqjlsCx (YwryxxFB fb, HttpServletRequest request, HttpServletResponse response) {
		AjaxJsonResult ajaxJsonResult = new AjaxJsonResult();
		try {
			SessionConfig sessionConf = (SessionConfig) request.getSession()
					.getAttribute("sessionConf");
			if (sessionConf == null) {
				ajaxJsonResult.setLoginTimeOut();
			}
			int count = service.kqjlsCx(fb);
			ajaxJsonResult.setReturnData(count);
		} catch (Exception e) {
			e.printStackTrace();
			ajaxJsonResult.setSysException(e);
		} finally {
			try {
				PrintWriter out = response.getWriter();
				out.print(ajaxJsonResult.toJSON());
				out.flush();
				out.close();
			} catch (Exception e2) {
			}
		}
	}
	
	/**
	 * 人员考勤记录查询
	 * @param fb
	 * @param request
	 * @param response
	 */
	@RequestMapping(value = "kqjlCx", method = RequestMethod.POST)
	public void kqjlCx (YwryxxFB fb, HttpServletRequest request, HttpServletResponse response) {
		AjaxJsonResult ajaxJsonResult = new AjaxJsonResult();
		try {
			SessionConfig sessionConf = (SessionConfig) request.getSession()
					.getAttribute("sessionConf");
			if (sessionConf == null) {
				ajaxJsonResult.setLoginTimeOut();
			}
			
			KqjlVB[] vbs = service.kqjlCx(fb);
			ajaxJsonResult.setReturnData(vbs);
		} catch (Exception e) {
			e.printStackTrace();
			ajaxJsonResult.setSysException(e);
		} finally {
			try {
				PrintWriter out = response.getWriter();
				out.print(ajaxJsonResult.toJSON());
				out.flush();
				out.close();
			} catch (Exception e2) {
			}
		}
	}
	
	/**
	 * 人员工资查询
	 * @param fb
	 * @param request
	 * @param response
	 */
	@RequestMapping(value = "rygzCx", method = RequestMethod.POST)
	public void rygzCx(YwryxxFB fb, HttpServletRequest request, HttpServletResponse response) {
		AjaxJsonResult ajaxJsonResult = new AjaxJsonResult();
		try {
			SessionConfig sessionConf = (SessionConfig) request.getSession()
					.getAttribute("sessionConf");
			if (sessionConf == null) {
				ajaxJsonResult.setLoginTimeOut();
			}
			
			JbgzVB vb = service.rygzCx(fb);
			if (vb != null) {
				ajaxJsonResult.setReturnData(vb);
			}
		} catch (Exception e) {
			e.printStackTrace();
			ajaxJsonResult.setSysException(e);
		} finally {
			try {
				PrintWriter out = response.getWriter();
				out.print(ajaxJsonResult.toJSON());
				out.flush();
				out.close();
			} catch (Exception e2) {
			}
		}
	}
}












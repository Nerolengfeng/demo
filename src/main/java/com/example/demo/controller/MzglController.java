/**
 * @包路径：cn.edu.jmun.mzgl.controller
 * @文件名：MzglController.java
 * @类描述：TODO(TODO)
 * @创建人：冯文超
 * @创建时间：2016年5月21日  下午4:37:45
 */
package com.example.demo.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.util.AjaxJsonResult;
import com.example.demo.util.DateTools;
import com.example.demo.util.SessionConfig;
import com.example.demo.dto.DmbFB;
import com.example.demo.dto.MzglFB;
import com.example.demo.service.MzglService;
import com.example.demo.dto.BrjbxxbVB;
import com.example.demo.dto.BrjcxbVB;
import com.example.demo.dto.BrnyxxbVB;
import com.example.demo.dto.BrxxVB;
import com.example.demo.dto.MzlcztbVB;
import com.example.demo.dto.YwxxVB;
import com.example.demo.dto.RyjbxxbVB;

/**
 * @包路径：cn.edu.jmun.mzgl.controller
 * @类名：MzglController
 * @描述：TODO(TODO)
 * @作者：冯文超
 * @创建时间：2016年5月21日 下午4:37:45
 */
@Controller
@RequestMapping("/mzgl")
public class MzglController {

	@Autowired
	private MzglService service;

	/**
	 * 挂号
	 * @return
	 */
	@RequestMapping(value = "/gh", method = RequestMethod.POST)
	public String gh(MzglFB fb, HttpServletRequest request) {
		try {
			SessionConfig sessionConf = (SessionConfig) request.getSession()
					.getAttribute("sessionConf");
			if (sessionConf == null) {
				request.getSession().setAttribute("errorMsg", "连接超时，请重新登录！");
				return "../error.jsp";
			}
			BrjbxxbVB brvb = service.rysflhCx(fb);
			if (brvb == null) {
				RyjbxxbVB ryxxvb = service.jcksfczCx(fb);
				if (ryxxvb != null) {

				} else {
					ryxxvb = new RyjbxxbVB();
					ryxxvb.setSfzhm(fb.getSfzhm());
					ryxxvb.setXb(Integer.parseInt(fb.getSfzhm().substring(16,
							17))
							% 2 + "");
					ryxxvb.setBirthday(DateTools.getFormatDate(fb.getSfzhm()
							.substring(6, 14), "yyyyMMdd", "yyyyMMdd")
							+ "000000");
					ryxxvb.setNl((Integer.parseInt(DateTools.getCurYear()) - Integer
							.parseInt(fb.getSfzhm().substring(6, 10))) + "");
					request.setAttribute("jcksfcz", "1");
				}
				request.setAttribute("ryxxvb", ryxxvb);
				return "gh_ryxxlr.jsp";
			} else {
				if (service.drghlcsfjs(DateTools.getCurYMD().replace("-", ""),
						fb.getSfzhm())) {// 是否挂号
					request.getSession().setAttribute("errorMsg", "已挂号！");
					return "ghsy.jsp";
				} else {
					request.setAttribute("grbh", brvb.getGrbh());
					request.setAttribute("ghkbh", brvb.getGhkbh());
					return "gh_ksxz.jsp";
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.getSession().setAttribute("errorMsg", "服务器异常，请稍后再试！");
			return "../error.jsp";
		}
	}

	/**
	 * 病人信息保存
	 * @param fb
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "brrySave", method = RequestMethod.POST)
	public String brrySave(MzglFB fb, HttpServletRequest request) {
		try {
			SessionConfig sessionConf = (SessionConfig) request.getSession()
					.getAttribute("sessionConf");
			if (sessionConf == null) {
				request.getSession().setAttribute("errorMsg", "连接超时，请重新登录！");
				return "../error.jsp";
			}

			if (service.brrySave(fb)) {
				BrjbxxbVB brvb = service.rysflhCx(fb);
				request.setAttribute("grbh", brvb.getGrbh());
				request.setAttribute("ghkbh", brvb.getGhkbh());
				request.getSession().setAttribute("errorMsg", "保存成功！");
			} else {
				request.getSession().setAttribute("errorMsg", "保存失败！");
			}

			return "gh_ksxz.jsp";
		} catch (Exception e) {
			e.printStackTrace();
			request.getSession().setAttribute("errorMsg", "服务器异常，请稍后再试！");
			return "../error.jsp";
		}
	}

	/**
	 * 挂号退号
	 * @param fb
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "ghth", method = RequestMethod.POST)
	public String ghth(MzglFB fb, HttpServletRequest request) {
		try {
			SessionConfig sessionConf = (SessionConfig) request.getSession()
					.getAttribute("sessionConf");
			if (sessionConf == null) {
				request.getSession().setAttribute("errorMsg", "连接超时，请重新登录！");
				return "../error.jsp";
			}

			BrjbxxbVB brvb = service.rysflhCx(fb);
			if (brvb == null) {
				request.getSession().setAttribute("errorMsg", "未领号！");
			} else {
				if (service.drghlcsfjs(DateTools.getCurYMD().replace("-", ""),
						fb.getSfzhm())) {// 是否挂号
					MzlcztbVB vb = new MzlcztbVB();
					vb.setGrbh(brvb.getGrbh());
					vb.setGhkbh(brvb.getGhkbh());
					vb.setGhsj(fb.getGhsj().substring(0, 8));
					if (service.thBc(vb)) {// 退号
						request.getSession().setAttribute("errorMsg", "退号成功！");
					} else {
						request.getSession().setAttribute("errorMsg", "退号失败！");
					}
				} else {
					request.getSession().setAttribute("errorMsg", "未挂号！");
				}
			}
			return "ghsy.jsp";
		} catch (Exception e) {
			e.printStackTrace();
			request.getSession().setAttribute("errorMsg", "服务器异常，请稍后再试！");
			return "../error.jsp";
		}
	}

	/**
	 * 挂号保存
	 * @param fb
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "ghBc", method = RequestMethod.POST)
	public String ghBc(MzglFB fb, HttpServletRequest request) {
		try {
			SessionConfig sessionConf = (SessionConfig) request.getSession()
					.getAttribute("sessionConf");
			if (sessionConf == null) {
				request.getSession().setAttribute("errorMsg", "连接超时，请重新登录！");
				return "../error.jsp";
			}

			if (service.drghlcsfjs(DateTools.getCurYMD().replace("-", ""),
					fb.getSfzhm())) {// 是否挂号
				request.getSession().setAttribute("errorMsg", "已挂号！");
			} else {
				MzlcztbVB vb = new MzlcztbVB();
				vb.setGrbh(fb.getGrbh());
				vb.setGhkbh(fb.getGhkbh());
				vb.setGhsj(fb.getGhsj());
				vb.setSsks(fb.getSsks());
				vb.setLczt("01");
				if (service.ryghBc(vb)) {
					request.getSession().setAttribute("errorMsg", "挂号成功！");
				} else {
					request.getSession().setAttribute("errorMsg", "挂号失败！");
				}
			}
			return "ghsy.jsp";
		} catch (Exception e) {
			e.printStackTrace();
			request.getSession().setAttribute("errorMsg", "服务器异常，请稍后再试！");
			return "../error.jsp";
		}
	}

	/**
	 * 病人信息数查询
	 * @param fb
	 * @param response
	 * @param request
	 */
	@RequestMapping(value = "/brxxsCx", method = RequestMethod.POST)
	public void brxxsCx(MzglFB fb, HttpServletResponse response,
			HttpServletRequest request) {

		AjaxJsonResult ajaxJsonResult = new AjaxJsonResult();
		try {
			SessionConfig sessionConf = (SessionConfig) request.getSession()
					.getAttribute("sessionConf");
			if (sessionConf == null) {
				ajaxJsonResult.setLoginTimeOut();
			}
			fb.setSsks(sessionConf.getSsks());
			fb.setLczt("01");
			fb.setDqsj(DateTools.getNowTime());
			int rowsCount = service.brxxsCx(fb);
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
	 * 病人信息查询
	 * @param fb
	 * @param response
	 * @param request
	 */
	@RequestMapping(value = "/brxxCx", method = RequestMethod.POST)
	public void brxxCx(MzglFB fb, HttpServletResponse response,
			HttpServletRequest request) {

		AjaxJsonResult ajaxJsonResult = new AjaxJsonResult();
		try {
			SessionConfig sessionConf = (SessionConfig) request.getSession()
					.getAttribute("sessionConf");
			if (sessionConf == null) {
				ajaxJsonResult.setLoginTimeOut();
			}
			fb.setSsks(sessionConf.getSsks());
			fb.setLczt("01");
			fb.setDqsj(DateTools.getNowTime());
			BrxxVB[] vb = service.brxxCx(fb);
			ajaxJsonResult.setReturnData(vb);
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
	 * 人员问诊信息详显
	 * @param fb
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "rywzXxxx", method = RequestMethod.GET)
	public String rywzXxxx(MzglFB fb, HttpServletRequest request) {
		try {
			SessionConfig sessionConf = (SessionConfig) request.getSession()
					.getAttribute("sessionConf");
			if (sessionConf == null) {
				request.getSession().setAttribute("errorMsg", "连接超时，请重新登录！");
				return "../error.jsp";
			}
			RyjbxxbVB ryxx = service.ryjbxxCx(fb);
			request.setAttribute("ryxx", ryxx);
			request.setAttribute("fb", fb);
			return "wz_wzbc.jsp";
		} catch (Exception e) {
			e.printStackTrace();
			request.getSession().setAttribute("errorMsg", "服务器异常，请稍后再试！");
			return "../error.jsp";
		}
	}
	
	/**
	 * 药物新增
	 * @param fb
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "ywxz", method = RequestMethod.POST)
	public String ywxz(MzglFB fb, HttpServletRequest request) {
		try {
			SessionConfig sessionConf = (SessionConfig) request.getSession()
					.getAttribute("sessionConf");
			if (sessionConf == null) {
				request.getSession().setAttribute("errorMsg", "连接超时，请重新登录！");
				return "../error.jsp";
			}
			if (service.ywsfczCx(fb)) {
				request.getSession().setAttribute("errorMsg", "药物已存在！");
			} else {
				if (service.ykxz(fb)) {
					request.getSession().setAttribute("errorMsg", "新增成功！");
				} else {
					request.getSession().setAttribute("errorMsg", "新增失败！");
				}
			}
			return "ywgl_xz.jsp";
		} catch (Exception e) {
			e.printStackTrace();
			request.getSession().setAttribute("errorMsg", "服务器异常，请稍后再试！");
			return "../error.jsp";
		}		
	}
	
	/**
	 * 药物数查询
	 * @param fb
	 * @param response
	 * @param request
	 */
	@RequestMapping(value = "ywsCx", method = RequestMethod.POST)
	public void ywsCx(MzglFB fb, HttpServletResponse response,
			HttpServletRequest request) {
		AjaxJsonResult ajaxJsonResult = new AjaxJsonResult();
		try {
			SessionConfig sessionConf = (SessionConfig) request.getSession()
					.getAttribute("sessionConf");
			if (sessionConf == null) {
				ajaxJsonResult.setLoginTimeOut();
			}
			int count = service.ywsCx(fb);
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
	 * 药物查询
	 * @param fb
	 * @param response
	 * @param request
	 */
	@RequestMapping(value = "ywCx", method = RequestMethod.POST)
	public void ywCx(MzglFB fb, HttpServletResponse response,
			HttpServletRequest request) {
		AjaxJsonResult ajaxJsonResult = new AjaxJsonResult();
		try {
			SessionConfig sessionConf = (SessionConfig) request.getSession()
					.getAttribute("sessionConf");
			if (sessionConf == null) {
				ajaxJsonResult.setLoginTimeOut();
			}
			YwxxVB[] vbs = service.ywCx(fb);
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
	 * 药物删除
	 * @param fb
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "ywsc", method = RequestMethod.GET)
	public String ywsc(MzglFB fb, HttpServletRequest request) {
		try {
			SessionConfig sessionConf = (SessionConfig) request.getSession()
					.getAttribute("sessionConf");
			if (sessionConf == null) {
				request.getSession().setAttribute("errorMsg", "连接超时，请重新登录！");
				return "../error.jsp";
			}
			if (service.ywsc(fb)) {
				request.getSession().setAttribute("errorMsg", "删除成功！");
			} else {
				request.getSession().setAttribute("errorMsg", "删除失败！");
			}
			return "ywgl_ywsc.jsp";
		} catch (Exception e) {
			e.printStackTrace();
			request.getSession().setAttribute("errorMsg", "服务器异常，请稍后再试！");
			return "../error.jsp";
		}
	}
	
	/**
	 * 获得药物信息代码表
	 * @param fb
	 * @param response
	 */
	@RequestMapping(value = "getYwxxHtml", method = RequestMethod.POST)
	public void getYwxxHtml (DmbFB fb, HttpServletResponse response) {
		AjaxJsonResult ajaxJsonResult = new AjaxJsonResult();
		try {
			String data = service.getYwxxDmb(fb.getTablename());
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
	
	/**
	 * 人员问诊保存
	 * @param fb
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "rywzBc", method = RequestMethod.POST)
	public String rywzBc(MzglFB fb, HttpServletRequest request) {
		try {
			SessionConfig sessionConf = (SessionConfig) request.getSession()
					.getAttribute("sessionConf");
			if (sessionConf == null) {
				request.getSession().setAttribute("errorMsg", "连接超时，请重新登录！");
				return "../error.jsp";
			}
			if (service.rywzBc(fb, sessionConf)) {
				request.getSession().setAttribute("errorMsg", "提交成功！");
			} else {
				request.getSession().setAttribute("errorMsg", "提交失败！");
			}
			return "wz_cx.jsp";
		} catch (Exception e) {
			e.printStackTrace();
			request.getSession().setAttribute("errorMsg", "服务器异常，请稍后再试！");
			return "../error.jsp";
		}
	}
	
	/**
	 * 病人信息数查询
	 * @param fb
	 * @param response
	 * @param request
	 */
	@RequestMapping(value = "/jcjlsCx", method = RequestMethod.POST)
	public void jcjlsCx(MzglFB fb, HttpServletResponse response,
			HttpServletRequest request) {

		AjaxJsonResult ajaxJsonResult = new AjaxJsonResult();
		try {
			SessionConfig sessionConf = (SessionConfig) request.getSession()
					.getAttribute("sessionConf");
			if (sessionConf == null) {
				ajaxJsonResult.setLoginTimeOut();
			}
			fb.setLczt("03");
			fb.setDqsj(DateTools.getNowTime());
			int rowsCount = service.jcjlsCx(fb);
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
	 * 检查记录查询
	 * @param fb
	 * @param response
	 * @param request
	 */
	@RequestMapping(value = "/jcjlCx", method = RequestMethod.POST)
	public void jcjlCx(MzglFB fb, HttpServletResponse response,
			HttpServletRequest request) {

		AjaxJsonResult ajaxJsonResult = new AjaxJsonResult();
		try {
			SessionConfig sessionConf = (SessionConfig) request.getSession()
					.getAttribute("sessionConf");
			if (sessionConf == null) {
				ajaxJsonResult.setLoginTimeOut();
			}
			fb.setLczt("03");
			fb.setDqsj(DateTools.getNowTime());
			BrxxVB[] vb = service.jcjlCx(fb);
			ajaxJsonResult.setReturnData(vb);
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
	 * 缴费病人查数查询
	 * @param fb
	 * @return
	 */
	@RequestMapping(value = "/jfbrsCx", method = RequestMethod.POST)
	public void jfbrsCx(MzglFB fb, HttpServletResponse response,
			HttpServletRequest request) {
		AjaxJsonResult ajaxJsonResult = new AjaxJsonResult();
		try {
			SessionConfig sessionConf = (SessionConfig) request.getSession()
					.getAttribute("sessionConf");
			if (sessionConf == null) {
				ajaxJsonResult.setLoginTimeOut();
			}
			fb.setDqsj(DateTools.getNowTime());
			int rowsCount = service.jfbrsCx(fb);
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
	 * 缴费病人查询
	 * @param fb
	 * @return
	 */
	@RequestMapping(value = "/jfbrCx", method = RequestMethod.POST)
	public void jfbrCx(MzglFB fb, HttpServletResponse response,
			HttpServletRequest request) {
		AjaxJsonResult ajaxJsonResult = new AjaxJsonResult();
		try {
			SessionConfig sessionConf = (SessionConfig) request.getSession()
					.getAttribute("sessionConf");
			if (sessionConf == null) {
				ajaxJsonResult.setLoginTimeOut();
			}
			fb.setDqsj(DateTools.getNowTime());
			BrxxVB[] vb = service.jfbrCx(fb);
			ajaxJsonResult.setReturnData(vb);
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
	 * 门诊收费项查询
	 * @param fb
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "mzsfxCx", method = RequestMethod.GET)
	public String mzsfxCx(MzglFB fb, HttpServletRequest request) {
		try {
			SessionConfig sessionConf = (SessionConfig) request.getSession()
					.getAttribute("sessionConf");
			if (sessionConf == null) {
				request.getSession().setAttribute("errorMsg", "连接超时，请重新登录！");
				return "../error.jsp";
			}
			BrnyxxbVB[] nys = service.ywsfCx(fb);
			BrjcxbVB[] jcs = service.jcsfCx(fb);
			
			request.setAttribute("nys", nys);
			request.setAttribute("jcs", jcs);
			request.setAttribute("fb", fb);
			return "mzsf_sf.jsp";
		} catch (Exception e) {
			e.printStackTrace();
			request.getSession().setAttribute("errorMsg", "服务器异常，请稍后再试！");
			return "../error.jsp";
		}
	}
	
	/**
	 * 人员缴费
	 * @param fb
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "ryjf", method = RequestMethod.POST)
	public String ryjf(MzglFB fb, HttpServletRequest request) {
		try {
			SessionConfig sessionConf = (SessionConfig) request.getSession()
					.getAttribute("sessionConf");
			if (sessionConf == null) {
				request.getSession().setAttribute("errorMsg", "连接超时，请重新登录！");
				return "../error.jsp";
			}
			if (service.ryjf(fb)) {
				request.getSession().setAttribute("errorMsg", "缴费成功！");
			} else {
				request.getSession().setAttribute("errorMsg", "缴费失败！");
			}
			return "mzsf_cx.jsp";
		} catch (Exception e) {
			e.printStackTrace();
			request.getSession().setAttribute("errorMsg", "服务器异常，请稍后再试！");
			return "../error.jsp";
		}
	}
	
	
	/**
	 * 获得疾病信息代码表
	 * @param fb
	 * @param response
	 */
	@RequestMapping(value = "getJbxxHtml", method = RequestMethod.POST)
	public void getJbxxHtml (DmbFB fb, HttpServletRequest request, HttpServletResponse response) {
		AjaxJsonResult ajaxJsonResult = new AjaxJsonResult();
		try {
			SessionConfig sessionConf = (SessionConfig) request.getSession()
					.getAttribute("sessionConf");
			String data = service.jbxxCx(sessionConf.getSsks());
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
	
	/**
	 * 门诊收费项查询
	 * @param fb
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "ryjcxxCx", method = RequestMethod.GET)
	public String ryjcxxCx(MzglFB fb, HttpServletRequest request) {
		try {
			SessionConfig sessionConf = (SessionConfig) request.getSession()
					.getAttribute("sessionConf");
			if (sessionConf == null) {
				request.getSession().setAttribute("errorMsg", "连接超时，请重新登录！");
				return "../error.jsp";
			}
			
			RyjbxxbVB ryxx = service.ryjbxxCx(fb);
			BrjcxbVB[] jcs = service.jcsfCx(fb);
			
			request.setAttribute("ryxx", ryxx);
			request.setAttribute("jcs", jcs);
			request.setAttribute("fb", fb);
			return "jcjl_jc.jsp";
		} catch (Exception e) {
			e.printStackTrace();
			request.getSession().setAttribute("errorMsg", "服务器异常，请稍后再试！");
			return "../error.jsp";
		}
	}
}





















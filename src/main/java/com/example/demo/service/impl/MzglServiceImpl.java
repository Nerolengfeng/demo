/**
 * @包路径：cn.edu.jmun.mzgl.service
 * @文件名：MzglServiceImpl.java
 * @类描述：TODO(TODO)
 * @创建人：冯文超
 * @创建时间：2016年5月21日  下午4:45:44
 */
package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.util.DateTools;
import com.example.demo.util.GenerateId;
import com.example.demo.util.SessionConfig;
import com.example.demo.util.StringTools;
import com.example.demo.exception.MySqlSessionException;
import com.example.demo.service.RegionService;
import com.example.demo.service.TableOperatorService;
import com.example.demo.dao.MzglDao;
import com.example.demo.dto.MzglFB;
import com.example.demo.service.MzglService;
import com.example.demo.dto.BrbqbVB;
import com.example.demo.dto.BrjbxxbVB;
import com.example.demo.dto.BrjcxbVB;
import com.example.demo.dto.BrnyxxbVB;
import com.example.demo.dto.BrwzqkbVB;
import com.example.demo.dto.BrxxVB;
import com.example.demo.dto.JbdmbVB;
import com.example.demo.dto.MzlcztbVB;
import com.example.demo.dto.YwxxVB;
import com.example.demo.dto.RyjbxxbVB;

/**
 * @包路径：cn.edu.jmun.mzgl.service
 * @类名：MzglServiceImpl
 * @描述：TODO(TODO)
 * @作者：冯文超
 * @创建时间：2016年5月21日  下午4:45:44
 */
@Service
public class MzglServiceImpl implements MzglService {

	@Autowired
	private MzglDao dao;
	
	@Autowired
	private RegionService region;
	
	@Autowired
	private TableOperatorService table;
	
	/**
	 * 基础库是否存在人员
	 * @param fb
	 * @return
	 */
	public RyjbxxbVB jcksfczCx(MzglFB fb) {
		
		return dao.jcksfczCx(fb);
	}
	
	/**
	 * 人员是否入库
	 * @param fb
	 * @return
	 */
	public BrjbxxbVB rysflhCx(MzglFB fb) {
		
		return dao.rysflhCx(fb);
	}
	
	/**
	 * 人员挂号
	 * @param vb
	 * @return
	 */
	public boolean ryghBc(MzlcztbVB vb) {
		
		return dao.ryghBc(vb) >= 1;
	}
	
	/**
	 * 病人信息保存
	 */
	@Transactional
	public boolean brrySave (MzglFB fb) {
		RyjbxxbVB ryxx = new RyjbxxbVB();
		BrjbxxbVB brxx = new BrjbxxbVB();
		
		fbToRyjbxxb(fb, ryxx);
		int jckflag = 0;
		int brbflag = 0;
		boolean flag = false;
		String grbh = "";
		try {
			if ("1".equals(fb.getJcksfcz())) {
				grbh = GenerateId.getId();
				brxx.setGrbh(grbh);
				ryxx.setGrbh(grbh);
				jckflag = dao.insertRyjbxxb(ryxx);
			} else {
				grbh = fb.getGrbh();
				brxx.setGrbh(fb.getGrbh());
				jckflag = dao.updateRyjcxxb(ryxx);
			}
			String ghkbh = GenerateId.getId();
			brxx.setGrbh(grbh);
			brxx.setGhkbh(ghkbh);
			brxx.setLrsj(fb.getGhsj());
			brxx.setRyjk("1");
			brxx.setLrrid("00000000000000");
			
			brbflag = dao.insertBrjbxxb(brxx);
			if (jckflag >= 1 && brbflag >= 1) {
				flag = true;
			} else {
				throw new MySqlSessionException("MzglServiceImpl", "brrySave", "有方法没执行成功");// 执行失败抛出异常
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
		
	}	
	public void fbToRyjbxxb (MzglFB fb, RyjbxxbVB vb) {
		vb.setGrbh(fb.getGrbh());
		vb.setSfzhm(fb.getSfzhm());
		vb.setXm(fb.getXm());
		vb.setXb(fb.getXb());
		vb.setNl(fb.getNl());
		vb.setBirthday(fb.getBirthday());
		vb.setMz(fb.getMz());
		vb.setTelephone(fb.getTelephone());
		vb.setPhone(fb.getPhone());
		vb.setHkszdxzqh(fb.getHkszdxzqh());
		vb.setJzszdxzqh(fb.getJzszdxzqh());
		vb.setJzszdxx(fb.getJzszdxx());		
	}
	
	/**
	 * 当日挂号流程是否结束
	 * @param ghrq
	 * @param sfzhm
	 * @return
	 */
	public boolean drghlcsfjs(String ghrq,String sfzhm) {
		
		return dao.drghlcsfjs(ghrq, sfzhm) >= 1;
	}
	
	/**
	 * 退号
	 * @param vb
	 * @return
	 */
	public boolean thBc(MzlcztbVB vb) {
		
		return dao.thBc(vb) >= 1;
	}
	
	/**
	 * 病人信息数查询
	 * @param fb
	 * @return
	 */
	public int brxxsCx(MzglFB fb) {
		if (StringTools.isEmpty(fb.getSfzhm())) {
			fb.setSfzhm("");
		}
		if (StringTools.isEmpty(fb.getXm())) {
			fb.setXm("");
		} else {
			fb.setXm(fb.getXm()+"%");
		}
		return dao.brxxsCx(fb);
	}
	
	/**
	 * 病人信息查询
	 * @param fb
	 * @return
	 */
	public BrxxVB[] brxxCx(MzglFB fb) {
		if (StringTools.isEmpty(fb.getSfzhm())) {
			fb.setSfzhm("");
		}
		if (StringTools.isEmpty(fb.getXm())) {
			fb.setXm("");
		} else {
			fb.setXm(fb.getXm()+"%");
		}
		fb.setStartRows(fb.getPageIndex()*fb.getPageSize());
		fb.setEndRows((fb.getPageIndex()+1)*fb.getPageSize());
		BrxxVB[] vbs = dao.brxxCx(fb);
		
		if (vbs != null) {
			for (int i=0; i<vbs.length; i++) {
				vbs[i].setXb("1".equals(vbs[i].getXb())?"男" : "女");
			}
		}
		return vbs;
	}
	
	/**
	 * 人员基本信息查询
	 * @param fb
	 * @return
	 */
	public RyjbxxbVB ryjbxxCx(MzglFB fb) {
		
		RyjbxxbVB vb = dao.ryjbxxCx(fb);
		if (vb != null) {
			vb.setXb("1".equals(vb.getXb())?"男":"女");
			vb.setBirthday(DateTools.getFormatDate(vb.getBirthday(), "yyyyMMddHHmmss", "yyyy-MM-dd"));
			vb.setMz(table.getDmbName("mzdmb", vb.getMz()));
			vb.setHkszdxzqh(region.getXzqhName(vb.getHkszdxzqh()));
			vb.setJzszdxzqh(region.getXzqhName(vb.getJzszdxzqh()));		
		}
		return vb;	
	}
	
	/**
	 * 药物新增
	 * @param fb
	 * @return
	 */
	public boolean ykxz(MzglFB fb) {
		
		return dao.ykxz(fb) >= 1;
	}
	
	/**
	 * 药物是否存在查询
	 * @return
	 */
	public boolean ywsfczCx(MzglFB fb) {
		
		return dao.ywsfczCx(fb) >= 1;
	}
	
	/**
	 * 药物数查询
	 * @param fb
	 * @return
	 */
	public int ywsCx(MzglFB fb) {
		
		return dao.ywsCx(fb);
	}
	
	/**
	 * 药物查询
	 * @param fb
	 * @return
	 */
	public YwxxVB[] ywCx(MzglFB fb) {
		fb.setStartRows(fb.getPageIndex()*fb.getPageSize());
		fb.setEndRows((fb.getPageIndex()+1)*fb.getPageSize());
		return dao.ywCx(fb);
	}
	
	/**
	 * 药物删除
	 * @param fb
	 * @return
	 */
	public boolean ywsc(MzglFB fb) {
		
		return dao.ywsc(fb) >= 1;
	}
	
	/**
	 * 获得药物信息代码表
	 * @return
	 */
	public String getYwxxDmb(String tablename) {
		
		YwxxVB[] vbs = dao.getYwxxDmb(tablename);
		StringBuffer sb = new StringBuffer("<option value=''>请选择</option>");
		if (vbs != null) {
			for (int i=0; i<vbs.length; i++) {
				sb.append("<option value='"+vbs[i].getDmid()+","+vbs[i].getJg()+"'>"+vbs[i].getDmmc()+"</option>");
			}
		}
		return sb.toString();
	}

	/**
	 * 更新流程状态表
	 */
	public boolean updateLcztb(MzlcztbVB vb) {

		return dao.updateLcztb(vb) >= 1;
	}
	
	/**
	 * 插入病人拿药信息表
	 * @param vb
	 * @return
	 */
	public boolean insertBrnyxxb(BrnyxxbVB vb) {
		
		return dao.insertBrnyxxb(vb) >= 0;
	}
	
	/**
	 * 插入病人检查信息表
	 * @param vb
	 * @return
	 */
	public boolean insertBrjcxb(BrjcxbVB vb) {
		
		return dao.insertBrjcxb(vb) >= 0;
	}
	
	/**
	 * 人员问诊管理
	 * @param fb
	 * @return
	 */
	public boolean rywzBc(MzglFB fb, SessionConfig sessionConf) {
		
		boolean flag = true;
		
		MzlcztbVB lczt = new MzlcztbVB();
		lczt.setGrbh(fb.getGrbh());
		lczt.setGhkbh(fb.getGhkbh());
		lczt.setGhsj(fb.getGhsj());
		lczt.setLczt("02");
		lczt.setSfwz("1");
		lczt.setWzysid(sessionConf.getGrbh());
		lczt.setSfqy("1".equals(fb.getSfqy())?"1":"0");
		lczt.setSfjc("1".equals(fb.getSfjc())?"1":"0");
		lczt.setSfjc("1".equals(fb.getSfjc())?"1":"0");
		//更新流程状态表
		flag = updateLcztb(lczt);

		String wzbh = GenerateId.getId();
		BrwzqkbVB wzqk = new BrwzqkbVB();
		wzqk.setGrbh(fb.getGrbh());
		wzqk.setGhkbh(fb.getGhkbh());
		wzqk.setWzbh(wzbh);
		wzqk.setWzsj(DateTools.getNowTime());
		wzqk.setYsbh(sessionConf.getGrbh());
		wzqk.setZysx(fb.getZysx());
		wzqk.setGhsj(fb.getGhsj());
		flag = insertBrwzqkb(wzqk); 
		
		if (fb.getJbid() != null) {
			for (int i=0; i<fb.getJbid().length; i++) {
				BrbqbVB bqb = new BrbqbVB();
				
				bqb.setGrbh(fb.getGrbh());
				bqb.setGhkbh(fb.getGhkbh());
				bqb.setWzbh(wzbh);
				bqb.setJbdm(fb.getJbid()[i]);
				bqb.setJbbx(fb.getJbbx()[i]);

				flag = insertBrbqb(bqb);
			}
		}
		
		if (StringTools.isNotEmpty(fb.getSfqy()) && fb.getYwid() != null) {
			for (int i=0; i<fb.getYwid().length; i++) {
				BrnyxxbVB brny = new BrnyxxbVB();
				brny.setGrbh(fb.getGrbh());
				brny.setGhkbh(fb.getGhkbh());
				brny.setWzbh(wzbh);
				String[] str = fb.getYwid()[i].split(",");
				brny.setYpbh(str[0]);
				brny.setYpfs(fb.getYwfs()[i]);
				brny.setSfjf("0");
				brny.setJnje(Integer.parseInt(str[1])*Integer.parseInt(fb.getYwfs()[i]) +"");
				brny.setSfly("0");
				
				flag = insertBrnyxxb(brny);
			}
		}
		
		if (StringTools.isNotEmpty(fb.getSfjc()) && fb.getJcid() != null) {
			for (int i=0; i<fb.getJcid().length; i++) {
				BrjcxbVB jcxx = new BrjcxbVB();
				jcxx.setGrbh(fb.getGrbh());
				jcxx.setGhkbh(fb.getGhkbh());
				jcxx.setWzbh(wzbh);
				String[] str = fb.getJcid()[i].split(",");
				jcxx.setJcdm(str[0]);
				jcxx.setSfjf("0");
				jcxx.setJnje(str[1]);
				jcxx.setSfjc("0");
				jcxx.setJcsm("");
				
				flag = insertBrjcxb(jcxx);
			}
		}
		return flag;
	}
	
	/**
	 * 插入病人问诊情况表
	 * @param vb
	 * @return
	 */
	public boolean insertBrwzqkb(BrwzqkbVB vb) {
		
		return dao.insertBrwzqkb(vb) >= 1;
	}

	/**
	 * 检查记录数查询
	 * @param fb
	 * @return
	 */
	public int jcjlsCx(MzglFB fb) {
		if (StringTools.isEmpty(fb.getSfzhm())) {
			fb.setSfzhm("");
		}
		if (StringTools.isEmpty(fb.getXm())) {
			fb.setXm("");
		} else {
			fb.setXm(fb.getXm()+"%");
		}
		
		return dao.jcjlsCx(fb);
	}
	
	/**
	 * 检查记录查询
	 * @param fb
	 * @return
	 */
	public BrxxVB[] jcjlCx(MzglFB fb) {
		
		if (StringTools.isEmpty(fb.getSfzhm())) {
			fb.setSfzhm("");
		}
		if (StringTools.isEmpty(fb.getXm())) {
			fb.setXm("");
		} else {
			fb.setXm(fb.getXm()+"%");
		}
		fb.setStartRows(fb.getPageIndex()*fb.getPageSize());
		fb.setEndRows((fb.getPageIndex()+1)*fb.getPageSize());
		return dao.jcjlCx(fb);
	}
	
	
	/**
	 * 缴费病人查数查询
	 * @param fb
	 * @return
	 */
	public int jfbrsCx(MzglFB fb) {
		if (StringTools.isEmpty(fb.getSfzhm())) {
			fb.setSfzhm("");
		}
		if (StringTools.isEmpty(fb.getXm())) {
			fb.setXm("");
		} else {
			fb.setXm(fb.getXm()+"%");
		}
		
		return dao.jfbrsCx(fb);
	}
	
	/**
	 * 缴费病人查询
	 * @param fb
	 * @return
	 */
	public BrxxVB[] jfbrCx(MzglFB fb) {
		

		if (StringTools.isEmpty(fb.getSfzhm())) {
			fb.setSfzhm("");
		}
		if (StringTools.isEmpty(fb.getXm())) {
			fb.setXm("");
		} else {
			fb.setXm(fb.getXm()+"%");
		}
		fb.setStartRows(fb.getPageIndex()*fb.getPageSize());
		fb.setEndRows((fb.getPageIndex()+1)*fb.getPageSize());
		return dao.jfbrCx(fb);
	}
	
	/**
	 * 检查收费查询
	 * @param fb
	 * @return
	 */
	public BrjcxbVB[] jcsfCx(MzglFB fb) {
		
		BrjcxbVB[] vbs = dao.jcsfCx(fb);
		if (vbs != null) {
			for (int i=0; i<vbs.length; i++) {
				vbs[i].setJcmc(table.getDmbName("jcxxdmb", vbs[i].getJcdm()));
			}
		}
		return vbs;
	}
	
	/**
	 * 药物收费查询
	 * @param fb
	 * @return
	 */
	public BrnyxxbVB[] ywsfCx(MzglFB fb) {
		
		BrnyxxbVB[] vbs = dao.ywsfCx(fb);
		if (vbs != null) {
			for (int i=0; i<vbs.length; i++) {
				vbs[i].setYpbh(table.getDmbName("ywxxdmb", vbs[i].getYpbh()));
			}
		}
		return vbs;
	}
	
	/**
	 * 流程状态表缴费
	 * @param fb
	 * @return
	 */
	public boolean lcztbJf(MzglFB fb) {
		
		return dao.lcztbJf(fb) >= 1;
	}
	
	/**
	 * 检查表缴费
	 * @param fb
	 * @return
	 */
	public boolean jcbJf(MzglFB fb) {
		
		return dao.jcbJf(fb) >= 0;
	}
		
	/**
	 * 拿药表缴费
	 * @param fb
	 * @return
	 */
	public boolean nybJf(MzglFB fb) {
		
		return dao.nybJf(fb) >= 0;
	}
	
	/**
	 * 人员缴费
	 * @param fb
	 * @return
	 */
	public boolean ryjf (MzglFB fb) {
		boolean flag = false;
		flag = lcztbJf(fb);
		flag = jcbJf(fb);
		flag = nybJf(fb);
		
		return flag;
	}
	
	/**
	 * 疾病信息查询
	 * @param ssks
	 * @return
	 */
	public String jbxxCx(String ssks) {
		StringBuffer sb = new StringBuffer("<option value=''>请选择</option>");
		JbdmbVB[] vbs = dao.jbxxCx(ssks);
		if (vbs != null) {
			for (int i=0; i<vbs.length; i++) {
				sb.append("<option value='"+vbs[i].getDmid()+"'>"+vbs[i].getDmmc()+"</option>");
			}
		}
		return sb.toString();
	}
	
	/**
	 * 插入病人病情表
	 * @param vb
	 * @return
	 */
	public boolean insertBrbqb(BrbqbVB vb) {
		
		return dao.insertBrbqb(vb) >= 0;
	}
}











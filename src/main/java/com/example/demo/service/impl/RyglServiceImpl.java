/**
 * @包路径：cn.edu.jmun.rygl.service.impl
 * @文件名：RyglServiceImpl.java
 * @类描述：TODO( 人员管理service.impl )
 * @创建人：冯文超
 * @创建时间：2016-4-21  下午04:35:00
 */
package com.example.demo.service.impl;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.util.DateTools;
import com.example.demo.util.GenerateId;
import com.example.demo.util.StringTools;
import com.example.demo.exception.MySqlSessionException;
import com.example.demo.service.RegionService;
import com.example.demo.service.TableOperatorService;
import com.example.demo.dao.RyglDao;
import com.example.demo.dao.impl.RyglDaoImpl;
import com.example.demo.dto.YwryxxFB;
import com.example.demo.service.RyglService;
import com.example.demo.dto.JbgzVB;
import com.example.demo.dto.KqjlVB;
import com.example.demo.dto.RyjbxxbVB;
import com.example.demo.dto.YwryPojoVB;
import com.example.demo.dto.YwryjxkhbVB;
import com.example.demo.dto.YwryqjbVB;
import com.example.demo.dto.YwryxxbVB;
import com.example.demo.dto.YwryzhxxbVB;

/**
 * @包路径：cn.edu.jmun.rygl.service.impl
 * @类名：RyglServiceImpl
 * @描述：TODO( 人员管理service.impl )
 * @作者：冯文超
 * @创建时间：2016-4-21  下午04:35:00
 */
@Service
public class RyglServiceImpl implements RyglService  {

	/**l
	 * 自动注入dao
	 */
	@Autowired
	private RyglDao dao;
	
	@Autowired
	private RegionService region;
	
	@Autowired
	private TableOperatorService table;
	
	/**
	 * 根据身份证获取一个人的信息
	 * @param sfzhm
	 * @return
	 */
	public YwryPojoVB getRyxxBySfzhm (String sfzhm) {
		
		return dao.getRyxxBySfzhm(sfzhm);
	}

	/**
	 * 新增人员信息保存
	 */
	@Transactional
	public boolean ryxzSave(YwryxxFB fb) {
		boolean flag = false;
		boolean grbhflag = false;
		if (StringTools.isNotEmpty(fb.getGrbh())) {
			grbhflag = true;
		}
		if (fb != null) {
			RyjbxxbVB ryxxvb = new RyjbxxbVB();
			YwryxxbVB ywryvb = new YwryxxbVB();
			YwryzhxxbVB zhxxvb = new YwryzhxxbVB();
			if (!grbhflag) {
				String grbh = GenerateId.getId();
				fb.setGrbh(grbh);
			} else {
				fb.setBirthday("");
			}
			fbToRyjbxxb(fb, ryxxvb);
			fbToYwryxxb(fb, ywryvb);
			fbToYwryzhxxvb(fb, zhxxvb);
			try {
				int a = 0;
				if (grbhflag) {
					a = dao.updateRyjcxxb(ryxxvb);
				} else {
					a = dao.insertRyjbxxb(ryxxvb);
				}
				int b = dao.insertYwryxxb(ywryvb);
				int c = dao.insertYwryzhxxb(zhxxvb);
				if (a >=1 && b >= 1 && c >= 1) {
					flag = true;
				} else {
					throw new MySqlSessionException("RyglServiceImpl", "ryxzSave", "有方法没执行成功");// 执行失败抛出异常
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return flag;
	}

	/**
	 * 判断账号信息是否存在
	 */
	public boolean getzhsfcz(String zhbm) {
		
		return dao.getzhsfcz(zhbm);
	}	
	
	public void fbToRyjbxxb (YwryxxFB fb, RyjbxxbVB vb) {
		vb.setGrbh(fb.getGrbh());
		vb.setSfzhm(fb.getSfzhm());
		vb.setXm(fb.getXm());
		vb.setXb(fb.getXb());
		vb.setNl(fb.getNl());
		vb.setBirthday(DateTools.getFormatDate(fb.getBirthday(), "yyyy-MM-dd", "yyyyMMddHHmmss"));
		vb.setMz(fb.getMz());
		vb.setTelephone(fb.getTelephone());
		vb.setPhone(fb.getPhone());
		vb.setHkszdxzqh(fb.getHkszdxzqh());
		vb.setJzszdxzqh(fb.getJzszdxzqh());
		vb.setJzszdxx(fb.getJzszdxx());		
	}
	
	public void fbToYwryxxb (YwryxxFB fb, YwryxxbVB vb) {
		vb.setGrbh(fb.getGrbh());
		vb.setZzmm(fb.getZzmm());
		vb.setWhcd(fb.getWhcd());
		vb.setSsks(fb.getSsks());
		vb.setRysf(fb.getRysf());
		vb.setByyx(fb.getByyx());
		vb.setSxzy(fb.getSxzy());
		vb.setYsdj(fb.getYsdj());
		vb.setNjts(fb.getNjts());
		vb.setJbgz(fb.getJbgz());
		vb.setCzyid(fb.getCzyid());
		vb.setCzsj(DateTools.getFormatDate(fb.getCzsj(), "yyyy-MM-dd", "yyyyMMddHHmmss"));
	}
	
	public void fbToYwryzhxxvb (YwryxxFB fb, YwryzhxxbVB vb) {
		vb.setGrbh(fb.getGrbh());
		vb.setZhbm(fb.getZhbm());
		vb.setZhmm(fb.getZhmm());
	}

	/**
	 * 人员信息数查询
	 */
	public int ryxxsCx(YwryxxFB fb) {
		String xm = fb.getXm();
		if (StringTools.isNotEmpty(fb.getXm())) {
			fb.setXm("%"+xm+"%");
		}
		int count = dao.ryxxsCx(fb);
		fb.setXm(xm);
		return count;
	}

	/**
	 * 人员信息查询
	 */
	public YwryPojoVB[] ryxxCx(YwryxxFB fb) {
		String xm = fb.getXm();
		if (StringTools.isNotEmpty(fb.getXm())) {
			fb.setXm("%"+xm+"%");
		}
		fb.setStartRows(fb.getPageIndex()*fb.getPageSize());
		fb.setEndRows((fb.getPageIndex()+1)*fb.getPageSize());
		YwryPojoVB[] vbs = dao.ryxxCx(fb);
		if (vbs != null && vbs.length > 0) {
			for (YwryPojoVB vb : vbs) {
				vb.getRyxx().setXb("1".equals(vb.getRyxx().getXb())?"男":"女");
				if (StringTools.isNotEmpty(vb.getRyxx().getJzszdxzqh())) {
					vb.getRyxx().setJzszdxzqh(region.getXzqhName(vb.getRyxx().getJzszdxzqh()));
				}
			}
		}
		fb.setXm(xm);
		return vbs;
	}
	
	/**
	 * 根据个人编号获得一个人的信息
	 * @param grbh
	 * @return
	 */
	public YwryPojoVB getRyxxByGrbh (String grbh) {
		
		YwryPojoVB vb = null;
		if (StringTools.isNotEmpty(grbh)) {
			vb = dao.getRyxxByGrbh(grbh);
			RyjbxxbVB ryxx = null;
			if (vb.getRyxx() != null) {
				ryxx = vb.getRyxx();
				ryxx.setXb("1".equals(ryxx.getXb())?"男":"女");
				ryxx.setBirthday(DateTools.getFormatDate(ryxx.getBirthday(), "yyyyMMddHHmmss", "yyyy-MM-dd"));
				ryxx.setMz(table.getDmbName("mzdmb", ryxx.getMz()));
				ryxx.setHkszdxzqh(region.getXzqhName(ryxx.getHkszdxzqh()));
				ryxx.setJzszdxzqh(region.getXzqhName(ryxx.getJzszdxzqh()));				
			}
			YwryxxbVB ywry = null;
			if (vb.getYwry() != null) {
				ywry = vb.getYwry();
				
				ywry.setZzmm(table.getDmbName("zzmmdmb", ywry.getZzmm()));
				ywry.setWhcd(table.getDmbName("xldmb", ywry.getWhcd()));
				ywry.setSsks(table.getDmbName("yyksb", ywry.getSsks()));
				ywry.setRysf(table.getDmbName("rysfdmb", ywry.getRysf()));
				ywry.setYsdj(table.getDmbName("ysjbdmb", ywry.getYsdj()));				
			}
		}
		
		return vb;
	}
	
	/**
	 * 根据个人编号获得一个人的信息
	 * @param grbh
	 * @return
	 */
	public YwryPojoVB getRyxxByGrbh1 (String grbh) {
		
		YwryPojoVB vb = null;
		if (StringTools.isNotEmpty(grbh)) {
			vb = dao.getRyxxByGrbh(grbh);
		}	
		return vb;
	}
	
	/**
	 * 更新人员信息表
	 * @param
	 * @return
	 */
	public boolean updateRyxx (YwryxxFB fb) {
		boolean flag = false;
		if (fb != null) {
			RyjbxxbVB ryxxvb = new RyjbxxbVB();
			YwryxxbVB ywryvb = new YwryxxbVB();
			YwryzhxxbVB zhxxvb = new YwryzhxxbVB();
			fbToRyjbxxb(fb, ryxxvb);
			fbToYwryxxb(fb, ywryvb);
			fbToYwryzhxxvb(fb, zhxxvb);
			SqlSession session = ((RyglDaoImpl)dao).getsqlsession();
			try {
				session.commit(false);
				int a = dao.updateRyjcxxb(ryxxvb);
				int b = dao.updateYwryxxb(ywryvb);
				int c = dao.updateYwryzhxxb(zhxxvb);
				if (a >=1 && b >= 1 && c >= 1) {
					session.commit();
					flag = true;
				} else {
					session.rollback();
				}
			} catch (Exception e) {
				e.printStackTrace();
				session.rollback();
			}
		}
		return flag;
	}
	
	/**
	 * 人员注销
	 * @param fb
	 * @return
	 */
	public boolean delRyxx (YwryxxFB fb) {
		
		boolean flag = false;
		if (StringTools.isNotEmpty(fb.getGrbh())) {
			int a = dao.delYwry(fb.getGrbh());
			int b = dao.delYwryzh(fb.getGrbh());
			if (a >= 1 && b >= 1) {
				flag = true;
			}
		}
		return flag;
	}
	
	/**
	 * 插入请假表
	 * @param
	 * @return
	 */
	public boolean insertYwryqjb (YwryxxFB fb) {
		
		YwryqjbVB vb = new YwryqjbVB();
		fbToYwryqjb(fb, vb);
		return dao.insertYwryqjb(vb) >= 1;
	}
	
	/**
	 * 判断是否已经请假
	 */
	public boolean sfyyqj (YwryxxFB fb) {
		
		YwryqjbVB vb = new YwryqjbVB();
		fbToYwryqjb(fb, vb);
		return dao.sfyyqj(vb) >= 1;
	}
	
	public void fbToYwryqjb(YwryxxFB fb, YwryqjbVB vb) {
		vb.setGrbh(fb.getGrbh());
		vb.setQjrq(DateTools.getFormatDate(fb.getQjrq(), "yyyy-MM-dd", "yyyyMMddHHmmss"));
		vb.setQjsjq(DateTools.getFormatDate(fb.getQjsjq(), "yyyy-MM-dd", "yyyyMMddHHmmss"));
		vb.setQjsjz(DateTools.getFormatDate(fb.getQjsjz(), "yyyy-MM-dd", "yyyyMMddHHmmss"));
		vb.setQjsc(fb.getQjsc());
		vb.setQjlb(fb.getQjlb());
		vb.setQjyy(fb.getQjyy());
		vb.setFzrid(fb.getFzrid());
	}
	
	/**
	 * 人员请假信息查询 
	 * @param fb
	 * @return
	 */
	public YwryPojoVB[] qjryxxCx(YwryxxFB fb) {
		String xm = fb.getXm();
		if (StringTools.isNotEmpty(fb.getXm())) {
			fb.setXm("%"+xm+"%");
		}
		fb.setStartRows(fb.getPageIndex()*fb.getPageSize());
		fb.setEndRows((fb.getPageIndex()+1)*fb.getPageSize());
		YwryPojoVB[] vbs = dao.qjryxxCx(fb);
		if (vbs != null && vbs.length > 0) {
			for (YwryPojoVB vb : vbs) {
				vb.getRyxx().setXb("1".equals(vb.getRyxx().getXb())?"男":"女");
				if (StringTools.isNotEmpty(vb.getRyxx().getJzszdxzqh())) {
					vb.getRyxx().setJzszdxzqh(region.getXzqhName(vb.getRyxx().getJzszdxzqh()));
				}
			}
		}
		return vbs;
	}
	
	/**
	 * 请假信息数查询
	 * @param fb
	 * @return
	 */
	public int qjryxxsCx(YwryxxFB fb) {
		String xm = fb.getXm();
		if (StringTools.isNotEmpty(fb.getXm())) {
			fb.setXm("%"+xm+"%");
		}
		int count = dao.qjryxxsCx(fb);
		fb.setXm(xm);
		return count;
	}
	
	/**
	 * 请假记录详情
	 * @param grbh
	 * @return
	 */
	public YwryqjbVB[] qjjlxx(String grbh) {
		
		YwryqjbVB[] vbs = dao.qjjlxx(grbh);
		for (YwryqjbVB info : vbs) {
			info.setQjlb(table.getDmbName("qjlbdmb", info.getQjlb()));
			info.setQjrq(DateTools.getFormatDate(info.getQjrq(), "yyyyMMddHHmmss", "yyyy-MM-dd"));
			info.setQjsjq(DateTools.getFormatDate(info.getQjsjq(), "yyyyMMddHHmmss", "yyyy-MM-dd"));
			info.setQjsjz(DateTools.getFormatDate(info.getQjsjz(), "yyyyMMddHHmmss", "yyyy-MM-dd"));
		}
		return vbs;
	}
	
	/**
	 * 删除请假记录
	 * @param fb
	 * @return
	 */
	public boolean delQjjl(YwryxxFB fb) {
		
		fb.setQjsjq(DateTools.getFormatDate(fb.getQjsjq(), "yyyy-MM-dd", "yyyyMMddHHmmss"));
		fb.setQjsjz(DateTools.getFormatDate(fb.getQjsjz(), "yyyy-MM-dd", "yyyyMMddHHmmss"));
		
		return dao.delQjjl(fb) >= 1; 
	}
	
	/**
	 * 可考核人员数查询
	 * @param fb
	 * @return
	 */
	public int kkhrysCx(YwryxxFB fb) {
		String xm = fb.getXm();
		if (StringTools.isNotEmpty(fb.getXm())) {
			fb.setXm("%"+xm+"%");
		}
		fb.setNowYM(DateTools.getCurYM());
		int count = dao.kkhrysCx(fb);
		fb.setXm(xm);
		return count;
	}
	
	/**
	 * 可考核人员查询
	 * @param fb
	 * @return
	 */
	public YwryPojoVB[] kkhryCx(YwryxxFB fb) {
		String xm = fb.getXm();
		if (StringTools.isNotEmpty(fb.getXm())) {
			fb.setXm("%"+xm+"%");
		}
		fb.setStartRows(fb.getPageIndex()*fb.getPageSize());
		fb.setEndRows((fb.getPageIndex()+1)*fb.getPageSize());
		fb.setNowYM(DateTools.getCurYM());
		YwryPojoVB[] vbs = dao.kkhryCx(fb);
		if (vbs != null) {
			for (YwryPojoVB info : vbs) {
				if (info != null && info.getRyxx() != null) {
					info.getRyxx().setXb("1".equals(info.getRyxx().getXb())?"男":"女");
				}
				if (info != null && info.getYwry() != null) {
					info.getYwry().setSsks(table.getDmbName("yyksb", info.getYwry().getSsks()));
					info.getYwry().setRysf(table.getDmbName("rysfdmb", info.getYwry().getRysf()));
					info.getYwry().setYsdj(table.getDmbName("ysjbdmb", info.getYwry().getYsdj()));
				}
			}
		}
		fb.setXm(xm);
		return vbs;
	}
	
	/**
	 * 人员考核保存
	 * @param
	 * @return
	 */
	@Transactional
	public boolean rykhBc(YwryjxkhbVB[] vbs) {
		
		boolean flag = false;
		if (vbs != null) {
			for (int i=0; i<vbs.length; i++) {
				if (vbs[i] != null) {
					flag = dao.rykhBc(vbs[i]) >= 1;
				}
			}
		}
		return flag;
	}
	

	/**
	 * 人员考核记录查询
	 * @param fb
	 * @return
	 */
	public YwryPojoVB[] rykhjlCx(YwryxxFB fb) {
		
		if (StringTools.isNotEmpty(fb.getKhn()) && StringTools.isNotEmpty(fb.getKhn())) {
			fb.setKhny(fb.getKhn() + fb.getKhy());
		}
		fb.setStartRows(fb.getPageIndex()*fb.getPageSize());
		fb.setEndRows((fb.getPageIndex()+1)*fb.getPageSize());
		return dao.rykhjlCx(fb);
	}
	
	/**
	 * 人员考核记录数查询
	 * @param fb
	 * @return
	 */
	public int rykhjlsCx(YwryxxFB fb) {
		
		if (StringTools.isNotEmpty(fb.getKhn()) && StringTools.isNotEmpty(fb.getKhn())) {
			fb.setKhny(fb.getKhn() + fb.getKhy());
		}
		return dao.rykhjlsCx(fb);
	}
	
	/**
	 * 是否签到或签退
	 * @param fb
	 * @return
	 */
	public boolean sfQdQt(YwryxxFB fb) {
		
		return dao.sfQdQt(fb) >= 1;
	}

	/**
	 * 否签到或签退
	 * @param fb
	 * @return
	 */
	public boolean qdQtBc(YwryxxFB fb) {
		
		return dao.qdQtBc(fb) >= 1;
	}

	/**
	 * 再次签退
	 * @param fb
	 * @return
	 */
	public boolean zcQt(YwryxxFB fb) {
		
		return dao.zcQt(fb) >= 1;
	}
	
	/**
	 * 考勤记录查询
	 * @param fb
	 * @return
	 */
	public KqjlVB[] kqjlCx(YwryxxFB fb) {
	
		fb.setStartRows(fb.getPageIndex()*fb.getPageSize());
		fb.setEndRows((fb.getPageIndex()+1)*fb.getPageSize());
		KqjlVB[] vbs = dao.kqjlCx(fb);
		
		if (vbs != null) {
			for (KqjlVB info : vbs) {
				info.setKqrq(DateTools.getFormatDate(info.getKqrq(), "yyyyMMdd", "yyyy-MM-dd"));
				info.setDksjz(DateTools.getFormatDate(info.getDksjz(), "HHmmss", "HH时mm分ss秒"));
				info.setDksjw(DateTools.getFormatDate(info.getDksjw(), "HHmmss", "HH时mm分ss秒"));
				info.setSfcd("1".equals(info.getSfcd())?"是":"否");
				info.setSfzt("1".equals(info.getSfzt())?"是":"否");
			}
		}
		return vbs;
	}
	
	/**
	 * 考勤记录数查询
	 * @param fb
	 * @return
	 */
	public int kqjlsCx(YwryxxFB fb) {
		
		return dao.kqjlsCx(fb);
	}
	
	/**
	 * 工资查询
	 * @param fb
	 * @return
	 */
	public JbgzVB rygzCx(YwryxxFB fb) {
		
		return dao.rygzCx(fb);
	}
}














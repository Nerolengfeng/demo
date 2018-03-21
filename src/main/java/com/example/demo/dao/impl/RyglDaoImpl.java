/**
 * @包路径：cn.edu.jmun.rygl.dao.impl
 * @文件名：RyglDaoImpl.java
 * @类描述：TODO( 人员管理dao.impl )
 * @创建人：冯文超
 * @创建时间：2016-4-21  下午04:35:41
 */
package com.example.demo.dao.impl;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.example.demo.dao.RyglDao;
import com.example.demo.dto.YwryxxFB;
import com.example.demo.dto.JbgzVB;
import com.example.demo.dto.KqjlVB;
import com.example.demo.dto.RyjbxxbVB;
import com.example.demo.dto.YwryPojoVB;
import com.example.demo.dto.YwryjxkhbVB;
import com.example.demo.dto.YwryqjbVB;
import com.example.demo.dto.YwryxxbVB;
import com.example.demo.dto.YwryzhxxbVB;

/**
 * @包路径：cn.edu.jmun.rygl.dao.impl
 * @类名：RyglDaoImpl
 * @描述：TODO( 人员管理dao.impl )
 * @作者：冯文超
 * @创建时间：2016-4-21  下午04:35:41
 */
@Repository
public class RyglDaoImpl  implements RyglDao {

	/**
	 * 加载Mapper
	 */

	
	/**
	 * 根据身份证获取一个人的信息
	 * @param sfzhm
	 * @return
	 */
	public YwryPojoVB getRyxxBySfzhm(String sfzhm) {
		
		return this.getRyxxBySfzhm(sfzhm);
	}

	/**
	 * 插入人员基础信息表
	 */
	public int insertRyjbxxb(RyjbxxbVB vb) {
		
		return this.insertRyjbxxb(vb);
	}

	/**
	 * 插入医务人员信息表
	 */
	public int insertYwryxxb(YwryxxbVB vb) {
		
		return this.insertYwryxxb(vb);
	}

	/**
	 * 插入医务人员账号信息表
	 * @param vb
	 * @return
	 */
	public int insertYwryzhxxb (YwryzhxxbVB vb) {
		
		return this.insertYwryzhxxb(vb);
	}
	
	/**
	 * 判断账号信息是否存在
	 */
	public boolean getzhsfcz(String zhbm) {

		return this.getzhsfcz(zhbm);
	}

	/**
	 * 人员信息数查询
	 */
	public int ryxxsCx(YwryxxFB fb) {
		
		return this.ryxxsCx(fb);
	}

	/**
	 * 人员信息查询
	 */
	public YwryPojoVB[] ryxxCx(YwryxxFB fb) {

		return this.ryxxCx(fb);
	}
	
	/**
	 * 根据个人编号获得一个人的信息
	 * @param grbh
	 * @return
	 */
	public YwryPojoVB getRyxxByGrbh (String grbh) {
		
		return this.getRyxxByGrbh(grbh);
	}


	/**
	 * 更新人员基础信息表
	 * @param vb
	 * @return
	 */
	public int updateRyjcxxb (RyjbxxbVB vb) {
		
		return this.updateRyjcxxb(vb);
	}
	
	/**
	 * 更新医务人员信息表
	 * @param vb
	 * @return
	 */
	public int updateYwryxxb (YwryxxbVB vb) {
		
		return this.updateYwryxxb(vb);
	}
	
	/**
	 * 更新医务人员账号信息表
	 * @param vb
	 * @return
	 */
	public int updateYwryzhxxb (YwryzhxxbVB vb) {
		
		return this.updateYwryzhxxb(vb);
	}
	
	/**
	 * 删除医务人员信息
	 * @param grbh
	 * @return
	 */
	public int delYwry(String grbh) {
		
		return this.delYwry(grbh);
	}

	@Override
	public SqlSession getsqlsession() {
		return this.getsqlsession();
	}

	/**
	 * 删除医务人员信息账号
	 * @param grbh
	 * @param
	 * @return
	 */
	public int delYwryzh(String grbh) {
		
		return this.delYwryzh(grbh);
	}
	
	/**
	 * 插入请假表
	 * @param vb
	 * @return
	 */
	public int insertYwryqjb (YwryqjbVB vb) {
		
		return this.insertYwryqjb(vb);
	}
	
	/**
	 * 判断是否已经请假
	 * @param vb
	 * @return
	 */
	public int sfyyqj(YwryqjbVB vb) {
		
		return this.sfyyqj(vb);
	}
	
	/**
	 * 人员请假信息查询 
	 * @param fb
	 * @return
	 */
	public YwryPojoVB[] qjryxxCx(YwryxxFB fb) {
		
		return this.qjryxxCx(fb);
	}
	
	/**
	 * 请假信息数查询
	 * @param fb
	 * @return
	 */
	public int qjryxxsCx(YwryxxFB fb) {
		
		return this.qjryxxsCx(fb);
	}
	
	/**
	 * 请假记录详情
	 * @param grbh
	 * @return
	 */
	public YwryqjbVB[] qjjlxx(String grbh) {
		
		return this.qjjlxx(grbh);
	}
	
	/**
	 * 删除请假记录
	 * @param fb
	 * @return
	 */
	public int delQjjl(YwryxxFB fb) {
		
		return this.delQjjl(fb);
	}
	
	/**
	 * 可考核人员数查询
	 * @param fb
	 * @return
	 */
	public int kkhrysCx(YwryxxFB fb) {
		
		return this.kkhrysCx(fb);
	}
	
	/**
	 * 可考核人员查询
	 * @param fb
	 * @return
	 */
	public YwryPojoVB[] kkhryCx(YwryxxFB fb) {
		
		return this.kkhryCx(fb);
	}
	
	/**
	 * 人员考核保存
	 * @param vb
	 * @return
	 */
	public int rykhBc(YwryjxkhbVB vb) {
		
		return this.rykhBc(vb);
	}
	

	/**
	 * 人员考核记录查询
	 * @param fb
	 * @return
	 */
	public YwryPojoVB[] rykhjlCx(YwryxxFB fb) {
		
		return this.rykhjlCx(fb);
	}
	
	/**
	 * 人员考核记录数查询
	 * @param fb
	 * @return
	 */
	public int rykhjlsCx(YwryxxFB fb) {
		
		return this.rykhjlsCx(fb);
	}
	
	/**
	 * 是否签到或签退
	 * @param fb
	 * @return
	 */
	public int sfQdQt(YwryxxFB fb) {
		
		return this.sfQdQt(fb);
	}

	/**
	 * 否签到或签退
	 * @param fb
	 * @return
	 */
	public int qdQtBc(YwryxxFB fb) {
		
		return this.qdQtBc(fb);
	}

	/**
	 * 再次签退
	 * @param fb
	 * @return
	 */
	public int zcQt(YwryxxFB fb) {
		
		return this.zcQt(fb);
	}
	
	/**
	 * 考勤记录查询
	 * @param fb
	 * @return
	 */
	public KqjlVB[] kqjlCx(YwryxxFB fb) {
	
		return this.kqjlCx(fb);
	}
	
	/**
	 * 考勤记录数查询
	 * @param fb
	 * @return
	 */
	public int kqjlsCx(YwryxxFB fb) {
		
		return this.kqjlsCx(fb);
	}
	
	/**
	 * 工资查询
	 * @param fb
	 * @return
	 */
	public JbgzVB rygzCx(YwryxxFB fb) {
		
		return this.rygzCx(fb);
	}
}

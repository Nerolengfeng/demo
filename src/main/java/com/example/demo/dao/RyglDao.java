/**
 * @包路径：cn.edu.jmun.mzgl.dao
 * @文件名：RyglDao.java
 * @类描述：TODO( 人员管理dao )
 * @创建人：冯文超
 * @创建时间：2016-4-21  下午03:33:41
 */
package com.example.demo.dao;

import com.example.demo.dto.YwryxxFB;
import com.example.demo.dto.JbgzVB;
import com.example.demo.dto.KqjlVB;
import com.example.demo.dto.RyjbxxbVB;
import com.example.demo.dto.YwryPojoVB;
import com.example.demo.dto.YwryjxkhbVB;
import com.example.demo.dto.YwryqjbVB;
import com.example.demo.dto.YwryxxbVB;
import com.example.demo.dto.YwryzhxxbVB;
import org.apache.ibatis.session.SqlSession;

/**
 * @包路径：cn.edu.jmun.mzgl.dao
 * @类名：RyglDao
 * @描述：TODO( 人员管理dao )
 * @作者：冯文超
 * @创建时间：2016-4-21  下午03:33:41
 */
public interface RyglDao {
	
	/**
	 * 根据身份证获取一个人的信息
	 * @param sfzhm
	 * @return
	 */
	public YwryPojoVB getRyxxBySfzhm(String sfzhm);
	
	/**
	 * 插入人员基础信息表
	 * @param vb
	 * @return
	 */
	public int insertRyjbxxb(RyjbxxbVB vb);
	
	/**
	 * 插入医务人员信息表
	 * @param vb
	 * @return
	 */
	public int insertYwryxxb(YwryxxbVB vb);
	
	/**
	 * 插入医务人员账号信息表
	 * @param vb
	 * @return
	 */
	public int insertYwryzhxxb(YwryzhxxbVB vb);
	
	/**
	 * 判断账号信息是否存在
	 * @param zhbm
	 * @return
	 */
	public boolean getzhsfcz(String zhbm);
	
	/**
	 * 人员信息数查询
	 * @param fb
	 * @return
	 */
	public int ryxxsCx(YwryxxFB fb);
	
	/**
	 * 人员信息查询
	 * @param fb
	 * @return
	 */
	public YwryPojoVB[] ryxxCx(YwryxxFB fb);
	
	/**
	 * 根据个人编号获得一个人的信息
	 * @param grbh
	 * @return
	 */
	public YwryPojoVB getRyxxByGrbh(String grbh);
	
	/**
	 * 更新人员基础信息表
	 * @param vb
	 * @return
	 */
	public int updateRyjcxxb(RyjbxxbVB vb);
	
	/**
	 * 更新医务人员信息表
	 * @param vb
	 * @return
	 */
	public int updateYwryxxb(YwryxxbVB vb);
	
	/**
	 * 更新医务人员账号信息表
	 * @param vb
	 * @return
	 */
	public int updateYwryzhxxb(YwryzhxxbVB vb);
	public SqlSession getsqlsession();
	/**
	 * 删除医务人员信息
	 * @param grbh
	 * @return
	 */
	public int delYwry(String grbh);
	
	/**
	 * 删除医务人员信息账号
	 * @param grbh
	 * @param
	 * @return
	 */
	public int delYwryzh(String grbh);
	
	/**
	 * 插入请假表
	 * @param vb
	 * @return
	 */
	public int insertYwryqjb(YwryqjbVB vb);
	
	/**
	 * 判断是否已经请假
	 * @param vb
	 * @return
	 */
	public int sfyyqj(YwryqjbVB vb);
	
	/**
	 * 人员请假信息查询 
	 * @param fb
	 * @return
	 */
	public YwryPojoVB[] qjryxxCx(YwryxxFB fb);
	
	/**
	 * 请假信息数查询
	 * @param fb
	 * @return
	 */
	public int qjryxxsCx(YwryxxFB fb);
	
	/**
	 * 请假记录详情
	 * @param grbh
	 * @return
	 */
	public YwryqjbVB[] qjjlxx(String grbh);

	/**
	 * 删除请假记录
	 * @param fb
	 * @return
	 */
	public int delQjjl(YwryxxFB fb);
	
	/**
	 * 可考核人员数查询
	 * @param fb
	 * @return
	 */
	public int kkhrysCx(YwryxxFB fb);
	
	/**
	 * 可考核人员查询
	 * @param fb
	 * @return
	 */
	public YwryPojoVB[] kkhryCx(YwryxxFB fb);
	
	/**
	 * 人员考核保存
	 * @param vb
	 * @return
	 */
	public int rykhBc(YwryjxkhbVB vb);
	

	/**
	 * 人员考核记录查询
	 * @param fb
	 * @return
	 */
	public YwryPojoVB[] rykhjlCx(YwryxxFB fb);
	
	/**
	 * 人员考核记录数查询
	 * @param fb
	 * @return
	 */
	public int rykhjlsCx(YwryxxFB fb);
	
	/**
	 * 是否签到或签退
	 * @param fb
	 * @return
	 */
	public int sfQdQt(YwryxxFB fb);

	/**
	 * 否签到或签退
	 * @param fb
	 * @return
	 */
	public int qdQtBc(YwryxxFB fb);

	/**
	 * 再次签退
	 * @param fb
	 * @return
	 */
	public int zcQt(YwryxxFB fb);
	
	/**
	 * 考勤记录查询
	 * @param fb
	 * @return
	 */
	public KqjlVB[] kqjlCx(YwryxxFB fb);
	
	/**
	 * 考勤记录数查询
	 * @param fb
	 * @return
	 */
	public int kqjlsCx(YwryxxFB fb);
	
	/**
	 * 工资查询
	 * @param fb
	 * @return
	 */
	public JbgzVB rygzCx(YwryxxFB fb);
}














/**
 * @包路径：cn.edu.jmun.mzgl.service
 * @文件名：RyglService.java
 * @类描述：TODO( 人员管理service )
 * @创建人：冯文超
 * @创建时间：2016-4-21  下午03:34:18
 */
package com.example.demo.service;

import com.example.demo.dto.YwryxxFB;
import com.example.demo.dto.JbgzVB;
import com.example.demo.dto.KqjlVB;
import com.example.demo.dto.YwryPojoVB;
import com.example.demo.dto.YwryjxkhbVB;
import com.example.demo.dto.YwryqjbVB;

/**
 * @包路径：cn.edu.jmun.mzgl.service
 * @类名：RyglService
 * @描述：TODO( 人员管理service )
 * @作者：冯文超
 * @创建时间：2016-4-21  下午03:34:18
 */
public interface RyglService {

	/**
	 * 根据身份证获取一个人的信息
	 * @param sfzhm
	 * @return
	 */
	public YwryPojoVB getRyxxBySfzhm(String sfzhm);
		
	/**
	 * 新增人员信息保存
	 * @param
	 * @return
	 */
	public boolean ryxzSave(YwryxxFB fb);
	
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
	 * 根据个人编号获得一个人的信息
	 * @param grbh
	 * @return
	 */
	public YwryPojoVB getRyxxByGrbh1(String grbh);
	
	/**
	 * 更新人员信息表
	 * @param
	 * @return
	 */
	public boolean updateRyxx(YwryxxFB fb);
	
	/**
	 * 人员注销
	 * @param fb
	 * @return
	 */
	public boolean delRyxx(YwryxxFB fb);
	
	/**
	 * 插入请假表
	 * @param
	 * @return
	 */
	public boolean insertYwryqjb(YwryxxFB fb);
	
	/**
	 * 判断是否已经请假
	 * @param fb
	 * @return
	 */
	public boolean sfyyqj(YwryxxFB fb) ;
	
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
	public boolean delQjjl(YwryxxFB fb);
	
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
	 * @param vbs
	 * @return
	 */
	public boolean rykhBc(YwryjxkhbVB[] vbs);
	

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
	public boolean sfQdQt(YwryxxFB fb);

	/**
	 * 否签到或签退
	 * @param fb
	 * @return
	 */
	public boolean qdQtBc(YwryxxFB fb);

	/**
	 * 再次签退
	 * @param fb
	 * @return
	 */
	public boolean zcQt(YwryxxFB fb);
	
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












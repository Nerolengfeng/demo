/**
 * @包路径：cn.edu.jmun.mzgl.dao
 * @文件名：MzglDao.java
 * @类描述：TODO(TODO)
 * @创建人：冯文超
 * @创建时间：2016年5月21日  下午4:38:46
 */
package com.example.demo.dao;

import com.example.demo.dto.MzglFB;
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
 * @包路径：cn.edu.jmun.mzgl.dao
 * @类名：MzglDao
 * @描述：TODO(TODO)
 * @作者：冯文超
 * @创建时间：2016年5月21日  下午4:38:46
 */
public interface MzglDao {

	/**
	 * 基础库是否存在人员
	 * @param fb
	 * @return
	 */
	public RyjbxxbVB jcksfczCx(MzglFB fb);
	
	/**
	 * 人员是否入库
	 * @param fb
	 * @return
	 */
	public BrjbxxbVB rysflhCx(MzglFB fb);
	
	/**
	 * 插入病人表
	 * @param vb
	 * @return
	 */
	public int insertBrjbxxb(BrjbxxbVB vb);
	
	/**
	 * 人员挂号
	 * @param vb
	 * @return
	 */
	public int ryghBc(MzlcztbVB vb);
	
	/**
	 * 插入人员基本信息表
	 * @param vb
	 * @return
	 */
	public int insertRyjbxxb(RyjbxxbVB vb);
	
	/**
	 * 更新人员基础信息表
	 * @param vb
	 * @return
	 */
	public int updateRyjcxxb(RyjbxxbVB vb);
	
	/**
	 * 当日挂号流程是否结束
	 * @param ghrq
	 * @param sfzhm
	 * @return
	 */
	public int drghlcsfjs(String ghrq, String sfzhm);
	
	/**
	 * 退号
	 * @param vb
	 * @return
	 */
	public int thBc(MzlcztbVB vb);
	
	/**
	 * 病人信息数查询
	 * @param fb
	 * @return
	 */
	public int brxxsCx(MzglFB fb);
	
	/**
	 * 病人信息查询
	 * @param fb
	 * @return
	 */
	public BrxxVB[] brxxCx(MzglFB fb);
	
	/**
	 * 人员基本信息查询
	 * @param fb
	 * @return
	 */
	public RyjbxxbVB ryjbxxCx(MzglFB fb);
	
	/**
	 * 药物新增
	 * @param fb
	 * @return
	 */
	public int ykxz(MzglFB fb);	
	
	/**
	 * 药物是否存在查询
	 * @return
	 */
	public int ywsfczCx(MzglFB fb);
	
	/**
	 * 药物数查询
	 * @param fb
	 * @return
	 */
	public int ywsCx(MzglFB fb);
	
	/**
	 * 药物查询
	 * @param fb
	 * @return
	 */
	public YwxxVB[] ywCx(MzglFB fb);
	
	/**
	 * 药物删除
	 * @param fb
	 * @return
	 */
	public int ywsc(MzglFB fb);
	
	/**
	 * 获得药物信息代码表
	 * @return
	 */
	public YwxxVB[] getYwxxDmb(String tablename);
	
	/**
	 * 更新流程状态表
	 * @param vb
	 * @return
	 */
	public int updateLcztb(MzlcztbVB vb);
	
	/**
	 * 插入病人拿药信息表
	 * @param vb
	 * @return
	 */
	public int insertBrnyxxb(BrnyxxbVB vb);
	
	/**
	 * 插入病人检查信息表
	 * @param vb
	 * @return
	 */
	public int insertBrjcxb(BrjcxbVB vb);
	
	/**
	 * 插入病人问诊情况表
	 * @param vb
	 * @return
	 */
	public int insertBrwzqkb(BrwzqkbVB vb);
	
	
	/**
	 * 检查记录数查询
	 * @param fb
	 * @return
	 */
	public int jcjlsCx(MzglFB fb);
	
	/**
	 * 检查记录查询
	 * @param fb
	 * @return
	 */
	public BrxxVB[] jcjlCx(MzglFB fb);
	
	/**
	 * 缴费病人查数查询
	 * @param fb
	 * @return
	 */
	public int jfbrsCx(MzglFB fb);
	
	/**
	 * 缴费病人查询
	 * @param fb
	 * @return
	 */
	public BrxxVB[] jfbrCx(MzglFB fb);
	
	/**
	 * 检查收费查询
	 * @param fb
	 * @return
	 */
	public BrjcxbVB[] jcsfCx(MzglFB fb);
	
	/**
	 * 药物收费查询
	 * @param fb
	 * @return
	 */
	public BrnyxxbVB[] ywsfCx(MzglFB fb);
	
	/**
	 * 流程状态表缴费
	 * @param fb
	 * @return
	 */
	public int lcztbJf(MzglFB fb);
	
	/**
	 * 检查表缴费
	 * @param fb
	 * @return
	 */
	public int jcbJf(MzglFB fb);
		
	/**
	 * 拿药表缴费
	 * @param fb
	 * @return
	 */
	public int nybJf(MzglFB fb);
	
	/**
	 * 疾病信息查询
	 * @param ssks
	 * @return
	 */
	public JbdmbVB[] jbxxCx(String ssks);
	
	/**
	 * 插入病人病情表
	 * @param vb
	 * @return
	 */
	public int insertBrbqb(BrbqbVB vb);
}












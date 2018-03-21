/**
 * @包路径：cn.edu.jmun.mzgl.service
 * @文件名：MzglService.java
 * @类描述：TODO(TODO)
 * @创建人：冯文超
 * @创建时间：2016年5月21日  下午4:45:18
 */
package com.example.demo.service;

import com.example.demo.util.SessionConfig;
import com.example.demo.dto.MzglFB;
import com.example.demo.dto.BrbqbVB;
import com.example.demo.dto.BrjbxxbVB;
import com.example.demo.dto.BrjcxbVB;
import com.example.demo.dto.BrnyxxbVB;
import com.example.demo.dto.BrwzqkbVB;
import com.example.demo.dto.BrxxVB;
import com.example.demo.dto.MzlcztbVB;
import com.example.demo.dto.YwxxVB;
import com.example.demo.dto.RyjbxxbVB;

/**
 * @包路径：cn.edu.jmun.mzgl.service
 * @类名：MzglService
 * @描述：TODO(TODO)
 * @作者：冯文超
 * @创建时间：2016年5月21日  下午4:45:18
 */
public interface MzglService {

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
	 * 人员挂号
	 * @param vb
	 * @return
	 */
	public boolean ryghBc(MzlcztbVB vb);
	
	/**
	 * 病人信息保存
	 * @param fb
	 * @return
	 */
	public boolean brrySave(MzglFB fb);
	
	/**
	 * 当日挂号流程是否结束
	 * @param ghrq
	 * @param sfzhm
	 * @return
	 */
	public boolean drghlcsfjs(String ghrq, String sfzhm);
	
	/**
	 * 退号
	 * @param vb
	 * @return
	 */
	public boolean thBc(MzlcztbVB vb);
	
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
	public boolean ykxz(MzglFB fb);	
	
	
	/**
	 * 药物是否存在查询
	 * @return
	 */
	public boolean ywsfczCx(MzglFB fb);
	
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
	public boolean ywsc(MzglFB fb);
	
	/**
	 * 获得药物信息代码表
	 * @return
	 */
	public String getYwxxDmb(String tablename);
	
	/**
	 * 更新流程状态表
	 * @param vb
	 * @return
	 */
	public boolean updateLcztb(MzlcztbVB vb);
	
	/**
	 * 插入病人拿药信息表
	 * @param vb
	 * @return
	 */
	public boolean insertBrnyxxb(BrnyxxbVB vb);
	
	/**
	 * 插入病人检查信息表
	 * @param vb
	 * @return
	 */
	public boolean insertBrjcxb(BrjcxbVB vb);
	
	/**
	 * 人员问诊管理
	 * @param fb
	 * @return
	 */
	public boolean rywzBc(MzglFB fb, SessionConfig sessionConf);
	
	/**
	 * 插入病人问诊情况表
	 * @param vb
	 * @return
	 */
	public boolean insertBrwzqkb(BrwzqkbVB vb);
	
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
	public boolean lcztbJf(MzglFB fb);
	
	/**
	 * 检查表缴费
	 * @param fb
	 * @return
	 */
	public boolean jcbJf(MzglFB fb);
		
	/**
	 * 拿药表缴费
	 * @param fb
	 * @return
	 */
	public boolean nybJf(MzglFB fb);
	
	/**
	 * 人员缴费
	 * @param fb
	 * @return
	 */
	public boolean ryjf(MzglFB fb);
	
	/**
	 * 疾病信息查询
	 * @param ssks
	 * @return
	 */
	public String jbxxCx(String ssks);
	
	/**
	 * 插入病人病情表
	 * @param vb
	 * @return
	 */
	public boolean insertBrbqb(BrbqbVB vb);
}











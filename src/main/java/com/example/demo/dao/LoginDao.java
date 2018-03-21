/**
 * @包路径：cn.edu.jmun.common.dao
 * @文件名：LoginDao.java
 * @类描述：TODO(TODO)
 * @创建人：冯文超
 * @创建时间：2016年5月17日  下午10:07:44
 */
package com.example.demo.dao;

import com.example.demo.util.SessionConfig;
import com.example.demo.dto.LoginFB;

/**
 * @包路径：cn.edu.jmun.common.dao
 * @类名：LoginDao
 * @描述：TODO(TODO)
 * @作者：冯文超
 * @创建时间：2016年5月17日  下午10:07:44
 */
public interface LoginDao {

	/**
	 * 用户登录
	 * @param fb
	 * @return
	 */
	public SessionConfig login(LoginFB fb);
}

/**
 * @包路径：cn.edu.jmun.common.dao.impl
 * @文件名：LoginDaoImpl.java
 * @类描述：TODO(TODO)
 * @创建人：冯文超
 * @创建时间：2016年5月17日  下午10:08:01
 */
package com.example.demo.dao.impl;

import org.springframework.stereotype.Repository;

import com.example.demo.util.SessionConfig;
import com.example.demo.dao.LoginDao;
import com.example.demo.dto.LoginFB;

/**
 * @包路径：cn.edu.jmun.common.dao.impl
 * @类名：LoginDaoImpl
 * @描述：TODO(TODO)
 * @作者：冯文超
 * @创建时间：2016年5月17日  下午10:08:01
 */
@Repository
public class LoginDaoImpl   implements LoginDao {



	/**
	 * 用户登录
	 * @param fb
	 * @return
	 */
	public SessionConfig login(LoginFB fb) {
		
		return this.login(fb);
	}
}

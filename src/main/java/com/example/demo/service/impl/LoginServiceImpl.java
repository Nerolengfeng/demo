/**
 * @包路径：cn.edu.jmun.common.service.impl
 * @文件名：LoginServiceImpl.java
 * @类描述：TODO(TODO)
 * @创建人：冯文超
 * @创建时间：2016年5月17日  下午10:10:41
 */
package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.util.SessionConfig;
import com.example.demo.dao.LoginDao;
import com.example.demo.dto.LoginFB;
import com.example.demo.service.LoginService;

/**
 * @包路径：cn.edu.jmun.common.service.impl
 * @类名：LoginServiceImpl
 * @描述：TODO(TODO)
 * @作者：冯文超
 * @创建时间：2016年5月17日  下午10:10:41
 */
@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private LoginDao dao;
	/**
	 * 用户登录
	 * @param fb
	 * @return
	 */
	public SessionConfig login(LoginFB fb) {
		
		return dao.login(fb);
	}
}

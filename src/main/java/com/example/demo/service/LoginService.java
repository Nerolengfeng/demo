/**
 * @包路径：cn.edu.jmun.common.service
 * @文件名：LoginService.java
 * @类描述：TODO(TODO)
 * @创建人：冯文超
 * @创建时间：2016年5月17日  下午10:10:06
 */
package com.example.demo.service;

import com.example.demo.util.SessionConfig;
import com.example.demo.dto.LoginFB;

/**
 * @包路径：cn.edu.jmun.common.service
 * @类名：LoginService
 * @描述：TODO(TODO)
 * @作者：冯文超
 * @创建时间：2016年5月17日  下午10:10:06
 */
public interface LoginService {

	/**
	 * 用户登录
	 * @param fb
	 * @return
	 */
	SessionConfig login(LoginFB fb);
}

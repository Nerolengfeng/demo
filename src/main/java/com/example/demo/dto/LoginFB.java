/**
 * @包路径：cn.edu.jmun.common.formbean
 * @文件名：LoginFB.java
 * @类描述：TODO(TODO)
 * @创建人：冯文超
 * @创建时间：2016年5月17日  下午9:49:23
 */
package com.example.demo.dto;

import org.apache.ibatis.type.Alias;

/**
 * @包路径：cn.edu.jmun.common.formbean
 * @类名：LoginFB
 * @描述：TODO(TODO)
 * @作者：冯文超
 * @创建时间：2016年5月17日  下午9:49:23
 */
@Alias("LoginFB")
public class LoginFB {

	private String username;
	private String password;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}	
}

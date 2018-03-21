/**
 * @包路径：cn.edu.jmun.common.exception
 * @文件名：SqlSessionException.java
 * @类描述：TODO(TODO)
 * @创建人：冯文超
 * @创建时间：2016年5月16日  下午4:52:51
 */
package com.example.demo.exception;

/**
 * @包路径：cn.edu.jmun.common.exception
 * @类名：SqlSessionException
 * @描述：TODO(TODO)
 * @作者：冯文超
 * @创建时间：2016年5月16日  下午4:52:51
 */
@SuppressWarnings("serial")
public class MySqlSessionException extends Exception {

	public MySqlSessionException() {
		super();
	}
	public MySqlSessionException(String type, String method, String msg) {
		super("    类名：" + type + "    方法名：" + method + "    消息：" + msg);
	}
}

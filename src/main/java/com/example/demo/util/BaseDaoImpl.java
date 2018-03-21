/**
 * @包路径：cn.edu.jmun.common.util
 * @文件名：BaseDaoImpl.java
 * @类描述：TODO ( 数据库连接工具类 )
 * @创建人：冯文超
 * @创建时间：2016年3月26日  下午8:47:13
 */
package com.example.demo.util;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @包路径：cn.edu.jmun.common.util
 * @类名：BaseDaoImpl
 * @描述：TODO ( 数据库连接工具类 )
 * @作者：冯文超
 * @创建时间：2016年3月26日  下午8:47:13
 */
@Component
public class BaseDaoImpl<T> {
	
	/**
	 * 数据库会话工厂
	 */
	@Autowired
	private SqlSessionFactory sqlSessionFactory;
	
	/**
	 * 数据库会话
	 */
	protected SqlSession sqlSession;
	/**
	 * Mapper代理模型(代理Class T)
	 */
	protected Class<T> mapper;
	
	/**
	 * 获得Mapper代理模型 
	 * @return
	 */
	public T getMapper() {
		sqlSession = sqlSessionFactory.openSession();
		return sqlSession.getMapper(mapper);
	}
	
	/**
	 * 获得Mapper代理模型	事务处理响应
	 * @param isAutoCommit
	 * @return
	 */
	public T getMapper(boolean isAutoCommit) {
		sqlSession = sqlSessionFactory.openSession(isAutoCommit);
		return sqlSession.getMapper(mapper);
	}
	
	public void setMapper(Class<T> mapper) {
		this.mapper = mapper;
	}
	
	public SqlSession getSqlSession() {
		return sqlSession;
	}
	
}

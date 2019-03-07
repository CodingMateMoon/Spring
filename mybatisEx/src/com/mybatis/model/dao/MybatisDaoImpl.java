package com.mybatis.model.dao;

import org.apache.ibatis.session.SqlSession;

public class MybatisDaoImpl implements MybatisDao {

	@Override
	public int insertTest(SqlSession session) {
		int result = session.insert("student.insertTest");
		return result;
	}

	
}

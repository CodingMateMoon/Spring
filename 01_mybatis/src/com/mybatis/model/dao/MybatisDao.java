package com.mybatis.model.dao;

import org.apache.ibatis.session.SqlSession;

public interface MybatisDao {

	int insertStudent(SqlSession session);
}

package com.mybatis.model.dao;

import org.apache.ibatis.session.SqlSession;

import com.mybatis.model.vo.Student;

public interface MybatisDao {

	int insertStudent(SqlSession session);
	int insertStudent(SqlSession session, String name);
	int insertStudent(SqlSession session, Student s);
}

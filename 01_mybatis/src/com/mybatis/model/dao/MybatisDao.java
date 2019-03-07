package com.mybatis.model.dao;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.mybatis.model.vo.Student;

public interface MybatisDao {

	int insertStudent(SqlSession session);
	int insertStudent(SqlSession session, String name);
	int insertStudent(SqlSession session, Student s);
	int insertStudent(SqlSession session, Map<String, Object> map);
	int selectCount(SqlSession session);
}

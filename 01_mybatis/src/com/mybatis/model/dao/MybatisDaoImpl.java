package com.mybatis.model.dao;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.mybatis.model.vo.Student;

public class MybatisDaoImpl implements MybatisDao {

	@Override
	public int insertStudent(SqlSession session) {
		int result = session.insert("student.insertStudent");
		return result;
	}

	@Override
	public int insertStudent(SqlSession session, String name) {
		
		return session.insert("student.insertName", name);
	}

	@Override
	public int insertStudent(SqlSession session, Student s) {
		return session.insert("student.insertAll", s);
	}

	@Override
	public int insertStudent(SqlSession session, Map<String, Object> map) {
		return session.insert("student.insertMap", map);
	}

	@Override
	public int selectCount(SqlSession session) {
		return session.selectOne("student.selectCount");
	}
	

}

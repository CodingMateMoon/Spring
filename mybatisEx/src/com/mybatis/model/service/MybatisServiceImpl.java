package com.mybatis.model.service;

import static common.SessionTemplate.getSession;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.mybatis.model.dao.MybatisDao;
import com.mybatis.model.dao.MybatisDaoImpl;
import com.mybatis.model.vo.Student;

public class MybatisServiceImpl implements MybatisService {

	private MybatisDao dao = new MybatisDaoImpl();
	
	@Override
	public int insertTest() {
		SqlSession session = getSession();
		int result = dao.insertTest(session);
		if (result > 0) session.commit();
		else session.rollback();
		session.close();
		return result;
	}

	@Override
	public List<Student> selectAllStudent() {
		SqlSession session = getSession();
		List<Student> list = dao.selectAllStudent(session);
		session.close();
		return list;
	}

	@Override
	public List<Student> selectAllStudentMap() {
		SqlSession session = getSession();
		List<Student> list = dao.selectAllStudentMap(session);
		session.close();
		return list;
	}

	@Override
	public List<Student> memberAll() {
		SqlSession session = getSession();
		List<Student> list = dao.memberAll(session);
		session.close();
		return list;
	}

	@Override
	public List<Map> memberAllMap() {
		SqlSession session = getSession();
		List<Map> list = dao.memberAllMap(session);
		session.close();
		return list;
	}

	@Override
	public List<Map> memberSearch(String keyword) {
		SqlSession session = getSession();
		List<Map> list = dao.memberSearch(session, keyword);
		session.close();
		return list;
	}
	
	
	
	
	
	
	

}

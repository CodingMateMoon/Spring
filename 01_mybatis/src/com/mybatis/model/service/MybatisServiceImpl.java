package com.mybatis.model.service;

import static common.SessionTemplate.getSession;

import org.apache.ibatis.session.SqlSession;

import com.mybatis.model.dao.MybatisDao;
import com.mybatis.model.dao.MybatisDaoImpl;
public class MybatisServiceImpl implements MybatisService {

	private MybatisDao dao = new MybatisDaoImpl();
	
	@Override
	public int insertStudent() {
		
		SqlSession session = getSession();
		int result = dao.insertStudent(session);
		if (result > 0) session.commit();
		else session.rollback();
		session.close();
		return 0;
	}

	@Override
	public int insertStudent(String name) {
		SqlSession session = getSession();
		int result = dao.insertStudent(session, name);
		// TODO Auto-generated method stub
		return 0;
	}

	

}

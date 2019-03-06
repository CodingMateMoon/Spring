package com.mybatis.model.service;

import static common.SessionTemplate.getSession;

import org.apache.ibatis.session.SqlSession;
public class MybatisServiceImpl implements MybatisService {

	private MybatisDao dao = new MybatisDaoImpl();
	
	@Override
	public int insertStudent() {
		
		SqlSession session = getSession();
		int result = dao.insertStudent(session);
		return 0;
	}

}

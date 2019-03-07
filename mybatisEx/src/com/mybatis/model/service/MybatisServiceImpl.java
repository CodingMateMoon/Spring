package com.mybatis.model.service;

import static common.SessionTemplate.getSession;

import org.apache.ibatis.session.SqlSession;

import com.mybatis.model.dao.MybatisDao;
import com.mybatis.model.dao.MybatisDaoImpl;

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

}

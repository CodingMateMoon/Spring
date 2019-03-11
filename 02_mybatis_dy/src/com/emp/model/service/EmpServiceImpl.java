package com.emp.model.service;

import static common.SqlSessionTemplate.getSession;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.emp.model.dao.EmpDao;
import com.emp.model.dao.EmpDaoImpl;

public class EmpServiceImpl implements EmpService {

	private EmpDao dao = new EmpDaoImpl();
	
	@Override
	public List<Map> selectAll() {
		SqlSession session = getSession();
		List<Map> list = dao.selectAll(session);
		session.close();
		return list;
	}

	@Override
	public List<Map> selectSearch(Map<String, String> map) {
		SqlSession session = getSession();
		List<Map> list = dao.selectSearch(session, map);
		session.close();
		return list;
	}

	
}

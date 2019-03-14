package com.kh.spring.service;

import java.util.List;

import com.kh.spring.model.vo.Dev;

public interface DomoService {

	void print();
	
	int insert(Dev dev);
	Dev select(int num);
	List<Dev> selectList();
}

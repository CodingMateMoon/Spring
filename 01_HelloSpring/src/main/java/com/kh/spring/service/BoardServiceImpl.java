package com.kh.spring.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.spring.dao.BoardDao;
import com.kh.spring.model.vo.Attachment;
import com.kh.spring.model.vo.Board;

@Service
public class BoardServiceImpl implements BoardService {
	private Logger logger = LoggerFactory.getLogger(BoardServiceImpl.class);
	
	@Autowired
	private BoardDao dao;
	
	@Override
	public int selectCount() {
		// TODO Auto-generated method stub
		return dao.selectCount();
	}

	@Override
	public List<Board> selectList(int cPage, int numPerPage) {
		// TODO Auto-generated method stub
		return dao.selectList(cPage, numPerPage);
	}


	@Override
	public List<Board> selectBoardList() {
		return dao.selectBoardList();
	}

	@Override
	public int insertBoard(Board b, List<Attachment> attachmentList) {
		int result = 0;
//		try {
			logger.warn("입력되기전값 : " + b.getBoardNo());
			result = dao.insertBoard(b);
			if (result == 0) {
//				throw new BoardException();
			}
			logger.warn("새로입력된값 : " + b.getBoardNo());
			
			if (attachmentList.size() >0) {
				for (Attachment a : attachmentList) {
					a.setBoardNo(b.getBoardNo());
					result = dao.insertAttachment(a);
//					if (result == 0) throw new BoardException();
				}
			}
		/*} catch(Exception e) {
			
		}*/
		
		return 0;
	}

	
}

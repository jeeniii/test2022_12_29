package service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.BoardVO;
import domain.PagingVO;
import repository.BoardDAO;
import repository.BoardDAOImpl;

public class BoardServiceImpl implements BoardService {
	private static final Logger log=LoggerFactory.getLogger(BoardServiceImpl.class);
	private BoardDAO bdao;
	
	public BoardServiceImpl () {
		bdao=new BoardDAOImpl();
	}

	@Override
	public int register(BoardVO bvo) {
		log.info("insert2");
		return bdao.insert(bvo);
	}

	@Override
	public int getPageCnt() {
		return bdao.selectCount();
	}

	@Override
	public List<BoardVO> getListPage(PagingVO pgvo) {
		return bdao.selectList(pgvo);
	}

	@Override
	public BoardVO getDetail(int bno) {
		log.info("detail 2");
		//read_count update 요청 후 디테일 값 요청
		int isOk=bdao.updateCount(bno);
		return isOk>0?bdao.selectOne(bno):null;
	}

	@Override
	public int modify(BoardVO bvo) {
		log.info("modigy 2");
		return bdao.modify(bvo);
	}

}

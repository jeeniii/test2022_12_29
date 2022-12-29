package service;

import java.util.List;

import domain.BoardVO;
import domain.PagingVO;

public interface BoardService {

	int register(BoardVO bvo);

	int getPageCnt();

	List<BoardVO> getListPage(PagingVO pgvo);

	BoardVO getDetail(int bno);

	int modify(BoardVO bvo);


}

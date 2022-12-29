package repository;

import java.util.List;

import domain.BoardVO;
import domain.PagingVO;

public interface BoardDAO {

	int insert(BoardVO bvo);

	int selectCount();

	List<BoardVO> selectList(PagingVO pgvo);

	int updateCount(int bno);

	BoardVO selectOne(int bno);

	int modify(BoardVO bvo);

}

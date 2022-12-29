package repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.BoardVO;
import domain.PagingVO;
import orm.DataBaseBuilder;

public class BoardDAOImpl implements BoardDAO {
	private static final Logger log=LoggerFactory.getLogger(BoardDAOImpl.class);
	private SqlSession sql;
	private final String NS="BoardMapper.";
	
	public BoardDAOImpl() {
		new DataBaseBuilder();
		sql=DataBaseBuilder.getFactory().openSession();
	}

	@Override
	public int insert(BoardVO bvo) {
		int isOk=sql.insert(NS+"insert",bvo);
		if(isOk>0) {
			sql.commit();
		}
		return isOk;
	}

	@Override
	public int selectCount() {
		return sql.selectOne(NS+"count");
	}

	@Override
	public List<BoardVO> selectList(PagingVO pgvo) {
		return sql.selectList(NS+"pagingList",pgvo);
	}

	@Override
	public int updateCount(int bno) {
		int isOk=sql.update(NS+"read_count",bno);
		if(isOk>0) {
			sql.commit();
		}
		return isOk;
	}

	@Override
	public BoardVO selectOne(int bno) {
		log.info("detail 3");
		return sql.selectOne(NS+"detail",bno);
	}

	@Override
	public int modify(BoardVO bvo) {
		log.info("modify 3");
		int isOk=sql.update(NS+"modify",bvo);
		if(isOk>0) {
			sql.commit();
		}
		return isOk;
	}

}

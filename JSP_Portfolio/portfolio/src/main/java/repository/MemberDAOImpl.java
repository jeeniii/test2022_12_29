package repository;


import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.MemberVO;
import orm.DataBaseBuilder;

public class MemberDAOImpl implements MemberDAO {
	private static final Logger log=LoggerFactory.getLogger(MemberDAOImpl.class);
	private SqlSession sql;
	private final String NS="MemberMapper.";
	
	public MemberDAOImpl() {
		new DataBaseBuilder();
		sql=DataBaseBuilder.getFactory().openSession();
	}

	@Override
	public int insert(MemberVO mvo) {
		log.info("check");
		int isOk=sql.insert(NS+"add",mvo);
		if(isOk>0) {
			sql.commit();
		}
		log.info("register check3");
		return isOk;
	}

	@Override
	public MemberVO selectOne(MemberVO mvo) {
		log.info("login check3");
		return sql.selectOne(NS+"login",mvo);
	}

	@Override
	public int update(String id) {
		int isOk=sql.update(NS+"last",id);
		if(isOk>0) {
			sql.commit();
		}
		log.info("logout check3");
		return isOk;
	}

	@Override
	public List<MemberVO> seletList() {
		log.info("list check3");
		return sql.selectList(NS+"list");
	}

	@Override
	public MemberVO modify(String id) {
		log.info("modify check3");
		return sql.selectOne(NS+"modify",id);
	}

	@Override
	public int update(MemberVO mvo) {
		int isOk=sql.update(NS+"update",mvo);
		if(isOk>0) {
			sql.commit();
		}
		log.info("update check3");
		return isOk;
	}

	@Override
	public int delete(String id) {
		log.info("remove3");
		int isOk=sql.delete(NS+"delete",id);
		if(isOk>0) {
			sql.commit();
		}
		return isOk;
	}

}

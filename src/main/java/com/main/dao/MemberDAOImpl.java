package com.main.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.main.dto.MemberVO;

@Repository
public class MemberDAOImpl implements MemberDAO {

	@Inject
    private SqlSession sqlSession;

    private static final String Namespace = "com.main.mapper.memberMapper";

	@Override
	public List<MemberVO> selectMember() throws Exception {
		return sqlSession.selectList(Namespace+".selectMember");
	}

}

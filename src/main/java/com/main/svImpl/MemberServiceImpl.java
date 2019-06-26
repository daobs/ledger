package com.main.svImpl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.main.dao.MemberDAO;
import com.main.dto.MemberVO;
import com.main.svInf.MemberService;

@Service
public class MemberServiceImpl implements MemberService {

    @Inject
    private MemberDAO dao;

	@Override public List<MemberVO> selectMember() throws Exception { 
		return	dao.selectMember(); 
	}
	

}

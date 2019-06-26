package com.main.dao;

import java.util.List;

import com.main.dto.MemberVO;

public interface MemberDAO {
	
    public List<MemberVO> selectMember() throws Exception;
}

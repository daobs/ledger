package com.main.svInf;

import java.util.List;

import com.main.dto.MemberVO;

public interface MemberService {
    public List<MemberVO> selectMember() throws Exception;
}

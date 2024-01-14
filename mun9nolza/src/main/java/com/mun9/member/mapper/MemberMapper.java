package com.mun9.member.mapper;

import java.util.List;

import com.mun9.member.vo.MemberVO;

public interface MemberMapper {
	
	public int insertMember(MemberVO vo);
	public List<MemberVO> selectList();
}

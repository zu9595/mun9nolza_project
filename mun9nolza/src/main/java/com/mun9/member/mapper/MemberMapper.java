package com.mun9.member.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.mun9.member.vo.MemberVO;

public interface MemberMapper {
	
	public MemberVO selectMember(@Param("userId") String userId, @Param("userPw") String userPw);
	public int insertMember(MemberVO vo);
	public List<MemberVO> selectList();
}

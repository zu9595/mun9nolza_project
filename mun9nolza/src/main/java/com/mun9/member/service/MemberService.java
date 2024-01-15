package com.mun9.member.service;

import java.util.List;

import com.mun9.member.vo.MemberVO;

public interface MemberService {
	public MemberVO login(String userId, String userPw);
	public List<MemberVO> memberList();
	public boolean addMember(MemberVO vo);
	public boolean delMember(String userId, String userPw);

}

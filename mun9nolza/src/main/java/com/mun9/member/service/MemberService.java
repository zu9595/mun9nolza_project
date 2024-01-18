package com.mun9.member.service;

import java.util.List;

import com.mun9.member.vo.MemberVO;

public interface MemberService {
	public MemberVO login(String userId, String userPw);
	public List<MemberVO> memberList();
	public boolean addMember(MemberVO vo);
	public boolean delMember(String userId, String userPw);
	//아이디 찾기
	public String findId(String userName, String email);
	public String findPw(String userId, String userName, String email);
	public MemberVO kakaologin(String email, String userName);

	//회원정보 수정
	public MemberVO memInfo(String userId); //아이디조회
	public boolean memInfoMod(MemberVO vo); //수정기능
	
}

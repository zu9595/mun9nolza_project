package com.mun9.member.serviceImpl;

import org.apache.ibatis.session.SqlSession;

import com.mun9.common.DataSource;
import com.mun9.member.mapper.MemberMapper;
import com.mun9.member.service.MemberService;
import com.mun9.member.vo.MemberVO;

public class MemberServiceImpl implements MemberService {
	
	SqlSession session = DataSource.getInstance().openSession(true);
	MemberMapper mapper = session.getMapper(MemberMapper.class);
	
	@Override
	public boolean addMember(MemberVO vo) {
		return mapper.insertMember(vo) == 1;
	}
	
}

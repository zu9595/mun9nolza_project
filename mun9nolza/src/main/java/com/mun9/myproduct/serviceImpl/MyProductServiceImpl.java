package com.mun9.myproduct.serviceImpl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.mun9.common.DataSource;
import com.mun9.member.mapper.MemberMapper;
import com.mun9.myproduct.service.MyProductService;
import com.mun9.myproduct.vo.MyProductVO;

public class MyProductServiceImpl implements MyProductService{

	SqlSession session = DataSource.getInstance().openSession(true);
	MemberMapper mapper = session.getMapper(MemberMapper.class);
	
	@Override
	public List<MyProductVO> myProductList() {
		return null;
	}
	
	

}

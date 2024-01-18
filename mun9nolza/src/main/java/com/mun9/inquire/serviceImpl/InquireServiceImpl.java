package com.mun9.inquire.serviceImpl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.mun9.common.DataSource;
import com.mun9.inquire.mapper.InquireMapper;
import com.mun9.inquire.service.InquireService;
import com.mun9.inquire.vo.InquireVO;

public class InquireServiceImpl implements InquireService{

	SqlSession session = DataSource.getInstance().openSession(true);
	InquireMapper mapper = session.getMapper(InquireMapper.class);
	
	@Override
	public List<InquireVO> inquireList() {
		return mapper.selectList();
	}

}

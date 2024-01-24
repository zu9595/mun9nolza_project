package com.mun9.inquire.serviceImpl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.mun9.common.DataSource;
import com.mun9.inquire.mapper.InquireMapper;
import com.mun9.inquire.service.InquireService;
import com.mun9.inquire.vo.InquireVO;
import com.mun9.product.vo.ProductVO;

public class InquireServiceImpl implements InquireService {

	SqlSession session = DataSource.getInstance().openSession(true);
	InquireMapper mapper = session.getMapper(InquireMapper.class);

	@Override
	public List<InquireVO> inquireList() {
		return mapper.selectList();
	}

	@Override
	public List<ProductVO> prodCodeList(String category) {
		return mapper.selectCodeList(category);
	}

	@Override
	public boolean addInquire(InquireVO vo) {
		return mapper.insertInquire(vo) == 1;
	}

	@Override
	public boolean delInquire(int inqNo) {
		return mapper.deleteInquire(inqNo) == 1;
	}

	@Override
	public InquireVO detailInquire(int inqNo) {
		return mapper.selectInquire(inqNo);
	}

	@Override
	public List<InquireVO> getMyInquire(String userID) {
		return mapper.selectMyInquire(userID);
	}
    
	@Override
	public boolean modifyInquire(InquireVO vo) {
		return mapper.updateInquire(vo) == 1;
	}

	@Override
	public List<InquireVO> inquireListPaging(InquireVO vo) {
		return mapper.inquireListPaging(vo);
	}

	@Override
	public int getTotalCnt() {
		return mapper.selectCount();

	}

}

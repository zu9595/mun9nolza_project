package com.mun9.inquire.mapper;

import java.util.List;

import com.mun9.inquire.vo.InquireVO;
import com.mun9.product.vo.ProductVO;

public interface InquireMapper {

	public List<InquireVO> selectList();

	public List<ProductVO> selectCodeList(String category);

	public int insertInquire(InquireVO vo);

	public int deleteInquire(int inqNo);

	public InquireVO selectInquire(int inqNo);

}

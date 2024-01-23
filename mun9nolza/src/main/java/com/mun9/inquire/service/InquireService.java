package com.mun9.inquire.service;

import java.util.List;

import com.mun9.inquire.vo.InquireVO;
import com.mun9.product.vo.ProductVO;

public interface InquireService {
	
	public List<InquireVO> inquireList();

	public List<ProductVO> prodCodeList(String category);

	public boolean addInquire(InquireVO vo);

	public boolean delInquire(int inqNo);

	public InquireVO detailInquire(int inqNo);

//	public List<InquireVO> getMyInquire(String userID);

	public boolean modifyInquire(InquireVO vo);

	public List<InquireVO> inquireListPaging(InquireVO vo);

	public int getTotalCnt();


}

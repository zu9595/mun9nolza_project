package com.mun9.myproduct.mapper;

import java.util.List;

import com.mun9.myproduct.vo.MyProductVO;

public interface MyProductMapper {
	public List<MyProductVO> myProductList(String id);
}

package com.mun9.product.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.mun9.product.vo.ProductVO;

public interface ProductService {
	//충돌일어남
	public ProductVO getProduct(int pcode);
	
	public List<ProductVO> productListPaging(ProductVO vo);
	int getTotalCnt(String category);
	public ProductVO getProductDetail(int pcode);
}

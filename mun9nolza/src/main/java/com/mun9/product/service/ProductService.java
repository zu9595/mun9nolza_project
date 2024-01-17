package com.mun9.product.service;

import java.util.List;

import com.mun9.product.vo.ProductVO;

public interface ProductService {
	public ProductVO getProduct(int pcode);
	public List<ProductVO> productListPaging(ProductVO vo);
	int getTotalCnt(String category);
}

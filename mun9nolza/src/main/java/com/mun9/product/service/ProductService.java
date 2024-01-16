package com.mun9.product.service;

import java.util.List;

import com.mun9.product.vo.ProductVO;

public interface ProductService {

	public List<ProductVO> productListPaging(int page, String category, int proDiscount);
	int getTotalCnt(String category);
	public ProductVO getProductDetail(int pcode);
}

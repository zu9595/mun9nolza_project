package com.mun9.product.service;

import java.util.List;

import com.mun9.product.vo.ProductVO;

public interface ProductService {
	public ProductVO getProductDetail(int pcode);
	public List<ProductVO> productList();
	public List<ProductVO> productListPaging(int page);
	int getTotalCnt();
}

package com.mun9.product.service;

import java.util.List;

import com.mun9.product.vo.ProductVO;

public interface ProductService {
	//충돌일어남
	public ProductVO getProduct(int pcode);
	public List<ProductVO> productListPaging(ProductVO vo);

	public List<ProductVO> productList();
	
	public List<ProductVO> mainBestProductList(); // 메인 베스트 목록
	public List<ProductVO> saleList(); // 할인 가격순 목록

	int getTotalCnt(String category);
	public ProductVO getProductDetail(int pcode);
	public boolean delProduct(int proCode);
	public boolean modProduct(ProductVO vo);
	
}

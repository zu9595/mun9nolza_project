package com.mun9.product.service;

import java.util.List;

import com.mun9.product.vo.ProductVO;

public interface ProductService {
	//충돌일어남
	public ProductVO getProduct(int pcode);
	public List<ProductVO> productList();
	
	public List<ProductVO> mainBestProductList(); //메인 베스트 목록
	public List<ProductVO> productListPaging(int page, String category);
	int getTotalCnt(String category);
	public ProductVO getProductDetail(int pcode);
	public boolean delProduct(int proCode);
	public boolean modProduct(ProductVO vo);
	
}

package com.mun9.product.service;

import java.util.List;

import com.mun9.product.vo.ProductVO;

public interface ProductService {
	
	List<ProductVO> saleProductList();
	List<ProductVO> bestProductList();

}

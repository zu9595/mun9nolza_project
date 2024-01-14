package com.mun9.product.mapper;

import java.util.List;

import com.mun9.product.vo.ProductVO;

public interface ProductMapper {

	List<ProductVO> selectSaleProduct();
	List<ProductVO> selectBestProduct();
}

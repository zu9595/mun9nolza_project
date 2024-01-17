package com.mun9.product.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.mun9.product.vo.ProductVO;

public interface ProductMapper {
	//충돌일어남
	public ProductVO getProduct(int pcode);
	public List<ProductVO> selectProductList();

	
	public ProductVO getProductDetail(int pcode);
	public List<ProductVO> productListPaging(@Param("page") int page, @Param("category") String category);
	int selectCount(@Param("category") String category);
}

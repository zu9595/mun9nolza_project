package com.mun9.product.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.mun9.product.vo.ProductVO;

public interface ProductMapper {
	//충돌일어남
	public ProductVO getProduct(int pcode);

	public ProductVO getProductDetail(int pcode);
	public List<ProductVO> productListPaging(ProductVO vo);
	int selectCount(@Param("category") String category);
}

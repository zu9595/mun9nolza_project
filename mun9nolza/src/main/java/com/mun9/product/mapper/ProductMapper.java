package com.mun9.product.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.mun9.product.vo.ProductVO;

public interface ProductMapper {
	public ProductVO getProduct(int pcode);
	public List<ProductVO> productListPaging(ProductVO vo);
	int selectCount(@Param("category") String category);
}

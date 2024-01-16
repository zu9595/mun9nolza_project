package com.mun9.product.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.mun9.cart.vo.CartVO;
import com.mun9.product.vo.ProductVO;

public interface ProductMapper {
	public ProductVO getProductDetail(int pcode);
	public List<ProductVO> selectProductList();
	public List<ProductVO> productListPaging(@Param("page") int page);
	int selectCount();
}

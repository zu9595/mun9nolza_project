package com.mun9.product.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.mun9.product.vo.ProductVO;

public interface ProductMapper {
	//충돌일어남
	public ProductVO getProduct(int pcode);

	public List<ProductVO> productListPaging(ProductVO vo);

	public List<ProductVO> selectProductList();
	public List<ProductVO> mainBestProductList(); //메인 베스트 목록
	public ProductVO getProductDetail(int pcode);


	int selectCount(@Param("category") String category);
	
	public int deleteProduct(int proCode);
	public int modifyProduct(ProductVO vo);
}

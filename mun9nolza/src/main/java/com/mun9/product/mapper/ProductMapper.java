package com.mun9.product.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.mun9.product.vo.ProductVO;

public interface ProductMapper {
	public ProductVO getProduct(int pcode);
	public ProductVO getProductName(String pname);

	public List<ProductVO> productListPaging(ProductVO vo);

	public List<ProductVO> selectProductList();
	public List<ProductVO> mainBestProductList(); // 메인 베스트 목록
	public List<ProductVO> saleList(); // 할인 가격순 목록
	public List<ProductVO> mainCategoryHotList(); // 카테고리별 최고 인기상품 목록
	
	public ProductVO getProductDetail(int pcode); //상품 상세


	int selectCount(@Param("category") String category);
	
	public int deleteProduct(int proCode);
	public int modifyProduct(ProductVO vo);
	public int insertProduct(ProductVO vo);
	public List<String> searchProduct(String search);
}

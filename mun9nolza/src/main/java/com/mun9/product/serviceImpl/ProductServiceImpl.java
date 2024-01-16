package com.mun9.product.serviceImpl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.mun9.cart.vo.CartVO;
import com.mun9.common.DataSource;
import com.mun9.product.mapper.ProductMapper;
import com.mun9.product.service.ProductService;
import com.mun9.product.vo.ProductVO;

public class ProductServiceImpl implements ProductService{
	SqlSession session = DataSource.getInstance().openSession(true);
	ProductMapper mapper = session.getMapper(ProductMapper.class);

	@Override
	public ProductVO getProductDetail(int pcode) {
		return mapper.getProductDetail(pcode);
	}

	@Override
	public List<ProductVO> productListPaging(int page, String category, int proDiscount) { // 메인 할인상품목록, 상품목록탭 목록 및 페이징
		return mapper.productListPaging(page, category, proDiscount);
	}

	@Override
	public int getTotalCnt(String category) { // 상품 전체 및 상품 분류에 따른 총 상품 개수
		return mapper.selectCount(category);
	}
	
}

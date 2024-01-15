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
	public ProductVO getProduct(int pno) {
		// TODO Auto-generated method stub
		return mapper.getProduct(pno);
	}
	
	@Override
	public List<ProductVO> productList() {
		return mapper.selectProductList();
	}

	@Override
	public List<ProductVO> productListPaging(int page) {
		return mapper.productListPaging(page);
	}

	@Override
	public int getTotalCnt() {
		return mapper.selectCount();
	}
}

package com.mun9.product.serviceImpl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.mun9.common.DataSource;
import com.mun9.product.mapper.ProductMapper;
import com.mun9.product.service.ProductService;
import com.mun9.product.vo.ProductVO;

public class ProductServiceImpl implements ProductService{

	SqlSession session = DataSource.getInstance().openSession(true);
	ProductMapper mapper = session.getMapper(ProductMapper.class);
	
	
	@Override
	public List<ProductVO> saleProductList() {
		return mapper.selectSaleProduct();
	}

	@Override
	public List<ProductVO> bestProductList() {
		return mapper.selectBestProduct();
	}

}

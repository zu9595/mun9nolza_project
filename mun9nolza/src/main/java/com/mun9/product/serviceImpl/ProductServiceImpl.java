package com.mun9.product.serviceImpl;

import org.apache.ibatis.session.SqlSession;

import com.mun9.common.DataSource;
import com.mun9.product.mapper.ProductMapper;
import com.mun9.product.service.ProductService;
import com.mun9.product.vo.ProductVO;

public class ProductServiceImpl implements ProductService{

	SqlSession session = DataSource.getInstance().openSession(true);
	ProductMapper mapper = session.getMapper(ProductMapper.class);
	
	@Override
	public ProductVO getProduct(String pno) {
		return mapper.getProduct(pno);
	}

}

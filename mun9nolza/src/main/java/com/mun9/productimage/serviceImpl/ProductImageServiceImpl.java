package com.mun9.productimage.serviceImpl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.mun9.common.DataSource;
import com.mun9.productimage.mapper.ProductImageMapper;
import com.mun9.productimage.service.ProductImageService;
import com.mun9.productimage.vo.ProductImageVO;

public class ProductImageServiceImpl implements ProductImageService{

	SqlSession session = DataSource.getInstance().openSession(true);
	ProductImageMapper mapper = session.getMapper(ProductImageMapper.class);
	
	@Override
	public List<ProductImageVO> getImg(int proCode) {
		// TODO Auto-generated method stub
		return mapper.selectImg(proCode);
	}

}

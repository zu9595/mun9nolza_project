package com.mun9.productimage.mapper;

import java.util.List;

import com.mun9.productimage.vo.ProductImageVO;

public interface ProductImageMapper {
	public List<ProductImageVO> selectImg(int proCode);
}

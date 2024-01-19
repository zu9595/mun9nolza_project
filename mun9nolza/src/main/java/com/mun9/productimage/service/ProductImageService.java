package com.mun9.productimage.service;

import java.util.List;

import com.mun9.productimage.vo.ProductImageVO;

public interface ProductImageService {

	public List<ProductImageVO> getImg(int orderNo);
}

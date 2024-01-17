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
	public List<ProductVO> productListPaging(ProductVO vo) {
		return mapper.productListPaging(vo);
	}

	@Override
	public int getTotalCnt(String category) { // 상품 전체 및 상품 분류에 따른 총 상품 개수
		return mapper.selectCount(category);
	}

	@Override
	public ProductVO getProduct(int pcode) {
		// TODO Auto-generated method stub
		return mapper.getProduct(pcode);
	}

	@Override
	public List<ProductVO> productList() {
		// TODO Auto-generated method stub
		return mapper.selectProductList();
	}

	@Override
	public boolean delProduct(int proCode) {
		// TODO Auto-generated method stub
		return mapper.deleteProduct(proCode) == 1;
	}

	@Override
	public boolean modProduct(ProductVO vo) {
		// TODO Auto-generated method stub
		return mapper.modifyProduct(vo) > 0;
	}

	@Override
	public List<ProductVO> mainBestProductList() {
		return mapper.mainBestProductList();
	}
}

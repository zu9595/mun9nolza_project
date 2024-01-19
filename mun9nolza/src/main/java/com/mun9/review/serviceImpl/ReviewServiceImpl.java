package com.mun9.review.serviceImpl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.mun9.common.DataSource;
import com.mun9.review.mapper.ReviewMapper;
import com.mun9.review.service.ReviewService;
import com.mun9.review.vo.ReviewVO;

public class ReviewServiceImpl implements ReviewService{
	
	SqlSession session = DataSource.getInstance().openSession(true);
	ReviewMapper mapper = session.getMapper(ReviewMapper.class);

	@Override
	public List<ReviewVO> getMyReview(String userId) {
		return mapper.selectMyReview(userId);
	}

}

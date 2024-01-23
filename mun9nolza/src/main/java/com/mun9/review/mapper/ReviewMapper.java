package com.mun9.review.mapper;

import java.util.List;

import com.mun9.review.vo.ReviewVO;


public interface ReviewMapper {

	List<ReviewVO> selectMyReview(String userId);
	int selectReviewCount(int proCode);
	List<ReviewVO> reviewListPaging(ReviewVO vo);
	int addReview(ReviewVO vo);
	int deleteReview(ReviewVO vo);
}

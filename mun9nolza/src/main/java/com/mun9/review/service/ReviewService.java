package com.mun9.review.service;

import java.util.List;

import com.mun9.review.vo.ReviewVO;


public interface ReviewService {

	List<ReviewVO> getMyReview(String userId);
	int getTotalReviewCnt(int proCode);
	List<ReviewVO> reviewListPaging(ReviewVO vo);
	boolean addReview(ReviewVO vo);
	boolean orderTFReview(String userId);
}

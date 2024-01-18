package com.mun9.banner.serviceImpl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.mun9.banner.mapper.BannerMapper;
import com.mun9.banner.service.BannerService;
import com.mun9.banner.vo.BannerVO;
import com.mun9.common.DataSource;

public class BannerServiceImpl implements BannerService {
	SqlSession session = DataSource.getInstance().openSession(true);
	BannerMapper mapper = session.getMapper(BannerMapper.class);
	
	@Override
	public List<BannerVO> mainBannerList() {
		return mapper.mainBannerList();
	}
}

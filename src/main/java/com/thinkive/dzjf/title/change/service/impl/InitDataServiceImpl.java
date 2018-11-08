package com.thinkive.dzjf.title.change.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thinkive.dzjf.title.change.mapper.DataMapper;
import com.thinkive.dzjf.title.change.service.InitDataService;

@Service("initDataService")
public class InitDataServiceImpl implements InitDataService {

	@Autowired
	private DataMapper datMapper;
	
	/* (non-Javadoc)
	 * @see com.thinkive.dzjf.title.change.service.InitDataService#queryDataCount()
	 */
	@Override
	public int queryDataCount() {
		return datMapper.queryDataCount();
	}

}

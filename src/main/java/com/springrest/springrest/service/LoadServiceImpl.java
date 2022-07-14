package com.springrest.springrest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springrest.springrest.dao.LoadDao;
import com.springrest.springrest.models.Load;

@Service
public class LoadServiceImpl implements LoadService {
	@Autowired
	private LoadDao loadDao;
	
	@Override
	public Load addLoad(Load load) {
		try {		
			return loadDao.save(load);
		}
		catch(Exception e){
			return null;
		}
	}

}

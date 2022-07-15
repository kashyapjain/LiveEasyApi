package com.springrest.springrest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springrest.springrest.dao.LoadDao;
import com.springrest.springrest.models.Load;

@Service
public class LoadServiceImpl implements LoadService {
	@Autowired
	private LoadDao loadDao;
	
	// Add Load
	@Override
	public Load addLoad(Load load) {
		try {		
			return this.loadDao.save(load);
		}
		catch(Exception e){
			return null;
		}
	}
	
	// Get Load ShipperId
	@Override
	public List<Load> getLoad(String shipperId) {
		try {
			List<Integer> loadIds = this.loadDao.findAllByShipperId(shipperId);
			
			return  this.loadDao.findAllById(loadIds);
		}
		catch(Exception e) {
			return null;
		}
	}
	
	// Get Load LoadId
	@Override
	public Load getLoad(int loadId) {
		try {
			Optional<Load> load = this.loadDao.findById(loadId);
			
			if(load.isPresent()) {
				return load.get();
			}
			
			return null;
		}
		catch(Exception e) {
			return null;
		}
	}
	
	// Update Load
	@Override
	public Load upadteLoad(Load load) {
		try {
			boolean loadExists = this.loadDao.existsById(load.getLoadId());
			
			if(loadExists) {
				return this.loadDao.save(load);
			}
			
			return null;
		}
		catch(Exception e) {
			return null;
		}
	}

	// Delete Load
	@Override
	public boolean deleteLoad(int loadId) {
		try {
			this.loadDao.deleteById(loadId);
			
			return true;
		}
		catch(Exception e) {
			return false;
		}
	}

}

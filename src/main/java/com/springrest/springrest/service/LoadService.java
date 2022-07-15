package com.springrest.springrest.service;

import java.util.List;

import com.springrest.springrest.models.Load;

public interface LoadService {
	public Load addLoad(Load load);
	public List<Load> getLoad(String shipperId);
	public Load getLoad(int loadId);
	public Load upadteLoad(Load load);
	public boolean deleteLoad(int loadId);
}

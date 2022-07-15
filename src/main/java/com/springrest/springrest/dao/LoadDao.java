package com.springrest.springrest.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.springrest.springrest.models.Load;

public interface LoadDao extends JpaRepository<Load, Integer>{
	@Query("select loadId from Load l where l.shipperId = ?1")
	public List<Integer> findAllByShipperId(String shipperId);
}

package com.springrest.springrest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springrest.springrest.models.Load;
import com.springrest.springrest.service.LoadService;
import com.springrest.springrest.service.LoadServiceImpl;

@RestController
public class LoadController {
	@Autowired
	private LoadService loadService;
	
	LoadController(){
		//this.loadService = new LoadServiceImpl();
	}
	
	@PostMapping("/loads")
	public ResponseEntity<Object> addLoad(@RequestBody Load load) {
		Load savedLoad = loadService.addLoad(load);
		
		if(savedLoad!=null) {
			String responseMessage = "loads details added successfully";
			return new ResponseEntity<Object>(responseMessage,HttpStatus.CREATED);
		}
		
		return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
	}
}

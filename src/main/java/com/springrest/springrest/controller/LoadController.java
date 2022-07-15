package com.springrest.springrest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springrest.springrest.models.Load;
import com.springrest.springrest.service.LoadService;

@RestController
public class LoadController {
	@Autowired
	private LoadService loadService;
	
	// Add Load
	@PostMapping("/load")
	public ResponseEntity<Object> addLoad(@RequestBody Load load) {
		Load savedLoad = this.loadService.addLoad(load);
		
		if(savedLoad!=null) {			
			String responseMessage = "loads details added successfully";
			return new ResponseEntity<Object>(responseMessage,HttpStatus.CREATED);
		}
		
		return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
	}
	
	// Get Load shipperId
	@GetMapping("/load")
	public ResponseEntity<Object> getLoad(String[] shipperId) {
		if(shipperId!=null) {
			if(shipperId.length == 1) {
				String sid = shipperId[0];
				if(isValidShipperId(sid)) {
					List<Load> loads = this.loadService.getLoad(sid);
					
					if(!loads.isEmpty())
					{
						return new ResponseEntity<Object>(loads,HttpStatus.OK);
					}
					
					return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
				}
			}
		}
		
		return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
	}
	
	// Get Load loadId
	@GetMapping("/load/{loadId}")
	public ResponseEntity<Object> getLoad(@PathVariable int loadId) {
		Load load = this.loadService.getLoad(loadId);
		
		if(load!=null)
		{
			return new ResponseEntity<Object>(load,HttpStatus.OK);
		}
		
		return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
	}
	
	// Update Load
	@PutMapping("/load/{loadId}")
	public ResponseEntity<Object> updateLoad(@RequestBody Load load,
											 @PathVariable int loadId) {
		load.setLoadId(loadId);
		
		Load savedLoad = this.loadService.upadteLoad(load);
		
		if(savedLoad!=null) {			
			String responseMessage = "load updated successfully";
			return new ResponseEntity<Object>(responseMessage,HttpStatus.CREATED);
		}
		
		return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
	}
	
	// Delete Load
	@DeleteMapping("/load/{loadId}")
	public ResponseEntity<Object> deleteLoad(@PathVariable int loadId) {
		boolean loadDeleted = this.loadService.deleteLoad(loadId);
		
		if(loadDeleted)
		{
			String responseMessage = "load deleted successfully";
			return new ResponseEntity<Object>(responseMessage,HttpStatus.OK);
		}
		
		return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
	}
	
	// Check for Valid Shipper Id
	private boolean isValidShipperId(String shipperId) {
		char[] p1 = {'s','h','i','p','p','e','r',':'};
		int iLastIndex = shipperId.length() - 1;
		int p2Range = p1.length - 1;
		
		for(int i=0;i<=iLastIndex;i++) {
			if(i<=p2Range) {
				if(shipperId.charAt(i) != p1[i]) {
					return false;
				}
			}
			
			int p2Index = iLastIndex - i;
			
			if(p2Index>p2Range) {
				
				if(!Character.isDigit(shipperId.charAt(p2Index))) {
					return false;
				}
			}			
		}
		
		return true;
	}
}

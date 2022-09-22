package com.controller;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entity.Coder;
import com.service.CoderService;

@RestController
@RequestMapping("api")
public class CoderController {
	Log logger=LogFactory.getLog(CoderController.class);
	
	@Autowired
	CoderService coderservice;
	
	@GetMapping("/getcoder/{cid}")
	public Coder getCoder(@PathVariable    int cid) throws Throwable {
		return coderservice.getCoder(cid);
	}
	
	@GetMapping("getcoders")
	public List<Coder> getCoders(){
		return coderservice.getCoders();
	}

	@PostMapping("addcoder")
	public Coder addCoder(@RequestBody    Coder c) {
		return coderservice.addCoder(c);
	}
	
	@PostMapping("addcoders")
	public List<Coder> addCoders(@RequestBody    List<Coder> c) {
		return coderservice.addCoders(c);
	}

	@PutMapping("updatecoder")
	public Coder updateCoder(@RequestBody  Coder c) throws Throwable{
		logger.info("Coder got updated successfully!");
		return coderservice.updateCoder(c);
	}
	
	@DeleteMapping("deletecoder")
	public String deleteCoder(@RequestBody   Coder c) {
		return coderservice.deleteCoder(c);
	}

	@DeleteMapping("/deletecoderbyid/{cid}")
	public String deleteById(@PathVariable    int cid){
		return coderservice.deleteById(cid);
	}
	
	
	@GetMapping("/getcoderbyname/{cname}") 
	public Coder getCoderByCname(@PathVariable String cname) { 
	  return coderservice.getCoderByCname(cname); 
	}
	  
	@GetMapping("/getcoderbytech") 
	public List<Coder> getCoderByTechSorted(){ 
	  return coderservice.getCoderByTechSorted();
	}
	 
}

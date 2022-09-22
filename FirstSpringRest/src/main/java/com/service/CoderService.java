package com.service;

import java.util.List;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.advices.ResourceNotFoundException;
import com.entity.Coder;
import com.repository.CoderRepository;

@Service
public class CoderService{

	@Autowired
	CoderRepository repository;
	
	
	public Coder getCoder(int cid) throws Throwable{
		Supplier s1=()-> new ResourceNotFoundException("Coder does not exist in the Database..");
		return repository.findById(cid).orElseThrow(s1);
	}

	public List<Coder> getCoders() {
		return repository.findAll();
	}

	public Coder addCoder(Coder c) {
		repository.save(c);
		return c;
	}
	
	public List<Coder> addCoders(List<Coder> c) {
		repository.saveAll(c);
		return c;
	}

	public Coder updateCoder(Coder c) throws Throwable{
		int id=c.getCid();
		Supplier s1=()-> new ResourceNotFoundException("Coder does not exist in the Database..");
		Coder c1=repository.findById(id).orElseThrow(s1);
		c1.setCname(c.getCname());
		c1.setCtech(c.getCtech());
		repository.save(c1);
		return c1;
	}

	public String deleteCoder(Coder c) {
		repository.delete(c);
		return "Deleted Successfully";
	}

	public String deleteById(int cid){
		try {
			repository.deleteById(cid);
			return "Id "+cid+" deleted Successfully";
		} catch (Exception e) {
			return "Id " + cid +" doesnt exist in the Database!";
		}
	}
	
	public Coder getCoderByCname(String cname) { 
	  return repository.getCoderByCname(cname); 
	}
	  
	public List<Coder> getCoderByTechSorted(){ 
	  return repository.getCoderByTechSorted();		  
	}
	 

}

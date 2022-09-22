
  package com.service;
  
  import java.util.List;
  
  import org.springframework.beans.factory.annotation.Autowired; import
  org.springframework.stereotype.Service;
  
  import com.entity.Laptop; import com.repository.LapRepositiory;
  
  @Service public class LaptopService {
  
  @Autowired LapRepositiory repo;
  
  public Laptop addLaptop(Laptop l) { repo.save(l); return l; }
  
  public List<Laptop> getLaptops(){ return repo.findAll(); }
  
  }
 
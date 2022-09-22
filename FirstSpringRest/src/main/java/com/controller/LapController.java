
  package com.controller;
  
  import java.util.List;
  
  import org.springframework.beans.factory.annotation.Autowired; import
  org.springframework.web.bind.annotation.GetMapping; import
  org.springframework.web.bind.annotation.PostMapping; import
  org.springframework.web.bind.annotation.RequestBody; import
  org.springframework.web.bind.annotation.RequestMapping; import
  org.springframework.web.bind.annotation.RestController;
  
  import com.entity.Laptop; import com.service.LaptopService;
  
  @RestController
  
  @RequestMapping(path = "/api") public class LapController {
  
  @Autowired LaptopService laptopservice;
  
  @PostMapping("addlaptop")
  public Laptop addLaptop(@RequestBody Laptop l) {
	  return laptopservice.addLaptop(l); 
  }
  
  @GetMapping("getlaptops") public List<Laptop> getLaptops(){ return
  laptopservice.getLaptops(); }
  
  }
 
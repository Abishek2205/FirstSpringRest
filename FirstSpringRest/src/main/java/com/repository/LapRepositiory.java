
  package com.repository;
  
  import org.springframework.data.jpa.repository.JpaRepository; import
  org.springframework.stereotype.Repository;
  
  import com.entity.Laptop;
  
  @Repository public interface LapRepositiory extends
  JpaRepository<Laptop,Integer>{
  
  }
 
package com.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.entity.Coder;
import com.repository.CoderRepository;

@SpringBootTest
class CoderServiceTest {
	
	@Autowired
	CoderService coderService;
	
	@MockBean
	CoderRepository repository;
	
	
	@Test
	void testGetCoders() {
		Coder c1=new Coder();
		c1.setCid(1);
		c1.setCname("Madhu");
		c1.setCtech("java");
		
		Coder c2=new Coder();
		c2.setCid(2);
		c2.setCname("Mala");
		c2.setCtech("javaFx");
		
		List<Coder> ls=new ArrayList<>();
		ls.add(c1);
		ls.add(c2);
		
		Mockito.when(repository.findAll()).thenReturn(ls);
		assertThat(coderService.getCoders()).isEqualTo(ls);
	}
	
	@Test
	void testAddCoder() {
		Coder c3=new Coder();
		c3.setCid(3);
		c3.setCname("pia");
		c3.setCtech("php");
		
		Mockito.when(repository.save(c3)).thenReturn(c3);
		assertThat(coderService.addCoder(c3)).isEqualTo(c3);
	}
	
	@Test
	void testUpdateCoder() throws Throwable {
		Coder coder=new Coder();
		coder.setCid(1);
		coder.setCname("madhu");
		coder.setCtech("java");
		
		Optional<Coder> c=Optional.of(coder);
		Mockito.when(repository.findById(1)).thenReturn(c);
		Mockito.when(repository.save(coder)).thenReturn(coder);
		
		coder.setCname("madan");
		coder.setCtech("JavaFx");
		
		assertThat(coderService.updateCoder(coder)).isEqualTo(coder);
	}
	
	@Test
	void testDeleteCoder() {
		Coder c1=new Coder();
		c1.setCid(1);
		c1.setCname("Madhu");
		c1.setCtech("java");
		
		Optional<Coder> cOptional=Optional.of(c1);
		
		Mockito.when(repository.findById(1)).thenReturn(cOptional);
		Mockito.when(repository.existsById(c1.getCid())).thenReturn(false);
		
		assertFalse(repository.existsById(c1.getCid()));
		
		
	}
}


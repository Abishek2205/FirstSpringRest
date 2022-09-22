package com.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Coder {
	@Id
	@GeneratedValue
	private int cid;
	private String cname;
	private String ctech;
	
	
	  @OneToMany(cascade = CascadeType.ALL,mappedBy = "coder")
	  List<Laptop>laptops;
	  
	  
	  public List<Laptop> getLaptops() { return laptops; }
	 

	
	  public void setLaptops(List<Laptop> laptops) { this.laptops = laptops; }
	 

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getCtech() {
		return ctech;
	}

	public void setCtech(String ctech) {
		this.ctech = ctech;
	}

	@Override
	public String toString() {
		return "Coder [cid=" + cid + ", cname=" + cname + ", ctech=" + ctech + ", laptops="+ laptops +"]";
	}
	
	
	

}

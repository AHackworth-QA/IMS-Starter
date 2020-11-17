package com.qa.ims.persistence.domain;

public class Item {

	private Long id;
	private String productName;
	private Double productValue;
	private Long stock;
	
	public Item(String productName, Double productValue, Long stock) {  
		this.productName = productName;
		this.productValue = productValue;
		this.stock = stock;
	}
	
	public Item(Long id, String productName, Double productValue, Long stock) {
		this.id = id;
		this.productName = productName;
		this.productValue = productValue;
		this.stock = stock;
		
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getProductName() {
		return productName;
	}
	
	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	public Double getProductValue() {
		return productValue;
	}
	
	public void setProductName(Double productValue) {
		this.productValue = productValue;	
	}
	
	public Long getStock() { 
		return stock;
	}
	
	public void setStock(Long stock) {
		this.stock = stock;
		
	}
	
	@Override
	public String toString() {
		return "id:" + id + " product name:" + productName + " product value:" + productValue + " stock:" + stock;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		if (productName == null) {
			if (other.productName != null)
				return false;
		} else if (!productName.equals(other.productName))
			return false;
		if (id == null) {
			if (other.id !=null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (stock == null) {
			if (other.stock != null)
				return false;
		} else if (!stock.equals(other.stock))
				return false;
			if (productValue == null) {
				if (other.productValue != null)
					return false;
		} else if (!productValue.equals(other.productValue))
				return false;
			return true;
		}
	}

		
		
		

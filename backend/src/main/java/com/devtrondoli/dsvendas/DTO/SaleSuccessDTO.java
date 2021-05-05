package com.devtrondoli.dsvendas.DTO;

import java.io.Serializable;

import com.devtrondoli.dsvendas.entities.Seller;

public class SaleSuccessDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String sellerName;
	private Long visited;
	private Long deals;
	private Double percentSuccess;
	
	public SaleSuccessDTO() {
	}

	public SaleSuccessDTO(Seller seller, Long visited, Long deals) {
		this.sellerName = seller.getName();
		this.visited = visited;
		this.deals = deals;
		this.percentSuccess = 100.0D*Double.valueOf(deals)/visited;
	}

	public String getSellerName() {
		return sellerName;
	}

	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}

	public Long getVisited() {
		return visited;
	}

	public void setVisited(Long visited) {
		this.visited = visited;
	}

	public Long getDeals() {
		return deals;
	}

	public void setDeals(Long deals) {
		this.deals = deals;
	}

	public Double getPercentSuccess() {
		return percentSuccess;
	}

	public void setPercentSuccess(Double percentSuccess) {
		this.percentSuccess = percentSuccess;
	}

	
	
}

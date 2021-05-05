package com.devtrondoli.dsvendas.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.devtrondoli.dsvendas.DTO.SalesSumDTO;
import com.devtrondoli.dsvendas.DTO.SaleSuccessDTO;
import com.devtrondoli.dsvendas.entities.Sale;

public interface SaleRepository extends JpaRepository<Sale, Long>{
	
	@Query("SELECT new com.devtrondoli.dsvendas.DTO.SalesSumDTO(obj.seller, SUM(obj.amount)) "
			+ "FROM Sale AS obj GROUP BY obj.seller")
	List<SalesSumDTO> amountGroupBySeller();
	
	@Query("SELECT new com.devtrondoli.dsvendas.DTO.SaleSuccessDTO(obj.seller, SUM(obj.visited), SUM(obj.deals)) "
			+ "FROM Sale AS obj GROUP BY obj.seller")
	List<SaleSuccessDTO> saleSuccessGroupBySeller();
}

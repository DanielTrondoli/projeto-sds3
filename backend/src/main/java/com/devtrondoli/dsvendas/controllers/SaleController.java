package com.devtrondoli.dsvendas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devtrondoli.dsvendas.DTO.SaleDTO;
import com.devtrondoli.dsvendas.DTO.SaleSuccessDTO;
import com.devtrondoli.dsvendas.DTO.SalesSumDTO;
import com.devtrondoli.dsvendas.services.SaleService;

@RestController
@RequestMapping(value="/sales")
public class SaleController {
	
	@Autowired
	private SaleService saleService;
	
	@GetMapping
	public  ResponseEntity<Page<SaleDTO>> findAll(Pageable pageable){
		Page<SaleDTO> list = saleService.findAll(pageable);
		return ResponseEntity.ok(list);
	}
	
	@GetMapping(value="/sum-by-seller")
	public ResponseEntity<List<SalesSumDTO>> amountGroupBySeller(){
		List<SalesSumDTO> list = saleService.amountGroupBySeller();
		return ResponseEntity.ok(list);		
	}
	
	@GetMapping(value="/sale-success-by-seller")
	public ResponseEntity<List<SaleSuccessDTO>> saleSuccessGroupBySeller(){
		List<SaleSuccessDTO> list = saleService.saleSuccessGroupBySeller();
		return ResponseEntity.ok(list);		
	}
}

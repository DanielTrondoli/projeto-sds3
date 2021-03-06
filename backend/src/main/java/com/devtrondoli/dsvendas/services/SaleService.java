package com.devtrondoli.dsvendas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devtrondoli.dsvendas.DTO.SaleDTO;
import com.devtrondoli.dsvendas.DTO.SaleSuccessDTO;
import com.devtrondoli.dsvendas.DTO.SalesSumDTO;
import com.devtrondoli.dsvendas.entities.Sale;
import com.devtrondoli.dsvendas.repositories.SaleRepository;
import com.devtrondoli.dsvendas.repositories.SellerRepository;

@Service
public class SaleService {
	
	@Autowired
	private SaleRepository saleRepository;
	@Autowired
	private SellerRepository sellerRepository;
	
	@Transactional(readOnly = true)
	public Page<SaleDTO> findAll(Pageable pageable){
		sellerRepository.findAll();
		Page<Sale> result = saleRepository.findAll(pageable);
		return result.map(x -> new SaleDTO(x));
	}
	
	@Transactional(readOnly = true)
	public List<SalesSumDTO> amountGroupBySeller(){
		return saleRepository.amountGroupBySeller();
		
	}
	
	@Transactional(readOnly = true)
	public List<SaleSuccessDTO> saleSuccessGroupBySeller(){
		return saleRepository.saleSuccessGroupBySeller();
		
	}
}	

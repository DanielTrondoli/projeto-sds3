package com.devtrondoli.dsvendas.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devtrondoli.dsvendas.DTO.SellerDTO;
import com.devtrondoli.dsvendas.entities.Seller;
import com.devtrondoli.dsvendas.repositories.SellerRepository;

@Service
public class SellerService {
	
	@Autowired
	private SellerRepository sellerRepository;
	
	public List<SellerDTO> findAll(){
		List<Seller> result = sellerRepository.findAll();
		return result.stream()
					 .map(x -> new SellerDTO(x))
					 .collect(Collectors.toList());
	}
}	

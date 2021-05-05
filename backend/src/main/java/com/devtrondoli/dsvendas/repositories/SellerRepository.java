package com.devtrondoli.dsvendas.repositories;

import com.devtrondoli.dsvendas.entities.Seller;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SellerRepository extends JpaRepository<Seller, Long>{
	
}

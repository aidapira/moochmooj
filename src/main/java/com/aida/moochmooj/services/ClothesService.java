package com.aida.moochmooj.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.aida.moochmooj.models.clothes;
import com.aida.moochmooj.repositories.ClothesRepository;


@Service
public class ClothesService {
	private final ClothesRepository clothesRepository;
	
	public ClothesService(ClothesRepository clothesRepository) {
		this.clothesRepository = clothesRepository;
	}
	
	// returns all the clothes
	public List<clothes> allClothes() {
		return clothesRepository.findAll();
	}
	// creates a cloth
	public clothes createClothes(clothes b) {
		return clothesRepository.save(b);
	}
	// retrieves a clothe
	public clothes findClothes(Long id) {
		Optional<clothes> optionalClothes = clothesRepository.findById(id);
		if(optionalClothes.isPresent()) {
			return optionalClothes.get();
		} else {
			return null;
		}
	}

}

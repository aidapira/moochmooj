package com.aida.moochmooj.controllers;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.aida.moochmooj.models.clothes;
import com.aida.moochmooj.services.ClothesService;

@RestController
public class ClothesApi {
	private final ClothesService clothesService;

	public ClothesApi(ClothesService clothesService) {
		this.clothesService = clothesService;
	}
	
	@RequestMapping("/api/clothes")
	public List<clothes> index() {
		return clothesService.allClothes();
	}
	
	@RequestMapping(value="/api/clothes", method=RequestMethod.POST)
	public clothes create(@PathParam(value="title") String title) {
		clothes clothes = new clothes(title);
		return clothesService.createClothes(clothes);
	}
	
	@RequestMapping("/api/clothes/{id}") 
	public clothes show(@PathVariable("id") Long id) {
		clothes clothes = clothesService.findClothes(id);
		return clothes;
	}
	
}

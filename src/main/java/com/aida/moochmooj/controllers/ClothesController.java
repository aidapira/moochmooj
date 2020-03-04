package com.aida.moochmooj.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.aida.moochmooj.models.clothes;
import com.aida.moochmooj.services.ClothesService;

@Controller
public class ClothesController {
	private final ClothesService clothesService;
	
	public ClothesController(ClothesService clothesService) {
		this.clothesService = clothesService;
	}
	@GetMapping("/clothes/hello")
	public String newClothes(@ModelAttribute("clothes") clothes clothes) {
		return "WEB-INF/clothes/clothes.jsp";
	}
	
	@RequestMapping("/clothes")
	public String index(Model model) {
		List<clothes> clothes = clothesService.allClothes();
		model.addAttribute("clothes", clothes);
		return "WEB-INF/clothes/tester.jsp";
	}
	
	
	
	@RequestMapping(value = "/clothes", method=RequestMethod.POST)
	public String create(@Valid @ModelAttribute("clothes") clothes clothes, BindingResult result) {
		if (result.hasErrors()) {
			return "WEB-INF/clothes/new.jsp";
		} else {
			clothesService.createClothes(clothes);
			return "redirect:/clothes";
		}
	}
	
}

package org.generation.italy.main.controller;

import java.util.List;

import org.generation.italy.main.pojo.Drink;
import org.generation.italy.main.pojo.Pizza;
import org.generation.italy.main.service.DrinkService;
import org.generation.italy.main.service.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/general")
public class SearchController {

	@Autowired
	private PizzaService pizzaService;
	@Autowired
	private DrinkService drinkService;
	
	
	@GetMapping("/search")
	public String mixedSearchByName(@RequestParam(name = "query", required = false) String query, Model model) {
		
		List<Pizza> pizzas = query == null ? pizzaService.findAll() : pizzaService.findByName(query);
		List<Drink> drinks = query == null ? drinkService.findAll() : drinkService.findByName(query);
		
		model.addAttribute("pizzas", pizzas);
		model.addAttribute("drinks", drinks);
		model.addAttribute("query", query);
		
		return "general-search";
	}
	
}

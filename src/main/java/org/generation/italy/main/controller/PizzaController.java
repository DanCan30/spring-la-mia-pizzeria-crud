package org.generation.italy.main.controller;

import java.util.List;

import org.generation.italy.main.pojo.Pizza;
import org.generation.italy.main.service.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class PizzaController {
	
	@Autowired
	private PizzaService pizzaService;

	@GetMapping("/")
	public String getIndex(Model model) {
		
		List<Pizza> pizzas = pizzaService.findAll();
		
		model.addAttribute("pizzas", pizzas);
		
		return "index";
	}
	
	@GetMapping("/create")
	public String addPizza(Model model) {
		
		Pizza pizza = new Pizza();
		
		model.addAttribute("pizza", pizza);
		
		return "create";
	}
	
	@PostMapping("/create")
	public String savePizza(@ModelAttribute("pizza") Pizza pizza) {
		
		pizzaService.save(pizza);
		
		return "redirect:/";
	}
	
}

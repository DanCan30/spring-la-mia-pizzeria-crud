package org.generation.italy.main.controller;

import java.util.List;
import java.util.Optional;

import org.generation.italy.main.pojo.Pizza;
import org.generation.italy.main.service.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@GetMapping("/pizza/{id}")
	public String showPizza(@PathVariable("id") int id,  Model model) {
				
		Optional<Pizza> optPizza = pizzaService.findPizzaById(id);
		
		if (optPizza.isEmpty()) {
			return "404";
		}
		
		Pizza pizza = optPizza.get();
		
		model.addAttribute("pizza", pizza);
		
		return "pizza";
		
	}
	
	@GetMapping("/pizza/create")
	public String addPizza(Model model) {
		
		Pizza pizza = new Pizza();
		
		model.addAttribute("pizza", pizza);
		
		return "create";
	}
	
	@PostMapping("/pizza/create")
	public String savePizza(@ModelAttribute("pizza") Pizza pizza) {
		
		pizzaService.save(pizza);
		
		return "redirect:/";
	}
	
	@GetMapping("/pizza/edit/{id}")
	public String editPizza(@PathVariable("id") int id, Model model) {
		
		Optional<Pizza> optPizza = pizzaService.findPizzaById(id);
		
		if (optPizza.isEmpty()) {
			return "404";
		}
		
		Pizza pizza = optPizza.get();
		
		model.addAttribute("pizza", pizza);
		
		return "edit";
	}
	
	@PostMapping("/pizza/edit/{id}")
	public String updatePizza(@ModelAttribute("pizza") Pizza pizza) {
		pizzaService.save(pizza);
		
		return "redirect:/";
	}
	
}

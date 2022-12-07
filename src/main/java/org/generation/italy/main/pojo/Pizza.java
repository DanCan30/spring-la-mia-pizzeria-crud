package org.generation.italy.main.pojo;

import org.generation.italy.main.interfaces.PriceableInt;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "pizza")
public class Pizza implements PriceableInt {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotEmpty(message = "Name field can't be empty.")
	@Size(min = 3, max = 32, message = "The name's length must be between 3 and 32 characters.")
	@Column(name = "name")
	private String name;
	
	@Lob
	@Column(name = "description")
	private String description;

	@NotNull(message = "Price field can't be empty.")
	@Min(value= 1, message= "the price must be 1 or higher.")
	@Column(name = "price")
	private Integer price;
	
	public Pizza() {}
	
	public Pizza(String name, String description, int price) {
		setName(name);
		setDescription(description);
		setPrice(price);
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return this.name;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	public String getDescription() {
		return this.description;
	}
	
	public void setPrice(Integer price) {
		this.price = price;
	}
	public Integer getPrice() {
		return this.price;
	}
}

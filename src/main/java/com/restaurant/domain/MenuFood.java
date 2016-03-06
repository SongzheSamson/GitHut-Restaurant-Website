package com.restaurant.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Table(name="MENU_FOOD")
public class MenuFood {
	@Id
	@Column(name = "ID")
	@GeneratedValue
	private Integer id;
	
	@DecimalMin("0")
	@NotNull
	private Double price;
	
	@ManyToOne
	@JoinColumn(name = "FOOD_FOODID")
	private Food food;
	
	
	@ManyToOne
	@JoinColumn(name = "MENU_MENUID")
	private Menu menu;


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Double getPrice() {
		return price;
	}


	public void setPrice(Double price) {
		this.price = price;
	}


	public Food getFood() {
		return food;
	}


	public void setFood(Food food) {
		this.food = food;
	}


	public Menu getMenu() {
		return menu;
	}


	public void setMenu(Menu menu) {
		this.menu = menu;
	}


	@Override
	public String toString() {
		return "MenuFood [Id=" + id + ", price=" + price + ", food=" + food + ", menu=" + menu + "]";
	}
	
	
}

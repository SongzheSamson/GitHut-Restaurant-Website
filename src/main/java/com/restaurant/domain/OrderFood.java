package com.restaurant.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="ORDER_FOOD")
public class OrderFood {
	@Id
	@Column(name = "ID")
	@GeneratedValue
	private Integer id;
	@ManyToOne
	@JoinColumn(name = "FOOD_FOODID")
	private Food food;
	@ManyToOne
	@JoinColumn(name = "ORDER1_ORDERID")
	private Order order;
	
	@DecimalMin("1")
	@NotNull
	private Integer number = 1;
	
	private Double price;
	
	
	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Food getFood() {
		return food;
	}

	public void setFood(Food food) {
		this.food = food;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	@Override
	public String toString() {
		return "OrderFood [id=" + id + ", food=" + food + ", order=" + order + ", number=" + number + ", price=" + price
				+ "]";
	}

	
	
	
}

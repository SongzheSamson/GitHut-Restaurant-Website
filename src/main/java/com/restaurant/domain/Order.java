package com.restaurant.domain;


import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "ORDER1")
public class Order {
	@Id
	@Column(name = "orderId")
	@GeneratedValue
	private Integer orderId;

	@NotEmpty
	private String type;

	@DateTimeFormat(style = "S-")

	private Date orderTime = new Date();

	private Double totlePrice;
	@NotEmpty
	private String customerName;
	@NotEmpty
	private String address;
	@NotEmpty
	private String phoneNumber;
	@OneToMany(cascade = { CascadeType.ALL }, mappedBy = "order", fetch = FetchType.EAGER)
	private Set<OrderFood> orderFoods = new HashSet<OrderFood>();
	
	@Transient
	private ArrayList<OrderFood> orderFoodList = new ArrayList<>();
	
	
	public Order() {
		super();
	}
	public void addOrderFoodToList (OrderFood orderFood){
		orderFoodList.add(orderFood);
		
		this.addOrderFood(orderFood);
	}
	public void removeOrderFoodToList(OrderFood orderFood){
		orderFoodList.remove(orderFood);
		
		this.removeOrderFood(orderFood);
	}

	public ArrayList<OrderFood> getOrderFoodList() {
		return orderFoodList;
	}

	public void setOrderFoodList(ArrayList<OrderFood> orderFoodList) {
		this.orderFoodList = orderFoodList;
	}

	public void addOrderFood(OrderFood orderFood) {
		orderFoods.add(orderFood);
	}

	public void removeOrderFood(OrderFood orderFood) {
		orderFoods.remove(orderFood);
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Date getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(Date orderTime) {
		this.orderTime = orderTime;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Set<OrderFood> getOrderFoods() {
		return orderFoods;
	}

	public void setOrderFoods(Set<OrderFood> orderFoods) {
		this.orderFoods = orderFoods;
	}



	public Double getTotlePrice() {
		DecimalFormat df2 = new DecimalFormat("00.00");
		
		return Double.parseDouble(df2.format(totlePrice));
	}

	public void setTotlePrice(Double totlePrice) {
		this.totlePrice = totlePrice;
	}

	

}

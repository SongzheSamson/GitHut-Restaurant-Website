package com.restaurant.domain;

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

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="MENU")
public class Menu {
	@Id
	@Column(name="menuId")
	@GeneratedValue
	private Integer menuId;
	
	@NotEmpty
	private String menuName;
	
	@DateTimeFormat(style = "S-")
	private Date editTime = new Date();
	
	@NotEmpty
	private String description;
	
	
	private boolean avaliable ;
	
	
	private boolean orderable ;
	
	public Menu() {
		super();
	}

	@OneToMany(cascade = {CascadeType.ALL}, mappedBy = "menu", fetch = FetchType.EAGER)
	private Set<MenuFood> menuFood = new HashSet<MenuFood>();

	public void addMenuFood(MenuFood menufood){
		menuFood.add(menufood);
	}
	public void removeMenuFood(MenuFood menufood){
		menuFood.remove(menufood);
	}
	public Set<MenuFood> getMenuFood() {
		return menuFood;
	}

	public void setMenuFood(Set<MenuFood> menuFood) {
		this.menuFood = menuFood;
	}

	public Menu( String menuName, Date editTime) {
		super();
		
		this.menuName = menuName;
		this.editTime = editTime;
	}

	public Integer getMenuId() {
		return menuId;
	}

	public void setMenuId(Integer menuId) {
		this.menuId = menuId;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public Date getEditTime() {
		return editTime;
	}

	public void setEditTime(Date editTime) {
		this.editTime = editTime;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
	
	public boolean getAvaliable() {
		return avaliable;
	}
	public void setAvaliable(boolean avaliable) {
		this.avaliable = avaliable;
	}
	public boolean getOrderable() {
		return orderable;
	}
	public void setOrderable(boolean orderable) {
		this.orderable = orderable;
	}
	@Override
	public String toString() {
		return "Menu [menuId=" + menuId + ", menuName=" + menuName + ", editTime=" + editTime + "]";
	}
	
	
	
}

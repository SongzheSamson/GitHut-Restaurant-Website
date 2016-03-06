package com.restaurant.domain;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

@Table(name="food")
@Entity
public class Food {
	@Id
	@Column(name = "foodId")
	@GeneratedValue
	private Integer foodId;

	@NotEmpty
	private String foodName;
	@NotEmpty
	private String foodType;
	@NotEmpty
	private String descrption;
	@NotEmpty
	private String material;
	
	@Transient
	private MultipartFile photo;
	
	@Lob private byte[] photoBytes;
	
	private String photoContentType; 
	
	private String photoFilename;
	
	@OneToMany( mappedBy = "food", fetch = FetchType.EAGER )
	private Set<MenuFood> menuFood = new HashSet<MenuFood>();
	
	@OneToMany(mappedBy = "food", fetch = FetchType.EAGER)
	private Set<OrderFood> orderFood = new HashSet<OrderFood>();
	
	public void removeMenuFood(MenuFood menufood){
		menuFood.remove(menufood);
	}
	public Set<MenuFood> getMenuFood() {
		return menuFood;
	}

	public void setMenuFood(Set<MenuFood> menuFood) {
		this.menuFood = menuFood;
	}

	public Integer getFoodId() {
		return foodId;
	}

	public void setFoodId(Integer foodId) {
		this.foodId = foodId;
	}

	public MultipartFile getPhoto() {
		return photo;
	}

	public void setPhoto(MultipartFile photo) {
		this.photo = photo;
		
		setPhotoContentType(photo.getContentType());
		setPhotoFilename(photo.getOriginalFilename());
		try {
			setPhotoBytes(photo.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public byte[] getPhotoBytes() {
		return photoBytes;
	}

	public void setPhotoBytes(byte[] photoBytes) {
		this.photoBytes = photoBytes;
	}

	public String getPhotoContentType() {
		return photoContentType;
	}

	public void setPhotoContentType(String photoContentType) {
		this.photoContentType = photoContentType;
	}

	public String getPhotoFilename() {
		return photoFilename;
	}

	public void setPhotoFilename(String photoFilename) {
		this.photoFilename = photoFilename;
	}

	public Integer assignId() {
		this.foodId = idSequence.incrementAndGet();
		return foodId;
	}

	private static final AtomicInteger idSequence = new AtomicInteger();

	public String getFoodName() {
		return foodName;
	}

	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}

	public String getFoodType() {
		return foodType;
	}

	public void setFoodType(String foodType) {
		this.foodType = foodType;
	}

	public String getDescrption() {
		return descrption;
	}

	public void setDescrption(String descrption) {
		this.descrption = descrption;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	@Override
	public String toString() {
		return "Food [foodId=" + foodId + ", foodName=" + foodName + ", foodType=" + foodType + ", descrption="
				+ descrption + ", material=" + material + ", photo=" + photo + ", " + ", photoContentType=" + photoContentType + ", photoFilename="
				+ photoFilename + "]";
	}

	
	
	

}
